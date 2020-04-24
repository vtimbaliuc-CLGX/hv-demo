package com.demo.api.repository.implementations.sqldb;

import com.demo.api.entity.Listing;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ListingRepo extends CrudRepository<Listing, UUID>, ListingRepo {}
