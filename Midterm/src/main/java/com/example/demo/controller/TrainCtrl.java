package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.Service.TrainService;
import com.example.demo.model.Train;
import java.util.*;
@Controller

public class TrainCtrl {

	@Autowired
	private TrainService trainService;

	
	@RequestMapping("/train")
	public String train(Model model) {
		List<Train> list= trainService.getAllTrains();
		model.addAttribute("trains", list);
		return "train";
	}
	
	@RequestMapping("/trainaddForm")
	public String trainaddForm(Model model)
	{
		Train train1=new Train();
		model.addAttribute("train1", train1);
		return "trainadd";
	}
	
	@PostMapping("/savetrainForm")
	public String savetrainForm(@ModelAttribute("train1") Train train1)
	{
		trainService.savetrainForm(train1);
		return "redirect:/train";
	}
	
	@RequestMapping("/showUpdate/{id}")
	public String showUpdate(@PathVariable("id")Integer id,Model model)
	{
		Train train1=trainService.getTrainById(id);
		
		model.addAttribute("train1",train1);
		return "update_train_form";
	}
	
	
	
       @PostMapping("/updated")
	
	public String updated(@ModelAttribute("train1")Train train1)
	{
		trainService.savetrainForm(train1);
		return "redirect:/train";
	}
	
	@RequestMapping("/deleted/{id}")
	
	public String deleteTrainById(@PathVariable("id")Integer id)
	{
		trainService.deleteTrainById(id);
		return "deletetrain";
		
	}
	
	
}
