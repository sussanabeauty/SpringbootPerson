package org.sussanacode.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sussanacode.model.Person;
import org.sussanacode.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepo;


    //all people in record
    public List<Person> personList() {
        return personRepo.findAll();
    }

    //create new person
    public void addPerson(Person person) {
        Optional<Person> personEmail = personRepo
                .findPersonByEmail(person.getEmail());


        //check to see if email already exist in database
        if(personEmail.isPresent()){
            throw new IllegalStateException("Person email already exist");
        }
        personRepo.save(person);

    }

    //update all field necessary

    @Transactional
    public void updatePerson(Long id, String firstname, String lastname,
                             String email, String address, String city, String state, String zipcode)
    {

        Person person = personRepo.findById(id)
                .orElseThrow(() -> new
                        IllegalStateException("Person with this id " + id + "does not exist."));


        if(firstname != null && firstname.length() > 0 &&
                !Objects.equals(person.getFirstname(), firstname))
        {
            person.setFirstname(firstname);

        }

        if(lastname != null && lastname.length() > 0 &&
                !Objects.equals(person.getLastname(), lastname))
        {
            person.setLastname(lastname);

        }

        if(email != null && email.length() > 0 &&
                !Objects.equals(person.getEmail(), email))
        {
            Optional<Person> studentEmail = personRepo
                    .findPersonByEmail(email);

            if(studentEmail.isPresent()){
                throw new IllegalStateException("This email already exist in records!");
            }
            person.setEmail(email);

        }

        if(address != null && address.length() > 0 &&
                !Objects.equals(person.getAddress(), address))
        {
            person.setAddress(address);

        }

        if(city != null && city.length() > 0 &&
                !Objects.equals(person.getCity(), city))
        {
            person.setCity(city);

        }

        if(state != null && state.length() > 0 &&
                !Objects.equals(person.getState(), state))
        {
            person.setState(state);

        }

        if(zipcode != null && zipcode.length() > 0 &&
                !Objects.equals(person.getZipCode(), zipcode))
        {
            person.setZipCode(zipcode);

        }

    }

//delete person's record from database
    public void deletePerson(Long id) {
        boolean personExist = personRepo.existsById(id);
        if(!personExist){
            throw new IllegalStateException("Person with this id " + id + "does not exist.");
        }
        personRepo.deleteById(id);
    }

}
