package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.BookingTicketService;
import com.example.demo.helper.AdminHelper;
import com.example.demo.model.Admin;
import com.example.demo.model.BookingTicket;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminController {
	@GetMapping("/adminLogin")
	public ModelAndView adminLogin() {	
		ModelAndView mav = new ModelAndView("admin/adminLogin");
		mav.addObject("user", new Admin());

		return mav;
	}
	
	@PostMapping("/adminLog")
	public String adminLoginProcess(@RequestParam("username") String email,
									@RequestParam("password") String password) {
		System.out.println("username = " +email);
		Admin admin = new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		
		try {
			if(!admin.getEmail().equals(null)) {
				if((admin.getEmail().equals("Lekhana@gmail.com")&&admin.getPassword().equals("12345678")) ||(admin.getEmail().equals("aravindkumar@gmail.com")&&admin.getPassword().equals("12345678"))) {
					if(admin.getEmail().equals("Lekhana@gmail.com")&&admin.getPassword().equals("12345678")) {
						AdminHelper.userName="Lekhana";
						System.out.println("Loged in username = "+AdminHelper.userName);
					}else {
						AdminHelper.userName="Aravind kumar";
						System.out.println("Loged in username = "+AdminHelper.userName);
					}
					
					return "redirect:/index";
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Admin details  "+admin);
		
		return "admin/error";
	}

	@RequestMapping("/index")
	public String launch(){
	return "admin/homepage";
	}
	
	@Autowired
	private BookingTicketService bookingTicketService;
	

	@RequestMapping("/book")
	public String booking(Model model) {
		List<BookingTicket>list=bookingTicketService.getAllBookingTickets();
		model.addAttribute("bookings",list);
		return "admin/booking";
	}
	
	
}
