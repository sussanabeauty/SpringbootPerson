package org.sussanacode.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@ToString
@NoArgsConstructor
public class Person {

    public enum sex {
        MALE,FEMALE;
    }

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate DOB;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private sex gender;
    private String email;
    private String address;
    private String city;
    private String state;
    private String zipCode;


    public Person(String firstname, String lastname, LocalDate DOB,
                  sex gender, String email, String address,
                  String city, String state, String zipCode)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.DOB = DOB;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }



    public Integer getAge() {

        return Period.between(this.DOB, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public sex getGender() {
        return gender;
    }

    public void setGender(sex gender) { this.gender = gender; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}