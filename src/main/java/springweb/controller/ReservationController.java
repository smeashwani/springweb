package springweb.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springweb.model.Reservation;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
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
	public String submitForm(@Valid @ModelAttribute("reservation") Reservation res, BindingResult br) {
		System.out.println("ReservationController.submitForm()....");
		System.out.println(br);
		if(br.hasErrors()) {
			return "reservation-page";
		}
	return"confirmation-page";
}

}
