package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {

	@RequestMapping("/home")
	public ModelAndView showHomeForm() {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		return modelAndView;
	}

	@RequestMapping("/playerform")
	public ModelAndView showPlayerForm() {
		ModelAndView modelAndView = new ModelAndView("playerform.jsp");
		return modelAndView;
	}

	@RequestMapping("/matchform")
	public ModelAndView showMatchForm() {
		ModelAndView modelAndView = new ModelAndView("matchform.jsp");
		return modelAndView;
	}

	@RequestMapping("/paymentform")
	public ModelAndView showPaymentForm() {
		ModelAndView modelAndView = new ModelAndView("paymentform.jsp");
		return modelAndView;
	}
}
