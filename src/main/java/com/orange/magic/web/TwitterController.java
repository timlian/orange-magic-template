package com.orange.magic.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orange.magic.web.domain.TwitterRepository;

@Controller
@RequestMapping("/twitter")
public class TwitterController {
	private TwitterRepository repository;

	@Autowired
	public TwitterController(TwitterRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegistrationForm() {
		return "registerForm";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String processRegistration(@Valid Twitter twitter, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}
		repository.save(twitter);
		return "redirect:/twitter/" + twitter.getUsername();
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showProfile(@PathVariable String username, Model model) {
		Twitter twitter = repository.findByUsername(username);
		model.addAttribute(twitter);
		return "profile";
	}
}
