package ua.com.owu.june2022springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.june2022springboot.models.ActivationToken;

public interface ActivationTokenDAO extends JpaRepository<ActivationToken, Integer> {
}
