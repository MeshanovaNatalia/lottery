package com.example.lottery.service;

import com.example.lottery.domain.Participant;
import com.example.lottery.domain.Winner;
import com.example.lottery.repository.ParticipantRepository;
import com.example.lottery.repository.WinnerRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class LotteryServiceTest {

    private final ParticipantRepository participantRepository;
    private final WinnerRepository winnerRepository;
    private final LotteryService lotteryService;

    @BeforeEach
    public void deleteAll() {
        participantRepository.deleteAll();
        winnerRepository.deleteAll();
    }

    private void addThreeParticipant() {
        participantRepository.save(new Participant("user1", 20, "Krasnodar"));
        participantRepository.save(new Participant("user2", 25, "Krasnodar"));
        participantRepository.save(new Participant("user3", 30, "Krasnodar"));
    }

    @Test
    public void testStartLottery() {
        //Количество участников < 3
        assertEquals(0, participantRepository.count());
        Throwable thrown = assertThrows(UnsupportedOperationException.class, () -> lotteryService.startLottery());
        assertNotNull(thrown.getMessage());

        //Количество участников > 2
        addThreeParticipant();
        assertEquals(3, participantRepository.count());
        Winner winner = lotteryService.startLottery();
        assertNotNull(winner);
        assertEquals(1, winnerRepository.count());
        assertTrue(winnerRepository.findAll().contains(winner));
        assertEquals(0, participantRepository.count());

        //Повторный розыгрыш
        addThreeParticipant();
        Winner winner2 = lotteryService.startLottery();
        assertNotNull(winner);
        assertEquals(2, winnerRepository.count());
        assertTrue(winnerRepository.findAll().contains(winner2));
        assertEquals(0, participantRepository.count());
    }
}