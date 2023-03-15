package com.centroxy.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.centroxy.entities.Interview;
import com.centroxy.entities.InterviewPanel;
import com.centroxy.entities.JobDescription;
import com.centroxy.services.IInterviewPanelService;
import com.centroxy.services.IInterviewService;
import com.centroxy.services.JobDescriptionService;

/**
 * @author sumita sethy 12-Jul-2022 10:48:18 am
 */
//created rest endpoint for adding interview Panel in HrController
//@Controller
@RestController
@RequestMapping("/hr")
@CrossOrigin(origins = "http://localhost:4200")
public class HRController {

	IInterviewPanelService interviewPanelService;

	private IInterviewService interviewService;

	private final SimpMessagingTemplate template;

	private JobDescriptionService jobDescriptionService;

	@Autowired
	public HRController(IInterviewPanelService interviewPanelService, IInterviewService interviewService,
			SimpMessagingTemplate template, JobDescriptionService jobDescriptionService) {
		this.interviewPanelService = interviewPanelService;
		this.interviewService = interviewService;
		this.template = template;
		this.jobDescriptionService = jobDescriptionService;
	}

	@PostMapping("/interviewPanel")
	public ResponseEntity<String> addPanel(@RequestBody InterviewPanel interviewPanel) {
		System.out.println(interviewPanel);
		interviewPanel.setCreatedDate(LocalDateTime.now());
		InterviewPanel savedInterviewPanel = interviewPanelService.saveInterviewPanel(interviewPanel);
		if (savedInterviewPanel != null) {
			return new ResponseEntity<String>("Interviewpanel Added Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Interviewpanel Adding Failed", HttpStatus.BAD_REQUEST);
	}

	// This API is responsible to delete interview panel based in id.

	@DeleteMapping("/delete/{panelId}")
	public void deleteInterviewPanelById(@PathVariable long panelId) {
		interviewPanelService.deleteInterviewPanelById(panelId);
	}

	// This API responsible to update interview panel based in id.

	@PutMapping("/update")
	public void updateInterviewPanelById(@RequestBody InterviewPanel interviewPanel) {
		interviewPanel.setUpdatedDate(LocalDateTime.now());
		interviewPanelService.updateInterviewPanelById(interviewPanel);
	}

	// Retrieving all employees details through websocket call
	@SuppressWarnings("unchecked")
	@MessageMapping("/extractAllPanels")
	public void fetchAllPanels() throws Exception {

		System.out.println("API called...............");

		List<InterviewPanel> allPanel = interviewPanelService.getAllInterviewPanel();
		JSONObject details = new JSONObject();
		details.put("panels", allPanel);

		template.convertAndSend("/message/allpanel", details);

	}

	@GetMapping("/fetch/panels")
	public List<InterviewPanel> getAllInterviewPanel() {
		return interviewPanelService.getAllInterviewPanel();
	}

	@GetMapping("/fetch/panel/{panelId}")
	public InterviewPanel getInterviewPanelById(@PathVariable Long panelId) {
		return interviewPanelService.getInterviewPaneById(panelId);

	}

	// API for creating the interview
	@PostMapping(value = "/createinterview", consumes = { "application/json", "multipart/form-data" })
	public ResponseEntity<String> createPanel(@Valid @RequestPart Interview interview,
			@RequestParam("resume") MultipartFile resume) throws IOException {
		interview.setResume(resume.getBytes());
		Interview createdInterview = interviewService.createInterview(interview);
		if (createdInterview != null) {
			return new ResponseEntity<String>("interview added successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("interview adding failed", HttpStatus.BAD_REQUEST);
	}

	// API for updating the interview
	@PutMapping(value = "/updateinterview", consumes = { "application/json", "multipart/form-data" })
	public ResponseEntity<String> UpdateInterview(@Valid @RequestPart Interview interview,
			@RequestParam("resume") MultipartFile resume) throws IOException {
		System.out.println(interview);
		interview.setResume(resume.getBytes());

		interviewService.updateInterview(interview);

		return ResponseEntity.ok("Interview Updated Successfully ");

	}

	// API for deleting the interview
	@DeleteMapping("/deleteinterview/{interviewId}")
	public ResponseEntity<String> deleteInterview(@PathVariable("interviewId") String interviewId) {
		boolean isFound = interviewService.existsById(interviewId);
		if (isFound) {
			interviewService.deleteInterview(interviewId);
			return new ResponseEntity<String>("Interview Deleted Successfully ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Interview Not Found with id : " + interviewId, HttpStatus.BAD_REQUEST);

	}

	/**
	 * @author Diptiranjan Balabanataray 15-Jul-2022 14:48:48 am
	 */
	// created rest endpoint for fetching Requirements(approved demands by CEO) in
	// HR Controller.
	@GetMapping("/fetch/Requirements")
	public List<JobDescription> getAllRequirements() {
		return jobDescriptionService.findByApprovedResource();
	}

	// API for accept or reject to candidate by storing true or false in database

	@GetMapping(value = "/set/{status}/{id}")
	public ResponseEntity<String> candidateStatus(@PathVariable String status, @PathVariable String id) {
		Interview interviewObj = interviewService.getInterviewId(id);
		if (status.equals("accept")) {
			interviewObj.setSelected(true);
			interviewService.createInterview(interviewObj);
			return new ResponseEntity<>("Candidate Selected ", HttpStatus.OK);
		} else {
			interviewObj.setSelected(false);
			interviewService.createInterview(interviewObj);
			return new ResponseEntity<>("Candidate Rejected ", HttpStatus.OK);
		}

	}
	/**
	 * @author Subhasmita Panda 19-Jul-2022 14:48:48 am
	 */
	//for fetching approved demands by CEO
	@GetMapping("/fetch/demands")
	public List<JobDescription> findByIsApproved(){
		List<JobDescription> findByIsApprovedTrue = jobDescriptionService.findByIsApprovedTrue(true);
		return findByIsApprovedTrue;
	}
	
	/** 
	 * @author Sumita Sethy 26-Jul-2022 16:29:48 pm
	 */
	//fetching approved demands by CEO with webSocket 
 @SuppressWarnings("unchecked")
 @MessageMapping("/extractAllRequirements")
  public void fetchAllRequirementWebSocket() throws Exception {  
      List<JobDescription> allResource= jobDescriptionService.findByIsApprovedTrue(true);
      JSONObject details = new JSONObject();
      details.put("AllRequirements", allResource);

      template.convertAndSend("/message/requirements", details);
 }
 @GetMapping("/showDisplaypage")
    public ModelAndView  showDisplay() {
	 ModelAndView modelAndView = new ModelAndView();
	 modelAndView.setViewName("Display");
	return modelAndView;
	 
 }
    /** 
	 * @author Sumita Sethy 26-Jul-2022 16:29:48 pm
	 */
 //created rest endpoint to fetch interviews under respective interviewpanel
 @GetMapping("/interviews/{panelId}")
 public ResponseEntity<List<Interview>> fetchInterview(@PathVariable String panelId ){
	 List<Interview> fetchInterviewList = interviewService.fetchInterview(panelId);
	return ResponseEntity.ok(fetchInterviewList);
	 
 }
 
}
