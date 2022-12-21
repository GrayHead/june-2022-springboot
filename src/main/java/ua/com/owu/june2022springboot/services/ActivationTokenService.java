package ua.com.owu.june2022springboot.services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.com.owu.june2022springboot.dao.ActivationTokenDAO;
import ua.com.owu.june2022springboot.models.ActivationToken;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ActivationTokenService {
    private ActivationTokenDAO activationTokenDAO;

    @Scheduled(fixedDelay = 2000)
    public void deleteTokenIfExpired() {
        System.out.println("work");
        List<ActivationToken> tokenList = activationTokenDAO.findAll();
        tokenList.forEach(activationToken -> {
            if (LocalDateTime.now().isAfter(activationToken.getExpire())) {
                activationTokenDAO.deleteById(activationToken.getId());
            }
        });

    }
}
