package ua.com.owu.june2022springboot.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class ActivationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String token = new UUID(100, 999999).toString();
    private LocalDateTime expire = LocalDateTime.now(ZoneId.of("Europe/Kiev")).plusDays(2); // 2 days from save to db


}
