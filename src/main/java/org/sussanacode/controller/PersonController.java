package org.sussanacode.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sussanacode.model.Person;
import org.sussanacode.service.PersonService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/person")
public class PersonController {

    private final PersonService personService;


    //perform rest crud operations

    @GetMapping
    public List<Person> getPerson() {
        return personService.personList();

    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.addPerson(person);

    }

    @PutMapping(path = "{personId}")
    public void editPerson(@PathVariable("personId") Long id,
                            @RequestParam(required = false) String firstname,
                            @RequestParam(required = false) String lastname,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) String address,
                            @RequestParam(required = false) String city,
                            @RequestParam(required = false) String state,
                            @RequestParam(required = false) String zipcode)
    {
        personService.updatePerson(id, firstname, lastname , email, address, city, state, zipcode);
    }


    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long id){
        personService.deletePerson(id);
    }




}

