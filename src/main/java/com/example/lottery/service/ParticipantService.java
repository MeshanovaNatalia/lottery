package com.example.lottery.service;

import com.example.lottery.domain.Participant;
import com.example.lottery.repository.ParticipantRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public Long count() {
        return participantRepository.count();
    }

    public void deleteAll() {
        participantRepository.deleteAll();
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Participant save(@NonNull Participant participant) {
        return participantRepository.save(participant);
    }
}
