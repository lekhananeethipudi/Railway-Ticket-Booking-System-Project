package com.example.demo.Service;

import java.util.List;


import com.example.demo.model.Train;

public interface TrainService {
 public  List<Train>getAllTrains(); 	
 public Train getAllTrainsById(Integer Id);
public void savetrainForm(Train train1); 
 public Train getTrainById(Integer id);
 void deleteTrainById(Integer id);
 public List<Train> searchTrains(String source, String destination);
}
