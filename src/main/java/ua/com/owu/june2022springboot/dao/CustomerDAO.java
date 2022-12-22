package ua.com.owu.june2022springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.com.owu.june2022springboot.models.Customer;
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findCustomerByLogin(String login);
}
