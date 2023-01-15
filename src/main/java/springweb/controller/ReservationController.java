package springweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springweb.model.Reservation;
import springweb.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/bookingForm")
	public String bookingForm(Model model) {
		System.out.println("ReservationController.bookingForm()");
		// create a reservation object
		// Reservation res = new Reservation();
		// res.setFirstName("Guest");
		// provide reservation object to the model
		// model.addAttribute("reservation", res);
		return "reservation-page";
	}

	@ModelAttribute
	public void addAttribute(Model model) {
		System.out.println("ReservationController.addAttribute()");
		Reservation res = new Reservation();
		// provide reservation object to the model
		model.addAttribute("reservation", res);
	}

	@PostMapping("/submitForm")
	// @ModelAttribute binds form data to the object
	public String submitForm(@ModelAttribute("reservation") Reservation res) {
		System.out.println("ReservationController.submitForm()....");
		reservationService.save(res);
		return "confirmation-page";
	}
	
	@GetMapping("/viewAllReservation")
	public ModelAndView getAllReservation() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("reservationLst", reservationService.findAll());
		mv.setViewName("view-reservation-page");
		return mv;
	}

}
