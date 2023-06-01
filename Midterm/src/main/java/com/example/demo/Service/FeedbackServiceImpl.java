package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.FeedbackRepository;
import com.example.demo.model.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository fbRepository;
	

	@Override
	public void feedbackUser(Feedback fb) {
		fbRepository.save(fb);
		
	}

}
