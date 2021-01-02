package com.cg.optfs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.ForeignKey;

@Entity
@Table(name="Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(foreignKey = @ForeignKey(name = "parent_id"), name = "parentId")
	@JsonIgnore
	private Parent parent;

	@Column(name="tutorId")
	private int tutorId;
	
	@Column(name="rating")
	private String rating;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int id, Parent parent, int tutorId, String rating) {
		super();
		this.id = id;
		this.parent = parent;
		this.tutorId = tutorId;
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
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
		return "Feedback [id=" + id + ", parent=" + parent + ", tutorId=" + tutorId + ", rating=" + rating + "]";
	}
	
	
	

}
