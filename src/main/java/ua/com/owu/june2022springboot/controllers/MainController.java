package ua.com.owu.june2022springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.june2022springboot.models.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    ArrayList<Customer> customers = new ArrayList<>();

    public MainController() {
        customers.add(new Customer(1, "vasya"));
        customers.add(new Customer(2, "petya"));
        customers.add(new Customer(3, "kolya"));
    }

    @GetMapping({"/customers"})
//    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(
                this.customers, HttpStatus.OK);
    }


    @PostMapping("/customers")
    public ResponseEntity<List<Customer>> addCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        this.customers.add(customer);
        return new ResponseEntity<>(this.customers, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{xxx}") // localhost:8080/cutomers/3
    public ResponseEntity<Customer>
    getCustomer(@PathVariable("xxx") int id) {
        System.out.println(id);
        Customer customer = this.customers.get(id - 1);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<List<Customer>> deleteCustpmer(@PathVariable int id) {
        this.customers.remove(id - 1);
        return new ResponseEntity<>(this.customers, HttpStatusCode.valueOf(200));

    }
}



