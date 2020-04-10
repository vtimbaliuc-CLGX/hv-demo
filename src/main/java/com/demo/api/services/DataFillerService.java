package com.demo.api.services;

import com.demo.api.entity.Agent;
import com.demo.api.entity.Listing;
import com.demo.api.repository.AgentRepository;
import com.demo.api.repository.ListingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class DataFillerService {
    private final AgentRepository agentRepository;
    private final ListingRepository listingRepository;

    public DataFillerService(AgentRepository agentRepository, ListingRepository listingRepository) {
        this.agentRepository = agentRepository;
        this.listingRepository = listingRepository;
    }

    @PostConstruct
    @Transactional
    public void fillData() {
        Agent slava = new Agent("Slava", "Timbaliuc");
        Agent rahul = new Agent("Rahul", "Shardha");

        agentRepository.save(slava);
        agentRepository.save(rahul);

        Listing office = new Listing().builder()
                .streetNumber("30")
                .streetName("Adelaide")
                .city("Toronto")
                .country("Canada")
                .postalCode("M5C3G6")
                .agent(rahul)
                .build();

        Listing simpsons = new Listing().builder()
                .streetNumber("742")
                .streetName("Evergreen Terrace")
                .city("Springfield")
                .country("United States")
                .postalCode("90210")
                .agent(slava)
                .build();

        listingRepository.save(office);
        listingRepository.save(simpsons);
    }

}
