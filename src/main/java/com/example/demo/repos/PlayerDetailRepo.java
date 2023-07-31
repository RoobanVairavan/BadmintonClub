package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.PlayerDetail;

public interface PlayerDetailRepo extends JpaRepository<PlayerDetail, String> {

}
