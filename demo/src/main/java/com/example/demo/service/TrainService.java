package com.example.demo.service;

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
	public void saveData(Train train) {
		trainRepo.save(train);

	}

//	@Override
//	public void findById(int id) {
//		trainRepo.findById(id);
//
//	}

	@Override
	public Train getTrainDataById(int trainId) {
		Optional<Train> findById = trainRepo.findById(trainId);
		return findById.get();
	}

	@Override
	public Train updateData(Train train) {
		Train updatedData = trainRepo.save(train);
		return updatedData;
	}

	@Override
	public void deleteTrainData(int trainId) {
		trainRepo.deleteById(trainId);
	}



}
