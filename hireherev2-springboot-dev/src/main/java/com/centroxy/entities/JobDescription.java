package com.centroxy.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import com.centroxy.generators.IdGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author Sumita Sethy 07-July-2022 12:01:15 pm
 */
@Entity
@Data
public class JobDescription {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_generator")
	@GenericGenerator(name = "project_id_generator", strategy = "com.centroxy.generators.IdGenerator", parameters = {
			@Parameter(name = IdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = IdGenerator.VALUE_PREFIX_PARAMETER, value = "JD"),
			@Parameter(name = IdGenerator.NUMBER_FORMAT_PARAMETER, value = "%02d") })
	private String jdId;
	
	@NotEmpty(message = "Qualifications shouldnot be empty")
	private String qualifications;
	
	@NotEmpty(message = "Domain shouldnot be empty")
	private String domain;
	
	@NotEmpty(message = "Skill Sets shouldnot be empty")
	private String skillSets;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	@Column(name="creation_date_time")
	private LocalDateTime createdDate;
	
	@NotEmpty(message = "Experience in years shouldnot be empty")
	private String experienceInYears;
	
	@NotEmpty(message = "Position for shouldnot be empty")
	private String positionFor;
	
	@NotEmpty(message = "Responsibilites shouldnot be empty")
	@Column(length = 10000)
	private String responsibilites;
	
	private boolean isApproved;
	
	@Column(length = 1000)
	private String remarks;

}
