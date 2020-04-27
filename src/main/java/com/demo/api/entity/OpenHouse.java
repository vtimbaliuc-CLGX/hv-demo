package com.demo.api.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

@Entity
@EqualsAndHashCode(callSuper = false)
public class OpenHouse extends EntityWithUUID{
    public int startTime;
    public int endTime;
    public DayOfWeek day;
    public Month month;
    public Year year;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "open_house_listing_id_fkey"))
    public Listing listing;
}
