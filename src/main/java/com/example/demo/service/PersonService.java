package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {
    public Person addPerson(Person person);
    public Person editPerson(Long personId, Person person);
    public String deletePerson(Long personId);
    public String activatePerson(Long personId);
    public String deactivatePerson(Long personId);
    public List<Person> getAll();
    public List<Person> getAllActive();
}
