package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_ticket")

public class BookingTicket {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "booking_id")
	    private Integer bookingId;
        
	  
	    @Column(name = "class_type")
	    private String classType;
	     
	    private String name;
	    
	    private Long phno;

	    
	    private String train_name;

	    
	    
	    @Column(name="seat_no")
	    private String seat_no;
	    
	    @Column(name="b_time")
	    private String b_time;
	    
	    private String source;
	    private String destination;
	    
	    private String payment;
	    
	    private Integer fare;
	    
	    
	    

	    
}
