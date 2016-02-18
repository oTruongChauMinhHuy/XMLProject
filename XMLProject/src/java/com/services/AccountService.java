/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.services;

import com.util.DBUtilities;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author HuyTCM - Trương Châu Minh Huy
 */
@Path("acc")
public class AccountService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountService
     */
    public AccountService() {
    }
    @Path("/checkLogin")
    @GET
    @Produces("text/plain")
    public String checkLogin(@QueryParam("username") String username,
                             @QueryParam("password") String password) {
//        boolean result = DBUtilities.checkLogin(username, password);
//        if (result) {
//            return "true";
//        }
//        return "false";
        return "true";
    }

    /**
     * Retrieves representation of an instance of com.services.AccountService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AccountService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    }
}
