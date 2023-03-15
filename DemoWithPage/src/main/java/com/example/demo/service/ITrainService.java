package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Train;

public interface ITrainService  {

	public Train saveTrainData(Train train);
	public List<Train> allTrains();
	
	public Train updateById(int trainId);


	public void deleteTrain(int trainId);

	

	

	


}
