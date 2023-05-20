package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Person;
import com.example.demo.repo.PersonRepo;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public Person editPerson(Long personId, Person person) {
        Person person1 = personRepo.findById(personId).get();
        person1.setName(person.getName());
        person1.setAddress(person.getAddress());
        person1.setPhoneNumber(person.getPhoneNumber());
        person1.setGender(person.getGender());
        person1.setActive(person.getActive());
        return personRepo.save(person1);
    }

    @Override
    public String deletePerson(Long personId) {
        personRepo.deleteById(personId);
        return "Person deleted Successfully with Id: " + personId;
    }

    @Override
    public String activatePerson(Long personId) {
        Person person = personRepo.findById(personId).get();
        if(person.getActive() == Boolean.FALSE) {
            person.setActive(Boolean.TRUE);
            personRepo.save(person);
            return "Activated.";
        } else {
            return "Person is already active.";
        }
    }

    @Override
    public String deactivatePerson(Long personId) {
        Person person = personRepo.findById(personId).get();
        if(person.getActive() == Boolean.TRUE) {
            person.setActive(Boolean.FALSE);
            personRepo.save(person);
            return "Deactivated";
        } else {
            return "Person is already deactivated.";
        }
    }

    @Override
    public List<Person> getAll() {
        return personRepo.findAll();
    }

    @Override
    public List<Person> getAllActive() {
        List<Person> personList = personRepo.findAll();
        List<Person> activePersonList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getActive() == Boolean.TRUE) {
                activePersonList.add(person);
            }
        }
        return activePersonList;
    }
}
