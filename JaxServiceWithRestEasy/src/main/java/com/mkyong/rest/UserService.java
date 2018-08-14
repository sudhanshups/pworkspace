package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name,
			@FormParam("age") int age) {

		return Response.status(200)
				.entity("addUser is called, name : " + name + ", age : " + age)
				.build();

	}
	
	//http://localhost:8080/RESTfulExample/rest/user/query?from=10&to=100&orderBy=lol,lolz
	@GET
	@Path("/query")
	public String getUsers(
		@QueryParam("from") int from,
		@DefaultValue("999")@QueryParam("to") int to,
		@QueryParam("orderBy") List<String> orderBy) {

		return "\nfrom is : " + from + "\n" + " to is : " + to + "\n order by is " + orderBy;

	}

}