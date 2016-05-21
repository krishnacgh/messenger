package com.appspot.krishnacgh.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.appspot.krishnacgh.messenger.model.Message;
import com.appspot.krishnacgh.messenger.model.Profile;

public class DatabaseClass {
	
	static Map<Long, Message> messages = new HashMap<Long, Message>();
	static Map<String, Profile> profiles = new HashMap<String, Profile>();
	
	static{
		Message m1 = new Message(1L,"Hello World", "Krishna");
		Message m2 = new Message(2L,"Hello World 2", "Swaroop");
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
