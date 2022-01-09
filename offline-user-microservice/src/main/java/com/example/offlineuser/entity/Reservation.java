package com.example.offlineuser.entity;

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
public class Reservation {
	
	public Reservation() {
		
	}
	
	public Reservation(int id,String userId, int number, String date, String month, String year) {
		this.id = id;
		this.userID = userId;
		this.number = number;
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	public Reservation(String userId, int number, String date, String month, String year) {
		this.userID = userId;
		this.number = number;
		this.date = date;
		this.month = month;
		this.year = year;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID",unique=true, nullable = false)
	private Integer id;
	
	@Column(name = "USERID")
	private String userID;
	
	@Column(name = "Number")
	private int number;
	
	@Column(name = "Date")
	private String date;
	
	@Column(name = "Month")
	private String month;
	
	@Column(name = "YEAR")
	private String year;
	
	@Override
	public String toString() {
		return "Reservation made: id=" + id + ", userID=" + userID + ", total members=" + number + ", Date="+date+"-"+month+"-"+year;
	}

}
