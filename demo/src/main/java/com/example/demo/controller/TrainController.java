package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Train;
import com.example.demo.service.ITrainService;

@RestController
public class TrainController {
	@Autowired
	ITrainService trainService;

	@PostMapping("/save")
	public String save(@RequestBody Train train) {
		trainService.saveData(train);
		System.out.println(train);
		return "saved";
	}

	@GetMapping("/fetch/{trainId}")
	private Train getBooks(@PathVariable("trainId") int trainId) {
		return trainService.getTrainDataById(trainId);
	}

	@PutMapping("/update/{trainId}")
	private Train updateBooks(@PathVariable("trainId") int trainId, @RequestBody Train train) {
		trainService.updateData(train);
		return trainService.getTrainDataById(trainId);
	}
	
	@DeleteMapping("/delete/{trainId}")
	private String deleteTrain(@PathVariable("trainId") int trainId) {
		trainService.deleteTrainData(trainId);
		return "train deleted successfully";
	}
	
	

}
