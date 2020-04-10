package com.demo.api.controller;

import com.demo.api.entity.Agent;
import com.demo.api.services.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AgentController {
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
}