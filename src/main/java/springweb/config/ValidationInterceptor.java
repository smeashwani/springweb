package springweb.config;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class ValidationInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("validation interceptor");
		String lastName = request.getParameter("lastName");
		if (lastName == null || lastName.length() == 0) {
			System.out.println("validation interceptor... " + lastName);
			String error = "lastname should not be null";
			response.sendRedirect("/reservation/bookingForm?error_lastName="+error);
			return false;
		}
		// if returned false, we need to make sure 'response' is sent
		return true;
	}
}
