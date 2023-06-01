package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Repository.TrainRepository;
import com.example.demo.model.Train;

@Service
public class TrainServiceImpl implements TrainService{
	@Autowired
	private TrainRepository trainRepository;

	public List<Train> getAllTrains() {
		
		return trainRepository.findAll();
	}

	@Override
	public Train getAllTrainsById(Integer Id) {
		return trainRepository.findById(Id).get();
	}

	@Override
	public void savetrainForm(Train train1) {
		trainRepository.save(train1);
		
	}
	
	@Override
	public Train getTrainById(Integer id) {
		Optional<Train> optional= trainRepository.findById(id);
		Train train1=null;
		if(optional.isPresent()) {
			train1 = optional.get();
		}
		else
		{
			throw new RuntimeException(" Train Record Not Found with ID :"+id);
		}
		return train1;
		
		
	}

	
	
	@Override
	public void deleteTrainById(Integer id) {
		 Optional<Train> optional = trainRepository.findById(id);
	        if (optional.isPresent()) {
	           trainRepository.deleteById(id);
	        } else {
	            throw new RuntimeException(" ticket Record Not Found with ID: " + id);
	        }
	}
	
	public List<Train> searchTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

	
}
