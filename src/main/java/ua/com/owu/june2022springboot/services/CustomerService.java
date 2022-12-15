package ua.com.owu.june2022springboot.services;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.com.owu.june2022springboot.dao.CustomerDAO;
import ua.com.owu.june2022springboot.models.Customer;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerDAO customerDAO;

    public void save(Customer customer) {
        if (customer.getId() > 0) {
            customerDAO.save(customer);
        } else {
            throw new RuntimeException("id < 0!!!!!!!!");
        }

    }

    public ResponseEntity<List<Customer>> customerListByName(String name) {
        if (name != null && !name.isBlank()) {
            List<Customer> customerByName = customerDAO.findCustomerByName(name);
            System.out.println(customerByName);
            return new ResponseEntity<>(customerByName, HttpStatusCode.valueOf(200));
        } else {
            throw new RuntimeException();
        }


    }

}
