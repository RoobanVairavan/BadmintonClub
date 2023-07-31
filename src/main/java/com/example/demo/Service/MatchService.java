package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.MatchDetail;
import com.example.demo.models.MatchStatus;
import com.example.demo.models.PlayerDetail;
import com.example.demo.repos.MatchDetailRepo;
import com.example.demo.repos.PlayerDetailRepo;

@Service
public class MatchService {

	@Autowired // Giving The Connection from Player Repository
	private MatchDetailRepo matchDetailRepo;

	@Autowired
	private PlayerDetailRepo playerDetailRepo;

	// Create Match And Store The Details in DB Using Match Repository
	public MatchDetail createMatch(MatchDetail matchDetail) {

		 // Check Whether The Court is Already Started Or Not Before Start Match!
		 Optional<MatchDetail>matchExists = matchDetailRepo.findByCourtNoAndMatchStatus( matchDetail.getcourtNo(),MatchStatus.STARTED);

		 if (matchExists.isEmpty()){
				// Setting Match StartTime Using LocalDateTime
				LocalDateTime localtimeStart = LocalDateTime.now();
				matchDetail.setMatchStatus(MatchStatus.STARTED);
				matchDetail.setStartDateTime(localtimeStart);
				matchDetailRepo.save(matchDetail);
				return matchDetail;
		}else {
		return null;
		}
	}

	// End The Match And Calculating the amount and set the players payment_details
	public MatchDetail endMatch(int court_no, LocalDateTime endDateTime, String loserPhoneNumber) {
		// Optional - To get Non-Null Objects
		Optional<MatchDetail> MatchOptional = matchDetailRepo.findByCourtNoAndMatchStatus(court_no,MatchStatus.STARTED);
		// To Check Whether The Match Is Existing
		if (MatchOptional.isPresent()) {
			// Setting Match End Scenario
			MatchDetail match = MatchOptional.get();
			match.setMatchStatus(MatchStatus.ENDED); // Update The Match Status
			match.setEndDateTime(endDateTime); // Update the Match End Time And Date

			// find the loser by what we get from the admin's input
			PlayerDetail loser = playerDetailRepo.findById(loserPhoneNumber).get();

			// Difference Between Two Date And Time
			double duration = (double) Duration.between(match.getStartDateTime(), endDateTime).toMinutes();
			double amount = duration * 2; // find the Match Amount Using time we Calculated Above
			match.setAmount(amount);
			match.setLoserPhoneNumber(loserPhoneNumber);

			loser.setAccountBalance(amount);
			playerDetailRepo.save(loser); // after Change The Loser(player) Details to save the change's in table
			return matchDetailRepo.save(match);
		} else {
			return null; // Create Error Handling Classes
		}
	}

	// Getting The Matches Between Two Dates
	public List<MatchDetail> getMatchInDateRange(LocalDateTime startDateTime, LocalDateTime endDateTime) {
		return matchDetailRepo.findByStartDateTimeBetween(startDateTime, endDateTime);
	}

	// Getting the match details based on the Player id;
	public List<MatchDetail> getMatchByPhone(String playerPhoneNumber, LocalDateTime startDateTime,
			LocalDateTime endDateTime) {
		return matchDetailRepo.findByStartDateTimeBetweenAndPlayer1PhoneNumberOrPlayer2PhoneNumber( startDateTime, endDateTime, playerPhoneNumber,playerPhoneNumber);
	}

}
