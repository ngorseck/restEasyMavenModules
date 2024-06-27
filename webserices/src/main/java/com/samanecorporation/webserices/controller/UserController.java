package com.samanecorporation.webserices.controller;

import com.samanecorporation.metier.dto.UserDto;
import com.samanecorporation.metier.service.IUserService;
import com.samanecorporation.metier.service.UserService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

    private final IUserService userService = new UserService();

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(UserDto userDto) {

        userService.save(userDto);
        return Response.status(201).entity(userDto).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(UserDto userDto,@PathParam("id") int id) {
        userDto.setId(id);
        userService.update(userDto);
        return Response.status(200).entity(userDto).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {

        UserDto userDto = userService.get(id);
        return Response.status(200).entity(userDto).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response all() {

        return Response.status(200).entity(userService.getAll()).build();
    }
}
