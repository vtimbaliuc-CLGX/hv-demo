package com.demo.api.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = false)
public class Agent extends EntityWithUUID{
    private String firstName;
    private String lastName;
}
