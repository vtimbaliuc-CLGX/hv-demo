package com.demo.api.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@EqualsAndHashCode(callSuper = false)
public class Listing extends EntityWithUUID{
    private String streetNumber;
    private String streetName;
    private String postalCode;
    private String city;
    private String country;

    //    @JoinColumn(foreignKey = @ForeignKey(name = "listing_agent_id_fkey"))
    @ManyToOne(fetch = FetchType.LAZY)
    private Agent agent;
}
