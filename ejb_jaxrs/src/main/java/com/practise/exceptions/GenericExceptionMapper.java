package com.practise.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.practise.data.ErrorMessage;

//@Provider--enable to use generic errors, else create your own custom exceptions
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		ErrorMessage er=new ErrorMessage(ex.getMessage(),500,"www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(er).build();
	}

	

}