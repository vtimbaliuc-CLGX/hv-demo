package com.demo.api.repository.implementations.sqldb;

import com.demo.api.entity.Agent;
import com.demo.api.repository.AgentRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AgentRepo extends CrudRepository<Agent, UUID>, AgentRepository {}
