package com.cg.optfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="parentId")
	private int parentId;
	
	@Column(name="tutorId")
	private int tutorId;
	
	@Column(name="rating")
	private String rating;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int id, int parentId, int tutorId, String rating) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.tutorId = tutorId;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", parentId=" + parentId + ", tutorId=" + tutorId + ", rating=" + rating + "]";
	}
	
	
	

}
