package com.appspot.krishnacgh.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.appspot.krishnacgh.messenger.model.Comment;
import com.appspot.krishnacgh.messenger.service.CommentService;

@Path("/")
public class CommentResource {
	
	CommentService commentService = new CommentService();
	
	public CommentResource(){
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Comment> getComments(@PathParam("messageId") long messageId){
		return commentService.getComments(messageId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Comment deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
		return commentService.deleteComment(messageId, commentId);
	}
	
	

}
