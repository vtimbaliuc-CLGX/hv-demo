package com.demo.api.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper=false)
public class Listing extends EntityWithUUID {
    private String streetNumber;
    private String streetName;
    private String postalCode;
    private String city;
    private String country;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "listing_agent_id_fkey"))
    private Agent agent;
}
