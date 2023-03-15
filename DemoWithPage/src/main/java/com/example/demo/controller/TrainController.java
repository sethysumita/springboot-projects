package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Train;
import com.example.demo.service.ITrainService;

@Controller
public class TrainController {
	
	@Autowired
	ITrainService trainService;
	
	@GetMapping("/add")
	public String getPage(Model model) {
		model.addAttribute("getPage", new Train());
		return "inputPage";
	
	}
	
	@GetMapping("/")
	public String fetch(Model model) {
		List<Train> allTrainsList = trainService.allTrains();
		model.addAttribute("trains", allTrainsList);
		return "listTrain";
		
	}
	
	@PostMapping("/save")
	public String saveData(@ModelAttribute Train train ,Model model) {
		 Train savedTrainData = trainService.saveTrainData(train);
		model.addAttribute("trainDetails", savedTrainData);
		return "redirect:/";
		
		
	}
	@GetMapping("/update/{trainId}")
   public String updateData(@PathVariable("trainId")int trainId, Model model) {
		Train updateByIdTrain = trainService.updateById(trainId);
		model.addAttribute("trainobj", updateByIdTrain);
	  return "update";
		
	}
	
	@GetMapping("/delete/{trainId}")
	public String deleteTrain(@PathVariable("trainId") int trainId ) {
		trainService.deleteTrain(trainId);
		return "redirect:/";
		
	}
}
