package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int trainId;
	private String trainName;
	private int seats;

}
