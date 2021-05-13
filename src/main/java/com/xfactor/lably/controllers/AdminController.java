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

import com.xfactor.lably.entity.Admin;

@RestController
@RequestMapping("/admin")

public class AdminController{
    //@GetMapping() will work too. we dont need to put a / after admin in this case
    @GetMapping("/")
    public String admin(){
        return "This is when you enter 127.0.0.1:8081/admin/";
    }
    ArrayList<Admin> admins = new ArrayList<>();

    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmin() {
        return admins;
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        String name = admin.getName();
        name = "Hello " + name;
        admin.setName(name);
        String username=admin.getUsername();
        //username="U"+username;
        admin.setUsername(username);
        String pass=admin.getPassword();
        pass=pass.toUpperCase();
        admin.setPassword(pass);
        admin.setId(UUID.randomUUID().toString());
        admins.add(admin);
        
        return admin;
    }
    @GetMapping("/getAdminsByUsername")
    @ResponseBody
    public Admin getAdminByName(@RequestParam String name5){
        
        for(Admin l:admins){
            if(name5.equals(l.getUsername())==true)
                return l;
        }
        abc();
        System.out.println("not yet available");
        return null;
    }

    public String abc(){
        return "not yet available!!!!";
    }

}