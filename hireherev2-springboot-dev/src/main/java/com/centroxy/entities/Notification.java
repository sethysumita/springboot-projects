package com.centroxy.entities;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Entity
@Data
@Component
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int notificationId;
	private String triggeredBy;
	private String receivedBy;
	private String causedBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime createdDate;
	private boolean isRead;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn
	private JobDescription jobDescription;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn
	private Project project;

}
