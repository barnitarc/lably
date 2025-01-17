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
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.repository.LabRepository;

@RestController
@RequestMapping("/lab")

public class LabController{

    @Autowired
    LabRepository labRepository;
    ArrayList<Lab> labs = new ArrayList<>();

    @GetMapping("/getLabs")
    public List<Lab> getLabs() {
        List<Lab> persistedLabs=labRepository.findAll();
        return persistedLabs;
        
    }

    @PostMapping("/addLab")
    public Lab addLab(@RequestBody Lab lab) {
        /*String name = lab.getName();
        //name = "Hello " + name;
        lab.setName(name);
        String phone=lab.getPhone();
        phone="+91-"+phone;
        lab.setPhone(phone);
        String pin=lab.getPincode();
        pin="P"+pin;
        lab.setPincode(pin);
        labs.add(lab);
        */
        Lab persistedLab= labRepository.save(lab);
        return persistedLab;
        
    }
    @GetMapping("/getLabsByName")
    @ResponseBody
    public Lab getLabByName(@RequestParam String name4){
        
        for(Lab l:labs){
            if(name4.equals(l.getName())==true)
                return l;
        }
        abc();
        return null;
    }

    public String abc(){
        return "not yet available!!!!";
    }

}