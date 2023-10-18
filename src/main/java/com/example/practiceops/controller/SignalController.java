package com.example.practiceops.controller;

import com.example.practiceops.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workflow")
public class SignalController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/start")
    public ResponseEntity<?> startWorkflow(){
        kafkaService.send("signal-workflow-topic","{start-workflow}");
        return new ResponseEntity<>("workflow-started", HttpStatusCode.valueOf(200));
    };

    @PostMapping("/signal")
    public ResponseEntity<?> signalWorkflow(){
        kafkaService.send("signal-workflow-topic","{signal-workflow}");
        return new ResponseEntity<>("workflow-signaled", HttpStatusCode.valueOf(200));
    };



}
