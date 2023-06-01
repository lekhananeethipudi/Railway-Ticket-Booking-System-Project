package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BookingTicketRepository;
import com.example.demo.model.BookingTicket;


@Service
public class BookingTicketServiceImpl implements BookingTicketService {
  @Autowired
  private BookingTicketRepository bookingTicketRepository;
	
	@Override
	public List<BookingTicket> getAllBookingTickets() {
		
		return bookingTicketRepository.findAll();
	}

	@Override
	public BookingTicket getAllBookingTicketsById(Integer id) {
		
		return bookingTicketRepository.findById(id).get();
	}

	@Override
	public void savebookingForm(BookingTicket bticket) {
		bookingTicketRepository.save(bticket);
		
	}

	@Override
	public BookingTicket getBookingTicketById(Integer id) {
		Optional<BookingTicket> optional= bookingTicketRepository.findById(id);
		BookingTicket bticket=null;
		if(optional.isPresent()) {
			bticket= optional.get();
		}
		else
		{
			throw new RuntimeException("Booking ticket Record Not Found with ID :"+id);
		}
		return bticket;
		
		
	}

	@Override
	public void deleteBookingTicketById(Integer id) {
		
		 Optional<BookingTicket> optional = bookingTicketRepository.findById(id);
	        if (optional.isPresent()) {
	            bookingTicketRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Booking ticket Record Not Found with ID: " + id);
	        }
		
	}

	@Override
	public void savebooking(BookingTicket bticket1) {
		bookingTicketRepository.save(bticket1);
		
	}

	
	

}
