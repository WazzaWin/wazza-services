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
package com.wazzawin.service;

import com.wazzawin.exception.IllegalParameterFault;
import com.wazzawin.exception.ResourceNotFoundFault;
import com.wazzawin.responce.user.WazzaUserDTO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Public interface to define the service operations mapped via REST using CXT
 * framework.
 *
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public interface WazzaWSRestService {

    static final String WAZZA_USER_PATH = "/wazza_user/";

// <editor-fold defaultstate="collapsed" desc="WazzaUser">
// ==========================================================================
// === User
// ==========================================================================
    /**
     *
     * @param userName
     * @return the WazzaUserDTO without the associated relations
     * @throws ResourceNotFoundFault
     */
    @GET
    @Path(WAZZA_USER_PATH + "getSimpleUser/{username}")
    @Consumes({MediaType.APPLICATION_JSON})
    WazzaUserDTO getSimpleUser(@PathParam("userName") String userName)
            throws ResourceNotFoundFault;

    /**
     *
     * @param userName
     * @return the WazzaUserDTO with all the associated relations
     * @throws ResourceNotFoundFault
     */
    @GET
    @Path(WAZZA_USER_PATH + "getFullUser/{userName}")
    @Consumes({MediaType.APPLICATION_JSON})
    WazzaUserDTO getFullUser(@PathParam("userName") String userName)
            throws ResourceNotFoundFault, IllegalParameterFault;

    @GET
    @Path(WAZZA_USER_PATH + "getAll")
    @Consumes(MediaType.APPLICATION_JSON)
    List<WazzaUserDTO> getAllWazzaUsers();

    /**
     * Insert a WazzaUser.
     *
     * @param wazzaUser the WazzaUser user to insert
     * @return the WazzaUser ID
     * @throws IllegalParameterFault if there is a duplicate WazzaUser
     */
    @PUT
    @Path(WAZZA_USER_PATH + "insertWazzaUser")
    @Consumes(MediaType.APPLICATION_JSON)
    Response insertWazzaUser(WazzaUserDTO wazzaUser)
            throws IllegalParameterFault;

    /**
     * Insert a WazzaUserDTO.
     *
     * @param wazzaUser the WazzaUser to insert
     * @return the WazzaUser ID
     * @throws IllegalParameterFault if there is a duplicate User
     */
    @PUT
    @Path(WAZZA_USER_PATH + "insertOrUpdateWazzaUserDTO")
    @Consumes(MediaType.APPLICATION_JSON)
    Long insertOrUpdateWazzaUserDTO(WazzaUserDTO wazzaUserDTO)
            throws IllegalParameterFault, ResourceNotFoundFault;

    /**
     * Delete a WazzaUser by ID. Delete his associated relations.
     *
     * @param wazzaUserID the WazzaUser ID
     * @throws ResourceNotFoundFault if WazzaUser is not found
     */
    @DELETE
    @Path(WAZZA_USER_PATH + "delete/{wazzaUserID}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response deleteWazzaUser(@PathParam("wazzaUserID") Long wazzaUserID)
            throws ResourceNotFoundFault;
    // </editor-fold>
}
