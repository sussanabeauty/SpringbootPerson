package org.sussanacode.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sussanacode.model.Person;
import org.sussanacode.repository.PersonRepository;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.*;

@Configuration
public class PersonConfiguration {

    @Bean
    CommandLineRunner cmdRunner (PersonRepository personRepo){
        return args -> {
            Person person1 = new Person(
                    "Alan",
                    "Wheat",
                    LocalDate.of(1994, APRIL, 29),
                    Person.sex.MALE,
                    "alan.wheat@gmail.com",
                    "2202 North Sweets St",
                    "Duluth",
                    "Georgia",
                    "60067"
            );

            Person person2 = new Person(
                    "Cassandra",
                    "Adams",
                    LocalDate.of(1997, JULY, 13),
                    Person.sex.FEMALE,
                    "cassandra.adams@gmail.com",
                    "317 Boltholt St",
                    "Davenport",
                    "Ohio",
                    "55021"

            );

            Person person3 = new Person(
                    "Amanda",
                    "Jones",
                    LocalDate.of(1999, MARCH, 20),
                    Person.sex.FEMALE,
                    "amanda.jones@ymail.com",
                    " 4603 SouthWest Second St",
                    "Manhole",
                    "Kansas",
                    "64307"

            );

            Person person4 = new Person(
                    "Mac",
                    "Benns",
                    LocalDate.of(1995, DECEMBER, 05),
                    Person.sex.MALE,
                    "mac.benns@gmail.com",
                    "83011 8th Ave",
                    "Penn Valley",
                    "Pennsylvania",
                    "53022"
            );


            personRepo.saveAll(List.of(person1, person2, person3, person4));

        };
    }
}
