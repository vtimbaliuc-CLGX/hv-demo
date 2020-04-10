package com.demo.api.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class OpenHouse extends EntityWithUUID {

    public int startTime;
    public int endTime;
    public DayOfWeek day;
    public Month month;
    public Year year;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "open_house_listing_id_fkey"))
    public Listing listing;

}
