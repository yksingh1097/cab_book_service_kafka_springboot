package com.kafkaDemo.cabbookdriver.service;


import com.kafkaDemo.cabbookdriver.contant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateLocation(String location){

        try{
        kafkaTemplate.send(AppConstant.CAB_LOCATION,location);
        return true;
        }
        catch (Exception e) {
            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            return false;
        }




//
//        try {
//            kafkaTemplate.send(AppConstant.CAB_LOCATION, location); // Add .get() to wait for the send operation to complete
//            return true;
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace(); // Handle the exception according to your application's error handling strategy
//            return false;
//        }
    }

}
