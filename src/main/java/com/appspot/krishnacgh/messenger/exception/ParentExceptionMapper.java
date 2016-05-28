package com.appspot.krishnacgh.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.appspot.krishnacgh.messenger.model.ErrorMessage;

public class ParentExceptionMapper implements ExceptionMapper<Exception>{

	@Override
	public Response toResponse(Exception exception) {
		ErrorMessage errorMessage = new ErrorMessage("Something Kanayya",500,"http://krishnacgh.appspot.com");
		return Response.status(Status.NOT_ACCEPTABLE).entity(errorMessage).build();
	}

}
