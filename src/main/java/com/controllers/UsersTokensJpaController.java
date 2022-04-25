/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import java.io.Serializable;
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
import com.entityes.UsersTokens;
import com.persistence.UsersTokensJpaFacade;
/**
/**
 *
 * @author Dario
 */
@RestController
public class UsersTokensJpaController implements Serializable {
    UsersTokensJpaFacade userTokroenFacade;
   @RequestMapping(value="/api/userTokens", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserTokens(){
       System.out.print("Hola soy getUserTokens() ::: y me estoy ejecutando correctamente !!!");
        UsersTokens usToken = userTokroenFacade.findByToken("ffdskfjsdafl23ru32u432ufdsa");
        
       
       
       return new ResponseEntity<String>("Hola soy getUserTokens() ::: y me estoy ejecutando correctamente !!!", HttpStatus.OK);
    }
    
   
    
    
}
