package com.example.demo.repo;

import com.example.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
