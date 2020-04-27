package com.demo.api.controller;

import com.demo.api.entity.Agent;
import com.demo.api.services.AgentService;
import com.demo.api.tools.ClaritySession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class AgentController {
    @Autowired
    AgentService agentService;
    /*
    /* Temporarily Empty to test something

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agent> getAgentById(@PathVariable String id) {
        Agent agent = AgentService.find(id);
        return ResponseEntity.ok(agent);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Agent> createAgent(@PathVariable String firstName, @PathVariable String lastName) {
        return ResponseEntity.ok();
    }
     */
    @RequestMapping("/test")
    public ResponseEntity<Agent> testFunction() throws IOException {
        return agentService.testFunction();
    }
}