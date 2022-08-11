package com.example.try2.Repositories;

import com.example.try2.Entities.ContactDetails;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailRep extends CrudRepository<ContactDetails, Integer> {
}
