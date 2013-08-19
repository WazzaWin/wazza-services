package com.wazzawin.services;

import com.google.common.collect.Lists;
import com.wazzawin.core.model.user.WazzaUser;
import com.wazzawin.crypt.WazzaByteDigester;
import com.wazzawin.dao.interf.user.IWazzaUserDAO;
import com.wazzawin.exception.IllegalParameterFault;
import com.wazzawin.exception.ResourceNotFoundFault;
import com.wazzawin.responce.user.WazzaUserDTO;
import com.wazzawin.service.WazzaWSRestService;
import com.wazzawin.shared.utils.WazzaUtils;
import java.util.Collections;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * WazzaUser service delegate.
 *
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
class WazzaUserServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private WazzaByteDigester wazzaByteDigester;
    private DozerBeanMapper mapper;
    // DAO
    private IWazzaUserDAO wazzaUserDAO;

    //<editor-fold defaultstate="collapsed" desc="Setter methods">
    /**
     * @param userDao the userDao to set
     */
    public void setWazzaUserDAO(IWazzaUserDAO wazzaUserDAO) {
        this.wazzaUserDAO = wazzaUserDAO;
    }

    public void setWazzaByteDigester(WazzaByteDigester wazzaByteDigester) {
        this.wazzaByteDigester = wazzaByteDigester;
    }

    public void setMapper(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }
    //</editor-fold>

    /**
     * @see WazzaWSRestService#getSimpleUser(java.lang.String) 
     */
    public WazzaUserDTO getUser(String userName) {
        logger.debug("Username to find: " + userName);
        WazzaUser wazzaUser = wazzaUserDAO.findByUserName(userName);
        return this.mapper.map(wazzaUser, WazzaUserDTO.class);
    }

    /**
     * @see WazzaWSRestService#getAllWazzaUsers() 
     */
    public List<WazzaUserDTO> getAllUsers() {
        List<WazzaUser> wazzaUserList = wazzaUserDAO.findAll();
        List<WazzaUserDTO> wazzaUserDTOList = Lists.<WazzaUserDTO>newArrayList();
        for (WazzaUser wazzaUser : WazzaUtils.safeList(wazzaUserList)) {
            wazzaUserDTOList.add(this.mapper.map(wazzaUser, WazzaUserDTO.class));
        }
        return wazzaUserDTOList;
    }

    /**
     * @see
     * WazzaWSRestService#insertWazzaUser(com.wazzawin.responce.user.WazzaUserDTO) 
     */
    public Long insertUser(WazzaUserDTO wazzaUserDTO)
            throws IllegalParameterFault {
        this.checkWazzaUserDTO(wazzaUserDTO);
        try {
            this.checkDuplicateUser(wazzaUserDTO.getUserName());
        } catch (IllegalParameterFault ilp) {
            throw ilp;
        }
        wazzaUserDTO.setPassword(wazzaByteDigester.gsDigest(wazzaUserDTO.getPassword()));
        WazzaUser wazzaUser = this.mapper.map(wazzaUserDTO, WazzaUser.class);
        wazzaUser = wazzaUserDAO.persist(wazzaUser);
        return wazzaUser.getId();
    }

    /**
     * @see
     * WazzaWSRestService#insertOrUpdateWazzaUserDTO(com.wazzawin.responce.user.WazzaUserDTO)
     */
    @Transactional
    public Long insertOrUpdateUserDTO(WazzaUserDTO wazzaUserDTO)
            throws IllegalParameterFault, ResourceNotFoundFault {
        this.checkWazzaUserDTO(wazzaUserDTO);
        Long idToReturn;
        if (wazzaUserDTO.getId() != null) {
            idToReturn = this.updateWazzaUserDTO(wazzaUserDTO);
        } else {
            this.checkDuplicateUser(wazzaUserDTO.getUserName());
            WazzaUser wazzaUser = this.mapper.map(wazzaUserDTO, WazzaUser.class);
            wazzaUser.setPassword(wazzaByteDigester.gsDigest(wazzaUserDTO.getPassword()));
            wazzaUserDAO.persist(wazzaUser);
            //TODO: insertOrUpdateWazzaUserAssociations
            idToReturn = wazzaUser.getId();
        }
        return idToReturn;
    }

    private void updatePwdIfNecessary(WazzaUser existingUser, String newPassword) {
        if (newPassword != null && !existingUser.getPassword().equals(newPassword)) {
            existingUser.setPassword(wazzaByteDigester.gsDigest(newPassword));
        }
    }

    private void checkDuplicateUser(String userName) throws IllegalParameterFault {
        if (wazzaUserDAO.findByUserName(userName) != null) {
            throw new IllegalParameterFault("WazzaUser with userName \""
                    + userName + "\" already exists");
        }
    }

    /**
     * @see
     * WazzaWSRestService#insertOrUpdateWazzaUserDTO(com.wazzawin.responce.user.WazzaUserDTO)
     */
    public Long updateWazzaUser(WazzaUser wazzaUser)
            throws ResourceNotFoundFault, IllegalParameterFault {
        if (wazzaUser.getId() == null) {
            throw new IllegalArgumentException("WazzaUser \"ID\" must be NOT NULL");
        }
        WazzaUser orig = this.getWazzaUserById(wazzaUser.getId());
        this.checkWazzaUser(orig);

        // Set the values (except username and property not managed)
        String userName = wazzaUser.getUserName();
        if (userName != null) {
            orig.setUserName(userName);
        }
        orig.setEnabled(wazzaUser.isEnabled());
        this.updatePwdIfNecessary(orig, wazzaUser.getPassword());
        this.wazzaUserDAO.update(orig);
        return orig.getId();
    }

    public Long updateWazzaUserDTO(WazzaUserDTO wazzaUserDTO)
            throws ResourceNotFoundFault, IllegalParameterFault {
        if (wazzaUserDTO.getId() == null) {
            throw new IllegalArgumentException("WazzaUser \"ID\" must be NOT NULL");
        }
        WazzaUser orig = this.getWazzaUserById(wazzaUserDTO.getId());
        this.checkWazzaUser(orig);

        // Set the values (except username and property not managed)
        String userName = wazzaUserDTO.getUserName();
        if (userName != null) {
            orig.setUserName(userName);
        }
        orig.setEnabled(wazzaUserDTO.getEnabled());
        this.updatePwdIfNecessary(orig, wazzaUserDTO.getPassword());
        wazzaUserDAO.update(orig);
        //TODO: insertOrUpdateWazzaUserAssociations
        return orig.getId();
    }

    private void checkWazzaUserDTO(WazzaUserDTO userDTO) throws IllegalParameterFault {
        if (userDTO == null) {
            throw new IllegalParameterFault("User must be NOT NULL.");
        }
        if (userDTO.getUserName() == null || userDTO.getUserName().trim().equals("")) {
            throw new IllegalParameterFault("User name must be NOT NULL or NOT empty.");
        }
    }

    private void checkWazzaUser(WazzaUser user) throws IllegalParameterFault {
        if (user == null) {
            throw new IllegalParameterFault("User must be NOT NULL.");
        }
        if (user.getUserName() == null || user.getUserName().trim().equals("")) {
            throw new IllegalParameterFault("User name must be NOT NULL or NOT empty.");
        }
    }

    private WazzaUser getWazzaUserById(Long wazzaUserID) throws ResourceNotFoundFault {
        assert (wazzaUserID != null) : "Impossible to retrieve wazzaUser because id is null";
        WazzaUser wazzaUser = wazzaUserDAO.find(wazzaUserID);
        if (wazzaUser == null) {
            throw new ResourceNotFoundFault("WazzaUser not found", wazzaUserID);
        }
        return wazzaUser;
    }

    /**
     * @see WazzaWSRestService#deleteWazzaUser(java.lang.Long) 
     */
    public void deleteUser(Long wazzaUserID) throws ResourceNotFoundFault {
        this.getWazzaUserById(wazzaUserID);
//      TODO: Remove all the existing relations to the wazzaUser removed
        wazzaUserDAO.delete(wazzaUserID);
    }

}
