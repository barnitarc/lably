package com.xfactor.lably.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import com.xfactor.lably.entity.Lab;

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

    // http://localhost:8080/test/hello2?id=16
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
    @PostMapping("/addTest")
    public @ResponseBody Lab addLab(@RequestBody Lab lab){
        
        return lab;
    }

}
