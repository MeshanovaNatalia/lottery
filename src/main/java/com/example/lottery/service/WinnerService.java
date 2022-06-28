package com.example.lottery.service;

import com.example.lottery.domain.Participant;
import com.example.lottery.domain.Winner;
import com.example.lottery.repository.WinnerRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class WinnerService {

    private final WinnerRepository winnerRepository;

    public Winner save(@NonNull Participant participant, @NonNull Integer winningAmount) {
        return winnerRepository.save(new Winner(participant.getName(), participant.getAge(), participant.getCity(), winningAmount));
    }

    public List<Winner> findAll() {
        return winnerRepository.findAll();
    }
}
