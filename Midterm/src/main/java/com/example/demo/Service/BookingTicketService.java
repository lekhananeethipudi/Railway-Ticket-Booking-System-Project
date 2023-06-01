package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.BookingTicket;

public interface BookingTicketService {
	public List<BookingTicket>getAllBookingTickets();
	public BookingTicket getAllBookingTicketsById(Integer id);
	public void savebookingForm(BookingTicket bticket);
	public BookingTicket getBookingTicketById(Integer id);
	void deleteBookingTicketById(Integer id);
	public void savebooking(BookingTicket bticket1);
	
}
