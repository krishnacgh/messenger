package com.appspot.krishnacgh.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.appspot.krishnacgh.messenger.model.Comment;
import com.appspot.krishnacgh.messenger.model.Message;
import com.appspot.krishnacgh.messenger.model.Profile;

public class DatabaseClass {
	
	static Map<Long, Message> messages = new HashMap<Long, Message>();
	static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	static{
		Message m1 = new Message(1L,"Hello World", "Krishna");
		Message m2 = new Message(2L,"Hello World 2", "Swaroop");
		Comment c1 = new Comment(1L,"Yenappa HW","Srinivas");
		Comment c2 = new Comment(2L,"Yenu Illappa HW","Hanasoge");
		Comment c3 = new Comment(3L,"Yenappa HW2","Vishalakshi");
		Comment c4 = new Comment(4L,"Yenu Illappa HW2","Ramnath");
		m1.getComments().put(1L, c1);
		m1.getComments().put(2L, c2);
		m2.getComments().put(3L, c3);
		m2.getComments().put(4L, c4);
		messages.put(1L, m1);
		messages.put(2L, m2);
		
		Profile p1 = new Profile(1L,"kgowrang", "Krishna", "Hanasoge");
		Profile p2 = new Profile(2L,"shanasoge", "Swaroop", "Hanasoge");
		profiles.put("kgowrang", p1);
		profiles.put("shanasoge", p2);
	}
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
