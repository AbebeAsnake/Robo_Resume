package com.abebe.demo;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3,max = 20)
    private String firstName;
    @NotNull
    @Size(min=3, max = 20)
    private String lastName;
    @Email
    private String email;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;
    private String Adress;

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void setState(String state) {
        State = state;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    private String State ;

    public String getAdress() {
        return Adress;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    public Long getZipCode() {
        return zipCode;
    }

    private String City;
    private Long zipCode;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
