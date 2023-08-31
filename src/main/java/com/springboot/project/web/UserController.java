package com.springboot.project.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.project.model.User;
import com.springboot.project.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/friends")
	public String showFriendsList(Model model, Principal principal) {
	    // Get the logged-in user based on the principal's email
	    User loggedInUser = userService.findByEmail(principal.getName());

	    // Get the friends of the logged-in user
	    List<User> friends = loggedInUser.getFriends();

	    model.addAttribute("friends", friends);
	    return "friends_list";
	}
	
	@GetMapping("/search")
	public String searchUser(User user, Model model, String keyword) {
	    if (keyword != null && !keyword.isEmpty()) {
	        List<User> friends = userService.getUserByKeyword(keyword);  // Update variable name
	        model.addAttribute("friends", friends);  // Update attribute name
	        model.addAttribute("searchPerformed", true);
	        model.addAttribute("keyword", keyword);  // Add keyword to model
	    } else {
	        model.addAttribute("searchPerformed", false);
	    }
	    return "friends_search";
	}
	
	@PostMapping("/addFriend")
	public String addFriend(@RequestParam Long friendId, Principal principal) {
	    // Get the logged-in user based on the principal's email
	    User loggedInUser = userService.findByEmail(principal.getName());

	    // Get the friend to be added from the database
	    User friendToAdd = userService.getUserById(friendId);

	    // Update the user's friends list
	    loggedInUser.getFriends().add(friendToAdd);
	    userService.saveUser(loggedInUser); // Update user in the database

	    return "redirect:/friends";
	}
	
    @PostMapping("/removeFriend")
    public String removeFriend(@RequestParam("friendId") Long friendId, Principal principal) {
        User loggedInUser = userService.findByEmail(principal.getName());
        User friendToRemove = userService.getUserById(friendId);
        
        if (loggedInUser != null && friendToRemove != null) {
            loggedInUser.getFriends().remove(friendToRemove);
            userService.saveUser(loggedInUser);
        }

        return "redirect:/friends";
    }
 
}

