package com.javamos.projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javamos.projeto.modelview.HomeView;

@RestController
public class HomeController {

	@GetMapping("/")
	public HomeView index() {
		return new HomeView();
	}
}