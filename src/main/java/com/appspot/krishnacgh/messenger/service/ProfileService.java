package com.appspot.krishnacgh.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.appspot.krishnacgh.messenger.database.DatabaseClass;
import com.appspot.krishnacgh.messenger.model.Profile;

public class ProfileService {
	
	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setProfileId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName){
		return profiles.remove(profileName);
	}
}
