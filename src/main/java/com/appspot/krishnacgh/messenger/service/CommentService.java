package com.appspot.krishnacgh.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.appspot.krishnacgh.messenger.database.DatabaseClass;
import com.appspot.krishnacgh.messenger.model.Comment;
import com.appspot.krishnacgh.messenger.model.ErrorMessage;
import com.appspot.krishnacgh.messenger.model.Message;

public class CommentService {
	
	Map<Long, Message> messageList = DatabaseClass.getMessages();
	
	public CommentService(){
		
	}
	
	public List<Comment> getComments(long messageId){
		return new ArrayList<Comment>(messageList.get(messageId).getComments().values());
	}
	
	public Comment getComment(long messageId, long commentId){
		Message message = messageList.get(messageId);
		if(message == null){
			ErrorMessage errorMessage = new ErrorMessage("Web Application Message error",500,"http://krishnacgh.appspot.com");
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(errorMessage).build());
		}
		Comment comment = message.getComments().get(commentId);
		if(comment == null){
			ErrorMessage errorMessage = new ErrorMessage("Web Application Comment error",500,"http://krishnacgh.appspot.com");
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(errorMessage).build());
		}
		return comment;
	}
	
	public Comment addComment(long messageId, Comment comment){
		long commentSize = messageList.get(messageId).getComments().size();
		comment.setId(commentSize+1);
		return messageList.get(messageId).getComments().put(comment.getId(), comment);
	}
	
	public Comment updateComment(long messageId, Comment comment){
		return messageList.get(messageId).getComments().put(comment.getId(), comment);
	}
	
	public Comment deleteComment(long messageId, long commentId){
		return messageList.get(messageId).getComments().remove(commentId);
	}

}
