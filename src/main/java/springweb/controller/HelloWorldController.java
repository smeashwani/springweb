package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	public String display(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("Controller");
		return "index";
	}
	
	@RequestMapping("/admin")
	public String displayAdmin() {
		
		System.out.println("displayAdmin");
		return "admin";
	}
}
