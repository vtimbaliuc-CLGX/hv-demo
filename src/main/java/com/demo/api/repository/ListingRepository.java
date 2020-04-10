package com.demo.api.repository;

import com.demo.api.entity.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListingRepository extends CrudRepository<Listing, UUID> {
}
