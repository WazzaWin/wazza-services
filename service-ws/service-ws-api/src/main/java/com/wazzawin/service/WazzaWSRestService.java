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
