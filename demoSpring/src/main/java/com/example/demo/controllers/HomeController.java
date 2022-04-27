package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.HashMap;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    //@RequestMapping(path = "/", method = RequestMethod.GET)//value o path
    @GetMapping(path = {"/saludo","/bye"})
    public HashMap<String, String> home(){

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");
        return map;
    }
    @GetMapping(path = "/name")
    public Object name(){
        return "Name";
    }
}
