package com.example.lottery.controller;

import com.example.lottery.domain.Participant;
import com.example.lottery.domain.Winner;
import com.example.lottery.service.LotteryService;
import com.example.lottery.service.ParticipantService;
import com.example.lottery.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("lottery")
@RequiredArgsConstructor
public class LotteryController {

    private final ParticipantService participantService;
    private final LotteryService lotteryService;
    private final WinnerService winnerService;

    @GetMapping("/participant")
    public List<Participant> findAllParticipant() {
        return participantService.findAll();
    }

    @PostMapping("/participant")
    public ResponseEntity<?> save(@RequestBody Participant participant) {
        return new ResponseEntity<>(participantService.save(participant), HttpStatus.CREATED);
    }

    @GetMapping("/start")
    public ResponseEntity<?> start() {
        try {
            Winner winner = lotteryService.startLottery();
            return new ResponseEntity<>(winner, HttpStatus.OK);
        }
        catch (UnsupportedOperationException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/winners")
    public List<Winner> findAllWinner() {
        return winnerService.findAll();
    }
}
