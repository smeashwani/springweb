package springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
//		Reservation res = new Reservation();
//		res.setFirstName("Guest");
		// provide reservation object to the model
//		model.addAttribute("reservation", res);
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
		System.out.println("ReservationController.submitForm()");
		int a= 12/0;
		return "confirmation-page";
	}
	
	@ExceptionHandler(value = NumberFormatException.class)
    public String numberformatHandler(Model theModel, Exception e) {
		System.out.println("ReservationController.numberformatHandler()"+e);
        theModel.addAttribute("message", "NumberFormatException");
        return "errorPage";
    }
	
//	@ExceptionHandler(value = ArithmeticException.class)
//    public String arithmeticExceptionHandler(Model theModel, Exception e) {       
//		System.out.println("ReservationController.arithmeticExceptionHandler()"+e);
//        theModel.addAttribute("message", "ArithmeticException");
//        return "errorPage";
//    }

}
