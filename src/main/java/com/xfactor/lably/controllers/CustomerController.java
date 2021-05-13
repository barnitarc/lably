package com.xfactor.lably.controllers;



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


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @GetMapping()
    public String customer(){
        return "Welcome to customer controller";
    }

    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/getCustomer")
    public ArrayList<Customer> getCustomer() {
        return customers;
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer cust)
    {
        cust.setName(cust.getName().toUpperCase());
        customers.add(cust);
        return cust;
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
