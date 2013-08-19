package com.wazzawin.services;

import com.wazzawin.crypt.WazzaByteDigester;
import com.wazzawin.dao.interf.user.IWazzaUserDAO;
import com.wazzawin.exception.IllegalParameterFault;
import com.wazzawin.exception.ResourceNotFoundFault;
import com.wazzawin.responce.user.WazzaUserDTO;
import com.wazzawin.service.WazzaWSRestService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Web Service implementation of {@link WazzaWSRestService} endpoint.
 *
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Service("wazzaWSRestService")
public class WazzaWSRestServiceImpl implements WazzaWSRestService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WazzaByteDigester wazzaByteDigester;
    @Autowired
    private DozerBeanMapper mapper;
    //
    private IWazzaUserDAO wazzaUserDAO;
    // Delegate
    private WazzaUserServiceImpl wazzaUserServiceDelegate;

    /**
     * Default constructor create each service delegate.
     */
    public WazzaWSRestServiceImpl() {
        this.wazzaUserServiceDelegate = new WazzaUserServiceImpl();
    }

    @PostConstruct
    public void initProperty() {
        wazzaUserServiceDelegate.setWazzaByteDigester(this.wazzaByteDigester);
        wazzaUserServiceDelegate.setMapper(this.mapper);
    }

    /**
     * @param userDAO the userDAO to set
     */
    @Autowired
    public void setWazzaUserDAO(IWazzaUserDAO wazzaUserDAO) {
        this.wazzaUserDAO = wazzaUserDAO;
        this.wazzaUserServiceDelegate.setWazzaUserDAO(wazzaUserDAO);
    }

    /**
     * @see GSSMWSRestService#getSimpleUser(java.lang.String)
     */
    @Override
    public WazzaUserDTO getSimpleUser(String userName) throws ResourceNotFoundFault {
        logger.debug("Username to retrieve: " + userName);
        WazzaUserDTO wazzaUserDTO = this.wazzaUserServiceDelegate.getUser(userName);
        if (wazzaUserDTO == null) {
            throw new ResourceNotFoundFault("Can't find user with username: " + userName);
        }
        return wazzaUserDTO;
    }

    /**
     * @see GSSMWSRestService#getFullUser(java.lang.String)
     */
    @Override
    public WazzaUserDTO getFullUser(String userName) throws ResourceNotFoundFault,
            IllegalParameterFault {
        logger.debug("Username to retrieve: " + userName);
        WazzaUserDTO user = this.wazzaUserServiceDelegate.getUser(userName);
        if (user == null) {
            throw new ResourceNotFoundFault("Can't find user with username: " + userName);
        }
        //TODO: Add all the wazzaUser relations
//        user.setProfileDTO(profileServiceDelegate.getUserProfile(userName));
        return user;
    }

    @Override
    public List<WazzaUserDTO> getAllWazzaUsers() {
        return this.wazzaUserServiceDelegate.getAllUsers();
    }

    @Override
    public Response insertWazzaUser(WazzaUserDTO wazzaUser) throws IllegalParameterFault {
        this.wazzaUserServiceDelegate.insertUser(wazzaUser);
        return Response.status(Response.Status.OK).build();
    }

    @Override
    public Long insertOrUpdateWazzaUserDTO(WazzaUserDTO wazzaUserDTO) throws IllegalParameterFault, ResourceNotFoundFault {
        return this.wazzaUserServiceDelegate.insertOrUpdateUserDTO(wazzaUserDTO);
    }

    @Override
    public Response deleteWazzaUser(Long wazzaUserID) throws ResourceNotFoundFault {
        this.wazzaUserServiceDelegate.deleteUser(wazzaUserID);
        return Response.status(Response.Status.OK).build();
    }
}
