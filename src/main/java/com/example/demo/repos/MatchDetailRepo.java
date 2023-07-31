package com.example.demo.repos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.MatchDetail;
import com.example.demo.models.MatchStatus;

public interface MatchDetailRepo extends JpaRepository<MatchDetail, Integer> {

	Optional<MatchDetail> findByCourtNoAndMatchStatus(int courtNo, MatchStatus matchStatus);

	List<MatchDetail> findByStartDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

	List<MatchDetail> findByStartDateTimeBetweenAndPlayer1PhoneNumberOrPlayer2PhoneNumber(LocalDateTime startDateTime,
			LocalDateTime endDateTime, String player1PhoneNumber, String player2PhoneNumber);

}
