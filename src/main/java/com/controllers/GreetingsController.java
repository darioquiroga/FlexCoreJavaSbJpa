/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
/**
 *
 * @author Dario
 */

@RestController

public class GreetingsController {
    @RequestMapping(value="/api/greetings", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getGreetings(){
       System.out.print("Hola soy GreetingsController()");
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }
    
    @RequestMapping(value="/tester", method=RequestMethod.GET)
    @ResponseBody
    public String exampleMethod() {
        System.out.print("Hola soy exampleMethod()");
             return "hola mundo soy exampleMethod()";
    }
    
}