package com.jdc.library.model.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String penName;
	private Gender gender;
	private LocalDate dob;
	private String title;
	private String country;
	@Column(columnDefinition = "TEXT")
	private String remark;
	
	public enum Gender{
		Male, Femal
	}
	
}
