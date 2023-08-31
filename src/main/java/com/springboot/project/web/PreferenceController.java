package com.springboot.project.web;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.project.model.Preference;
import com.springboot.project.model.User;
import com.springboot.project.service.PreferenceService;
import com.springboot.project.service.UserService;

@Controller
public class PreferenceController {
	
	@Autowired
	private PreferenceService preferenceService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    public PreferenceController(PreferenceService preferenceService, UserService userService) {
		super();
		this.preferenceService = preferenceService;
		this.userService = userService;
	}

	// Show add preference form
    @GetMapping("/preferences/add")
    public String showAddPreferenceForm(Model model) {
        Preference preference = new Preference();
        model.addAttribute("preference", preference);
        return "add_preference";
    }
    
    @GetMapping("/preferences")
    public String showPreferences(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName()); // Get the currently logged-in user
        Set<Preference> preferences = user.getPreferences(); // Get the user's preferences
        model.addAttribute("preferences", preferences);
        return "preferences";
    }

    @PostMapping("/preferences/save")
    public String savePreference(@ModelAttribute("preference") Preference preference, Principal principal) {
        User user = userService.findByEmail(principal.getName()); // Get the currently logged-in user
        user.getPreferences().clear(); // Clear existing preferences
        user.getPreferences().add(preference); // Add the new preference
        userService.saveUser(user);
        return "redirect:/preferences";
    }

    // Show update preference form
    @GetMapping("/preferences/update/{id}")
    public String showUpdatePreferenceForm(@PathVariable Long id, Model model) {
        Preference preference = preferenceService.getPreferenceById(id);
        model.addAttribute("preference", preference);
        return "update_preference";
    }

    // Save updated preference
    @PostMapping("/preferences/{id}")
    public String updatePreference(@PathVariable("id") Long id,
                                   @ModelAttribute("preference") Preference preference) {
        // Update the preference
        preference.setId(id);
        preferenceService.savePreference(preference);

        return "redirect:/preferences";
    }

}
