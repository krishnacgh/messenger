package com.appspot.krishnacgh.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.appspot.krishnacgh.messenger.database.DatabaseClass;
import com.appspot.krishnacgh.messenger.model.Message;

public class MessageService {
	
	Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageList = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year)
				messageList.add(message);
		}
		return messageList;
	}
	
	public List<Message> getAllMessagesWithStartAndSize(int start, int size){
		List<Message> messageList = new ArrayList<Message>();
		for(Message message : messages.values()){
				messageList.add(message);
		}
		return messageList.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	//Just to track on Git
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message){
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message deleteMessage(long id){
		return messages.remove(id);
	}
	
	

}
