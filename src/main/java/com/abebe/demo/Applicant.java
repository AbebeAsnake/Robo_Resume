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

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        State = state;
    }

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

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Long getZipCode() {
        return zipCode;
    }

    public String getState() {
        return State;
    }

    @NotNull
    @Size(min=3, max = 20)
    private String lastName;
    @Email
    private String email;
    private String country;
    private String phoneNumber;
    private String address;
    private String city;
    private Long zipCode;
    private String State ;


}
