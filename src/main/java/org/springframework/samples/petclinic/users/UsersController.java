/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.samples.petclinic.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author pablo
 */
@Controller
public class UsersController {
	private final UserReposiroty users;
	
	public UsersController(UserReposiroty clinicService){
		this.users = clinicService;
	}
	    
	@GetMapping("/users")
	public String users(/*User user, BindingResult result, Map<String, Object> model*/) {
		List<User> results = (List<User>) this.users.findAll();
		System.out.println("R: " + results);
		return "/newUser";
	}
}
