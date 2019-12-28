package com.javalopment.samples.jackson.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javalopment.samples.jackson.model.User;

@RestController
@RequestMapping("jackson")
public class JacksonSamplesController {

	@PostMapping
	@RequestMapping("/readValueFromInputStream")
	public User createUserMail(HttpServletRequest request) throws Exception {
		
		User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
		String email = user.getName() + "." + user.getSurname() + "@javalopment.com";
		user.setEmail(email.toLowerCase());
		return user;
	}
}
