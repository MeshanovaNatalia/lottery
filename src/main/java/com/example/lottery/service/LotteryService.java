package com.example.lottery.service;

import com.example.lottery.domain.Participant;
import com.example.lottery.domain.Winner;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class LotteryService {

    private final ParticipantService participantService;
    private final WinnerService winnerService;

    /**
     * Получить сумму выигрыша.
     *
     * @return сумму выигрыша (от 1 -1000 рандом генератор);
     */
    protected Integer getWinningAmount() {
        return random(1, 1000);
    }

    /**
     * Получить победителя с помощью рандом генератора.
     *
     * @return Participant
     */
    protected Participant getRandomParticipant() {
        Integer index = random(0, participantService.count().intValue() - 1);
        return participantService.findAll().get(index);
    }

    /**
     * Рандом генератор сайт https://www.random.org/
     *
     * @param min минимальное значение из диапазона
     * @param max максимальное значение из диапазона
     * @return
     */
    private Integer random(@NonNull Integer min, @NonNull Integer max) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://www.random.org/integers/?num=1&min=%d&max=%d&col=1&base=10&format=plain&rnd=new", min, max);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return Integer.parseInt(response.getBody().replaceAll("\\D+", ""));
    }

    /**
     * Запустить лотерею.
     *
     * @return
     */
    public Winner startLottery() {
        if (participantService.count() < 3) {
            throw new UnsupportedOperationException("Запуск лотереи невозможен: недостаточно участников.");
        }
        Participant participant = getRandomParticipant();
        participantService.deleteAll();
        return winnerService.save(participant, getWinningAmount());
    }
}
