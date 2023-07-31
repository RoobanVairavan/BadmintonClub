package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PlayerService;
import com.example.demo.models.PlayerDetail;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
	@Autowired
	private PlayerService playerService;

	@GetMapping("/all")
	public ResponseEntity<?> getPlayers() {
		List<PlayerDetail> PlayerList = playerService.getAllplayers();
		if (PlayerList != null) {
			return new ResponseEntity<>(PlayerList, HttpStatus.FOUND);
		} else {
			String errorMessage = "No Player Found!";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

	@GetMapping("/phoneNumber")
	public ResponseEntity<?> getPlayer(@RequestParam String phoneNumber) {
		PlayerDetail player = playerService.getPlayerByid(phoneNumber);
		if (player != null) {
			return new ResponseEntity<>(player, HttpStatus.FOUND);
		} else {
			String errorMessage = "Failed to Retrive player.";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<?> addPlayer(PlayerDetail player) {

		boolean success = playerService.createPlayer(player);
		if (success) {
			return new ResponseEntity<>(player, HttpStatus.CREATED);
		} else {
			String errorMessage = "Failed to create player.";
			return ResponseEntity.badRequest().body(errorMessage);
		}
	}
}
