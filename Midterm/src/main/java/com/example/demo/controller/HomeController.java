package com.example.demo.controller;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.TrainRepository;
import com.example.demo.Service.BookingTicketService;
import com.example.demo.Service.TrainService;
import com.example.demo.model.*;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class HomeController {
	
	
	 
	 private final TrainService trainService;
	 private final TrainRepository trainRepo;

	 @RequestMapping("/")
	 public String homepage() {
		 
		 return "index";
	 }
	 
	 
	 
	  
	@RequestMapping("/homepage")
	public String showHomepage() {
		return "homepage";
	}
	
	 @GetMapping("/search")
	    public String searchTrains(
	            @RequestParam("source") String source,
	            @RequestParam("destination") String destination,
	            Model model
	    ) {
	        List<Train> trains = trainService.searchTrains(source, destination);
	        model.addAttribute("searchResults", trains);
	        return "homepage";
	 }
	
 //open registraion page handler
	 
	 @PostMapping("/open_booking/{trainId}")
	 public String bookTicket(@PathVariable("trainId") Integer trainId, Model model ) {
		 BookingTicket bticket=new BookingTicket();
		 
		 Optional<Train> trn = trainRepo.findById(trainId);
		 
		 model.addAttribute("train", trn);
		 model.addAttribute("bticket",bticket);
		 
//		 model.addAttribute("", model)
		 return "booking_ticket_Form_direct";
	 }
	 
	 @GetMapping("/searc")
	    public String searchTrain(
	            @RequestParam("source") String source,
	            @RequestParam("destination") String destination,
	            Model model
	    ) {
	        List<Train> trains = trainService.searchTrains(source, destination);
	        model.addAttribute("searchResults", trains);
	        return "admin/homePage";
	 }
	 
	 
}
