package com.demo.api.entity;

import lombok.*;

import javax.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class Agent extends EntityWithUUID {
    private String firstName;
    private String lastName;
}
