package com.example.demo.models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "match_details")
public class MatchDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "court_no")
	private int courtNo;

	@Column(name = "matchstatus")
	@Enumerated(EnumType.STRING)
	private MatchStatus matchStatus;

	@Column(name = "player_1_phone_no")
	private String player1PhoneNumber;

	@Column(name = "player_2_phone_no")
	private String player2PhoneNumber;

	@Column(name = "start_date_time")
	private LocalDateTime startDateTime;

	@Column(name = "end_date_time")
	private LocalDateTime endDateTime;

	@Column(name = "loser_phone_no")
	private String loserPhoneNumber;

	@Column(name = "amount")
	private double amount;

	// constructors, getters, and setters

	public MatchDetail(int id, int courtNo, MatchStatus matchStatus, String player1PhoneNumber,
			String player2PhoneNumber, LocalDateTime startDateTime, LocalDateTime endDateTime, String loserPhoneNumber,
			double amount) {
		super();
		this.id = id;
		this.courtNo = courtNo;
		this.matchStatus = matchStatus;
		this.player1PhoneNumber = player1PhoneNumber;
		this.player2PhoneNumber = player2PhoneNumber;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.loserPhoneNumber = loserPhoneNumber;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getcourtNo() {
		return courtNo;
	}

	public void setcourtNo(int courtNo) {
		this.courtNo = courtNo;
	}

	public void setCourtNo(int courtNo) {
		this.courtNo = courtNo;
	}

	public MatchStatus getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}

	public String getPlayer1PhoneNumber() {
		return player1PhoneNumber;
	}

	public void setPlayer1PhoneNumber(String player1PhoneNumber) {
		this.player1PhoneNumber = player1PhoneNumber;
	}

	public String getPlayer2PhoneNumber() {
		return player2PhoneNumber;
	}

	public void setPlayer2PhoneNumber(String player2PhoneNumber) {
		this.player2PhoneNumber = player2PhoneNumber;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getLoserPhoneNumber() {
		return loserPhoneNumber;
	}

	public void setLoserPhoneNumber(String loserPhoneNumber) {
		this.loserPhoneNumber = loserPhoneNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public MatchDetail() {
		super();
	}

}
