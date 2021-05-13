package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import com.xfactor.lably.entity.Lab;
import com.xfactor.lably.entity.Test;

@RestController
@RequestMapping("/test")
public class TestController {

    // http://localhost:8080/test/hello
    @GetMapping("/hello")
    public String hello() {
        return "Greetings from XFACTOR!!!";
    }

    // http://localhost:8080/test/hello/xfactor
    @GetMapping("/hello/{name1}")
    @ResponseBody
    public String index_greetings(@PathVariable String name1) {
        return "Greetings :" + name1;
    }

    @GetMapping("/hello/{name1}/{name3}")
    @ResponseBody
    public String index_greetings2(@PathVariable String name1,@PathVariable String name3) {
        return "Greetings :" + name1+ " "+ name3;
    }

    // http://localhost:8080/test/hello2?id=16
    // @RequestMapping(method=RequestMethod.GET,value="/hello2")
    @GetMapping("/hello2")
    @ResponseBody
    public String getFoos(@RequestParam String id,@RequestParam String name) {
        return "ID: " + id+"\nName: "+name;
    }

    @GetMapping("/hello3")
    @ResponseBody
    public Map<String,String> hello3(@RequestParam String id1,@RequestParam String name2) {
        Map<String,String> respoMap=new HashMap<>();
        respoMap.put("id",id1);
        respoMap.put("name",name2);
        return respoMap;
    }
    


    @GetMapping()
    public String test(){
        return "Welcome to test controller";
    }
    ArrayList<Test> tests = new ArrayList<>();

    @GetMapping("/getTests")
    public ArrayList<Test> getTest() {
        return tests;
    }

    @PostMapping("/addTest")
    public Test addAdmin(@RequestBody Test t) {
        t.setName(t.getName().toUpperCase());
        tests.add(t);
        return t;

    }

    @GetMapping("/getTestByName")
    @ResponseBody
    public Test getTestByName(@RequestParam String n){
        
        for(Test l:tests){
            if(n.equalsIgnoreCase(l.getName())==true)
                return l;
        }
    
        
        return null;
    }



}
