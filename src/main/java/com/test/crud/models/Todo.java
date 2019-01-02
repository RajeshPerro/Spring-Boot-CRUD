package com.test.crud.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Todo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "duedate", nullable = false)
	private Date duedate;
	
	@Column(name = "createDateTime", nullable = true)
	@CreationTimestamp
	private LocalDateTime createDateTime;
	
	@Column(name = "updateDateTime", nullable = true)
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Todo(String name, String description, Date duedate) {
		super();
		this.name = name;
		this.description = description;
		this.duedate = duedate;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	

	
	
	
	

}
