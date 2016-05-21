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

import com.appspot.krishnacgh.messenger.model.Profile;
import com.appspot.krishnacgh.messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	public ProfileService profileService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName){
		return profileService.getProfile(profileName);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateMessage(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile deleteProfile(@PathParam("profileName") String profileName){
		return profileService.deleteProfile(profileName);
	}
	
}
