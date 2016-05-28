package com.appspot.krishnacgh.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.appspot.krishnacgh.messenger.model.Link;
import com.appspot.krishnacgh.messenger.model.Message;
import com.appspot.krishnacgh.messenger.resources.bean.BeanParamObj;
import com.appspot.krishnacgh.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	public MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam BeanParamObj beanParam){
		if(beanParam.getYear()>0){
			return messageService.getAllMessagesForYear(beanParam.getYear());
		}
		if(beanParam.getStart()>=0 && beanParam.getSize()>0){
			return messageService.getAllMessagesWithStartAndSize(beanParam.getStart(), beanParam.getSize());
		}
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		Message message = messageService.getMessage(id);
		String uriComments = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getComments").resolveTemplate("messageId", (Long)message.getId()).build().toString();
		String uriProfile = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(ProfileResource.class,"getProfile").resolveTemplate("profileName", message.getAuthor()).build().toString();
		String uriSelf = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getMessage").resolveTemplate("messageId", (Long)message.getId()).build().toString();
		if(message.getLinkList().size()==0){
			Link commentLink = new Link();
			Link profileLink = new Link();
			Link selfLink = new Link();
			commentLink.setLink(uriComments);
			commentLink.setRel("comments");
			profileLink.setLink(uriProfile);
			profileLink.setRel("profile");
			selfLink.setLink(uriSelf);
			selfLink.setRel("self");
			message.getLinkList().add(commentLink);
			message.getLinkList().add(profileLink);
			message.getLinkList().add(selfLink);
		}
		return message;
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_XML)
	public Message getMessageXml(@PathParam("messageId") long id, @Context UriInfo uriInfo){
		Message message = messageService.getMessage(id);
		String uriComments = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getComments").resolveTemplate("messageId", (Long)message.getId()).build().toString();
		String uriProfile = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(ProfileResource.class,"getProfile").resolveTemplate("profileName", message.getAuthor()).build().toString();
		String uriSelf = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class, "getMessage").resolveTemplate("messageId", (Long)message.getId()).build().toString();
		if(message.getLinkList().size()==0){
			Link commentLink = new Link();
			Link profileLink = new Link();
			Link selfLink = new Link();
			commentLink.setLink(uriComments);
			commentLink.setRel("comments");
			profileLink.setLink(uriProfile);
			profileLink.setRel("profile");
			selfLink.setLink(uriSelf);
			selfLink.setRel("self");
			message.getLinkList().add(commentLink);
			message.getLinkList().add(profileLink);
			message.getLinkList().add(selfLink);
		}
		return message;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message message, @Context UriInfo uriInfo){
		Message newMessage = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(((Long)newMessage.getId()).toString()).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	public Response addMessageXml(Message message, @Context UriInfo uriInfo){
		Message newMessage = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(((Long)newMessage.getId()).toString()).build();
		return Response.created(uri).entity(newMessage).build();
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageId") long id){
		return messageService.deleteMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComments(){
		return new CommentResource();
	}
}
