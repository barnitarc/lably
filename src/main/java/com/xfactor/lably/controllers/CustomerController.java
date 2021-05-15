package com.xfactor.lably.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;

import com.xfactor.lably.entity.Customer;
import com.xfactor.lably.repository.CustomerRepository;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    public String customer(){
        return "Welcome to customer controller";
    }

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/getCustomer")
    public List<Customer> getCustomer() {
        List<Customer> persistedCustomers=customerRepository.findAll();
        return persistedCustomers;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer cust)
    {
        cust.setName(cust.getName().toUpperCase());
        Customer persistedcust= customerRepository.save(cust);
        return persistedcust;
        
    }

    @GetMapping("/getCustomersByName")
    @ResponseBody
    public Customer getCustomerByName(@RequestParam String n){
        
        for(Customer l:customers){
            if(n.equalsIgnoreCase(l.getName())==true)
                return l;
        }
    
        
        return null;
    }
    
}
