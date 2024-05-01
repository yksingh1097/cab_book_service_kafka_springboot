package com.kafkaDemo.cabbookdriver.controller;

import com.kafkaDemo.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    CabLocationService cabLocationService;


    @PostMapping("/updateLocation")
    public ResponseEntity updateLocation(){
        //logic to get lat and long(assume random values as lat and longi) till the
        // driver reaches the user location
        int pathForDriverToTravel=100;
        while(pathForDriverToTravel>0){
//            System.out.println(Math.random()+" , "+Math.random());
            cabLocationService.updateLocation(Math.random()+" , "+Math.random());

            try {
                Thread.sleep(1000);  // we want the data to be updated in kafka after every second
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pathForDriverToTravel--;

        }


        return new  ResponseEntity<>(Map.of("message","Locaiton updated"), HttpStatus.OK);
    }

}
