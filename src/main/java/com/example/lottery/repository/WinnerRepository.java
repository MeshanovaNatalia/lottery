package com.example.lottery.repository;

import com.example.lottery.domain.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnerRepository extends JpaRepository<Winner, Long> {
}
