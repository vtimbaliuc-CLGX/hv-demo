package com.demo.api.services;

import com.demo.api.entity.Agent;
import com.demo.api.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@ComponentScan("com.demo.api.repository")
@Service
public class AgentService {
    @Autowired
    AgentRepository agentRepository;

    public ResponseEntity<Agent> testFunction(){
        agentRepository.testFunction();
        return null;
    }
}
