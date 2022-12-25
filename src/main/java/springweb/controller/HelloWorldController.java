package springweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
