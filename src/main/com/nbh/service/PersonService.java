package com.nbh.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nbh.domain.entity.demo.Person;
import com.nbh.service.constants.WebServiceConstants;


@WebService(serviceName = "personServices", targetNamespace = WebServiceConstants.HOST_ADDRESS + "nbh/spring-cxf-rest/services")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces({ MediaType.APPLICATION_JSON })
@Path("/persons")
public interface PersonService {

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/person/{id}")
	public Person getPerson(@PathParam("id") String id);
	
}
