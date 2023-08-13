package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping(path = { "/getmapping", "/fetchMapping" })
	public String get(HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("Controller- fetchMapping");
		return "index";
	}

	// @GetMapping(path= {"/getmapping"}, params="name")
	// public String getParam(HttpServletRequest req, HttpServletResponse res) {
	@GetMapping(path = { "/getParam" })
	public String getParam(@RequestParam(name = "name", defaultValue = "Guest") String name) {
		System.out.println("Controller-  params=name" + name);
		return "index";
	}

	// hello/getCustomer/1234/details
	@GetMapping(path = { "/getCustomer/{customerId}/details" })
	public String getPathVariable(@PathVariable String customerId) {

		System.out.println("Controller-  params=customerId" + customerId);
		return "index";
	}

	@GetMapping(path = { "/getCookie" })
	public String getCookiesValue(HttpServletRequest req, @CookieValue("JSESSIONID") String jsessionCookie) {
		String value= "";
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("JSESSIONID")) {
				value = cookie.getValue();
			}
		}
		System.out.println("Controller-  cookie=" + value);
		System.out.println("Controller-  jsessionCookie=" + jsessionCookie);
		return "index";
	}

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String post(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("Controller- POST");
		return "index";
	}

	// @RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping
	public String delete(HttpServletRequest req, HttpServletResponse res) {

		System.out.println("Controller- DELETE");
		return "index";
	}
}
