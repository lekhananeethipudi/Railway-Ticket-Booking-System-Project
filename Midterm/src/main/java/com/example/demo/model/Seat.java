package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor



@Entity
@Table(name="seat")

public class Seat {
	@Id
	private Integer seatid;
	 
	private Integer seat_no;
	
	private String seat_status;

}
