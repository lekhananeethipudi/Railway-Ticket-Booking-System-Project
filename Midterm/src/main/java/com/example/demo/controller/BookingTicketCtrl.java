package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Service.BookingTicketService;
import com.example.demo.model.BookingTicket;


@Controller
//@RequestMapping("/ticket")
public class BookingTicketCtrl {
	@Autowired
	private BookingTicketService bookingTicketService;
	

	@RequestMapping("/booking")
	public String booking(Model model) {
		List<BookingTicket>list=bookingTicketService.getAllBookingTickets();
		model.addAttribute("bookings",list);
		return "booking";
	}
	
	@RequestMapping("/bookingticket")
	public String bookingticket(Model model)
	{
		BookingTicket bticket=new BookingTicket();
		model.addAttribute("bticket",bticket);
		return "booking_ticket_Form";
	}
	
	@PostMapping("/savebookingForm")
	public String savebookingForm(@ModelAttribute("bticket") BookingTicket bticket)
	{
		bookingTicketService.savebookingForm(bticket);
		return "bookinghome";
	}
	
	@RequestMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable("id")Integer id,Model model)
	{
		BookingTicket bticket= bookingTicketService.getBookingTicketById(id);
		model.addAttribute("bticket",bticket);
		return "update_booking_form";
	}
	
	
	
       @PostMapping("/updatedForm")
	
	public String updatedForm(@ModelAttribute("bticket")BookingTicket bticket)
	{
		bookingTicketService.savebookingForm(bticket);
		return "redirect:/booking";
	}
	
	@RequestMapping("/delete/{id}")
	
	public String deleteBookingTicketById(@PathVariable("id")Integer id)
	{
		bookingTicketService.deleteBookingTicketById(id);
		return "deleteticket";
		
	}
	
	
	
	
}

