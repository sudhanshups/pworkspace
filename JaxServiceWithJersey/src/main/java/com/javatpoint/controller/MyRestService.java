package com.javatpoint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.javatpoint.model.Employee;
import com.javatpoint.model.Message;

@Path("service")
public class MyRestService {

	@GET
	public String hello() {
		return "Hello from jax service";
	}

	@GET
	@Path("/hi")
	public String hi() {
		return "Hi from jax service";
	}

	// Path Param example
	@GET
	@Path("/msg/{message}")
	public String getMsg(@PathParam("message") String msg) {
		String output = "Jersey say : " + msg;
		return output;
	}

	// http://localhost:8080/SpringJaxService/rest/service/query?from=10&to=100&orderBy=lol,lolz
	// http://localhost:8080/SpringJaxService/rest/service/query?from=10&to=100&orderBy=lol&orderBy=lolz
	@GET
	@Path("/query")
	public String getUsers(@QueryParam("from") int from, @DefaultValue("999") @QueryParam("to") int to,
			@QueryParam("orderBy") List<String> orderBy) {

		return "\nfrom is : " + from + "\n" + " to is : " + to + "\n order by is " + orderBy;

	}

	/*
	 * @MatrixParam example Matrix parameters are a set of “name=value” in URI
	 * path, for example /books/2011;author=mkyong
	 */
	@GET
	@Path("/books/{book}")
	public String getBookInfo(@PathParam("book") String book, @MatrixParam("author") String author,
			@MatrixParam("year") String year) {
		String output = "Jersey say  : " + book + " author is " + author;
		return output;
	}

	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name, @FormParam("age") int age) {

		return Response.status(200).entity("Add User is called, name : " + name + ", age : " + age).build();

	}

	@GET
	@Path("/handle")
	public String handle(@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String name = request.getParameter("name");
		String surname = (String) request.getSession().getAttribute("surname");
		// respone object can be used to set cookie variable

		return "hey " + name + " " + surname;
	}

	//localhost:8080/SpringJaxService/rest/service/name/shadab/id/35/show
	@GET
	@Path("/name/{name}/id/{id}/show")
	@Produces(MediaType.APPLICATION_XML)
	public Employee processSubmit(@BeanParam Employee e) {
		return e;
	}
	
	@POST
	@Path("/saypost")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message processPost(Message msg) {
		return msg;
	}
}
