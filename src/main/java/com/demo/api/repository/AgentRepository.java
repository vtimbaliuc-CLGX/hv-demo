package com.demo.api.repository;

import com.demo.api.entity.Agent;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends BaseRepository<Agent> {
    Agent getAgentDetails();
}
