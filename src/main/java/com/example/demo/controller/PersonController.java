package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/edit/{personId}")
    public Person editPerson(@PathVariable("personId") Long personId, @RequestBody Person person) {
        return personService.editPerson(personId, person);
    }

    @DeleteMapping("/delete/{personId}")
    public String deletePerson(@PathVariable("personId") Long personId) {
        return personService.deletePerson(personId);
    }

    @PutMapping("/activate/{personId}")
    public String activatePerson(@PathVariable("personId") Long personId) {
        return personService.activatePerson(personId);
    }

    @PutMapping("/deactivate/{personId}")
    public String deactivatePerson(@PathVariable("personId") Long personId) {
        return personService.deactivatePerson(personId);
    }

    @GetMapping("/listAll")
    public List<Person> listAll() {
        return personService.getAll();
    }

    @GetMapping("/listAllActive")
    public List<Person> listAllActive() {
        return personService.getAllActive();
    }
}
