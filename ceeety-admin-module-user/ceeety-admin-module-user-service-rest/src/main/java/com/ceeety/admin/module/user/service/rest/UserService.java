/**
 * 
 */
package com.ceeety.admin.module.user.service.rest;

import java.util.Collection;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ceeety.admin.module.user.model.User;

/**
 * @author Zhiyi-Bai
 * @date 2017年6月28日
 */
@Produces(MediaType.APPLICATION_JSON)
public interface UserService {
    
    @GET
    @Path("/{offset}/{limit}")
    public Collection<User> getUsers(@PathParam("offset") Integer offset, @PathParam("limit") Integer limit);
    
    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") Integer id);
    
    @POST
    @Path("/")
    public int addUser(User user);
    
    @PUT
    @Path("/")
    public int updateUser(User user);
    
    @DELETE
    @Path("/{id}")
    public int deleteUser(@PathParam("id") Integer id);

}
