package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.PlayerDetail;
import com.example.demo.repos.PlayerDetailRepo;

@Service
public class PlayerService {

	@Autowired // Giving The Connection from Player Repository
	private PlayerDetailRepo playerDetailRepo;

	// Create Player Model And Store In the DB Table
	public boolean createPlayer(PlayerDetail playerDetail) {
		playerDetailRepo.save(playerDetail);
		return true;
	}

	// Return All Player Details Model Stored In Player Table
	public List<PlayerDetail> getAllplayers() {
		return playerDetailRepo.findAll();
	}

	// Returning The Player Detail Which is Matched With ID if it's not return null
	// Optional DataType
	public PlayerDetail getPlayerByid(String phoneNumber) {
		return playerDetailRepo.findById(phoneNumber).orElse(null);
	}

	// Update The Player Remaining Amount After Paying Some Amount
	public void updatePlayerBalance(String phoneNumber, double amount) {
		PlayerDetail player = getPlayerByid(phoneNumber);

		if (player != null) {
			player.setAccountBalance(player.getAccountBalance() - amount);

			// After Update The Account Balance Of The Player to Store The New Updated
			// Player Model Into The DB
			playerDetailRepo.save(player);
		}
	}
}
