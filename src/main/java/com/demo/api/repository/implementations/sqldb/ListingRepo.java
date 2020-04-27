package com.demo.api.repository.implementations.sqldb;

import com.demo.api.entity.Listing;
import com.demo.api.repository.ListingRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListingRepo extends CrudRepository<Listing, UUID>, ListingRepository {}
