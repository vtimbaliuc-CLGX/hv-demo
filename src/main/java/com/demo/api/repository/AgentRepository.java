package com.demo.api.repository;

import com.demo.api.entity.Agent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AgentRepository extends CrudRepository<Agent, UUID> {
}
