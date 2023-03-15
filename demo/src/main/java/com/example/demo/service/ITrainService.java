package com.example.demo.service;

import com.example.demo.entity.Train;

public interface ITrainService {

	void saveData(Train train);
	//public Train  saveData(Train train);

	//void findById(String id);

	//void findById(int id);

	Train getTrainDataById(int trainId);

	Train updateData(Train train);

	void deleteTrainData(int trainId);

}
