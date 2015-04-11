package pt.gnr.gestaoescalas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pt.gnr.gestaoescalas.domain.User;

@Controller
@RequestMapping("/users")
public class UsersController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User("Fonix", 1, "fonix@email.com"));
		users.add(new User("paulo", 2, "paulo@email.com"));
		
		return users;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{userName}")
	public @ResponseBody User getUser(@PathVariable("userName") String userName) {
		User user = null;
		
		if(userName.equals("fonix")) {
			user = new User("Fonix", 1, "fonix@email.com");
		} else {
			user = new User("paulo", 2, "paulo@email.com");
		}
		
		
		return user;
	}
	
}