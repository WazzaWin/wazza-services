/*
 *  wazza-services
 *  WazzaWins Services
 *  https://github.com/WazzaWin/wazza-services
 * ====================================================================
 *
 * Copyright (C) 2012-2013 WazzaWin Developer Group (WazzaWin Team - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
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
