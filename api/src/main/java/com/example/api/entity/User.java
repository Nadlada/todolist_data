package com.example.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    private long id;

    private String firstName;
    private String lastName;

    private String emailId;

    public User(){}

    public User(String firstName,String lastName, String emailId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id =id;
    }

    @Column(name = "first_name",nullable = false)
    public String getFirstname() {
        return firstName;
    }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    @Column(name = "last_name",nullable = false)
    public String getLastname() {
        return lastName;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    @Column(name = "email_address",nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
