package com.example.admin.entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	public Feedback() {
		
	}
	
	public Feedback(int id, String userID, String feedback) {
		this.id = id;
		this.userID = userID;
		this.feedback = feedback;
	}
	
	public Feedback(String userID, String feedback) {
		this.userID = userID;
		this.feedback = feedback;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID",unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "USERID")
	private String userID;
	
	@Column(name = "Feedback")
	private String feedback;

}
