package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MatchService;
import com.example.demo.models.MatchDetail;

@RestController
@RequestMapping("/api/match")
public class MatchController {
	@Autowired
	private MatchService matchService;

	// Create or Start The Match
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<?> addMatch(MatchDetail match) {
		MatchDetail success = matchService.createMatch(match);
		if (success != null) {
			String Message = "MATCH CREATED";
			return new ResponseEntity<>(Message, HttpStatus.CREATED);
		} else {
			String errorMessage = "Already Match Going On This Court!!";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

	// End-Up The Match
	@RequestMapping("/end")
	public ResponseEntity<?> endMatch(@RequestParam("courtNo") int courtNo,
			@RequestParam("loserPhoneNumber") String loserPhoneNumber) {
		// Getting End Time
		LocalDateTime localtimeend = LocalDateTime.now();

		MatchDetail success = matchService.endMatch(courtNo, localtimeend, loserPhoneNumber);
		if (success != null) {
			String Message = "MATCH ENDED";
			return new ResponseEntity<>(Message, HttpStatus.OK);
		} else {
			String errorMessage = "MATCH NOT ENDED";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

	// Get All Matches Between Given Dates
	@GetMapping("/betweenAll")
	public ResponseEntity<?> getMatches(@RequestParam(value = "startDateTime") LocalDateTime startDateTime,
			@RequestParam(value = "endDateTime") LocalDateTime endDateTime) {
		// Calling The getMatchBetweenDates Method
		List<MatchDetail> matchList = matchService.getMatchInDateRange(startDateTime, endDateTime);

		if (matchList != null) {
			return new ResponseEntity<>(matchList, HttpStatus.OK);
		} else {
			String errorMessage = "NO MATCH FOUND!";
			return ResponseEntity.badRequest().body(errorMessage);
		}

	}

	// Get Match Using and Player_no And Date and Time's
	@GetMapping("/PlayerAndTime")
	public ResponseEntity<?> getMatchByPhoneNumber(@RequestParam("PlayerPhoneNumber") String PlayerPhoneNumber,
			@RequestParam("startDateTime") LocalDateTime startDateTime,
			@RequestParam("endDateTime") LocalDateTime endDateTime) {

		List<MatchDetail> match = matchService.getMatchByPhone(PlayerPhoneNumber, startDateTime, endDateTime);
		// Store The MatchDetail Entity What We Get From MatchService Class
		if (match != null) {
			return new ResponseEntity<>(match, HttpStatus.OK);
		} else {
			String errorMessage = "NO MATCH FOUND!";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

}
