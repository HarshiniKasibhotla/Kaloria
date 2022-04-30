package com.csci5308.kaloria.access;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.csci5308.kaloria.errorHandling.ErrorMessages;
import com.csci5308.kaloria.utilities.Constants;

@Controller
public class LoginController implements ErrorMessages, Constants {

	IIdentifyUser identifyUser = new IdentifyUser();

	ModelAndView modelAndView;

	private HttpSession session = null;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home() {
		return "Login.html";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public ModelAndView validateUser(@RequestParam("loginId") String username,
			@RequestParam("password") String password, Model model, HttpSession session) throws SQLException {
		String role = identifyUser.identifyAndValidateUser(username, password);

		if (role.equals(ADMIN)) {
			modelAndView = new ModelAndView("Admin");
			session.setAttribute("username", username);
			CurrentAuthenticatedUser.setAuthenticatedUser(username);
		} else if (role.equals(USER)) {
			modelAndView = new ModelAndView("Admin");
			session.setAttribute("username", username);
			CurrentAuthenticatedUser.setAuthenticatedUser(username);
		} else if (role.equals(DIETICIAN)) {
			modelAndView = new ModelAndView("Dietician");
			session.setAttribute("username", username);
			CurrentAuthenticatedUser.setAuthenticatedUser(username);
		} else {
			modelAndView = new ModelAndView("Signup");
			modelAndView.addObject("errorMessage", KLR_USR_ERR_CODE_004);
			return modelAndView;
		}
		return modelAndView;

	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		if (session != null) {
			session.invalidate();
			CurrentAuthenticatedUser.setAuthenticatedUser(null);
		}
		return "redirect:/login";
	}
}
