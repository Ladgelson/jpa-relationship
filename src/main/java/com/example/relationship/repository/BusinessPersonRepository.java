package com.example.relationship.repository;

import com.example.relationship.model.BusinessPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessPersonRepository extends JpaRepository<BusinessPerson, Integer> {
}
