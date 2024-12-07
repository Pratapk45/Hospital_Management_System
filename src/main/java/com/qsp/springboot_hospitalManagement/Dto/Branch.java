package com.qsp.springboot_hospitalManagement.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Branch {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String manager;

@ManyToOne
private Hospital h;
@OneToOne
private Address adress;
}