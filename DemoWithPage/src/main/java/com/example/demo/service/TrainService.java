package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Train;
import com.example.demo.repo.TrainRepo;

@Service
public class TrainService implements ITrainService {
	@Autowired
	TrainRepo trainRepo;

	@Override
	public Train saveTrainData(Train train) {
		Train savedTrain = trainRepo.save(train);
		return savedTrain;
	}


	@Override
	public Train updateById(int trainId) {
		Train train = trainRepo.findById(trainId).get();
		return train;
	}

	

	@Override
	public void deleteTrain(int trainId) {
		trainRepo.deleteById(trainId);
		
	}


	@Override
	public List<Train> allTrains() {
		List<Train> findAllTrain = trainRepo.findAll();
		return findAllTrain;
	}

	
	

	
	

	

	

	
}
