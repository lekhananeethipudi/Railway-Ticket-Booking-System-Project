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
@Table(name = "train")
public class Train {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "train_id")
	    private Integer trainId;
     
	 private String train_name;
	 
	 private String source;
	 
	 private String destination;
	 
	 private String depature_time;
	 
	 private String arrival_time;
	 
	 private Integer fare;
	 
	 
	 
	 
	 
	   
	}

