package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID customer_id;
    private String name;
    private String lastname;
    private String email;
    private Boolean activated;
    private String password;
    private Short age;
    private CustomerGender gender;
    private CustomerRol rol;

    @OneToMany (mappedBy = "customer")
    private Set<Event> events = new HashSet<>();

    @OneToMany (mappedBy = "customer")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();
    @OneToMany(mappedBy = "customer")
    private Set<Reaction> reactions=new HashSet<>();

    public Customer() {
    }

    public void addEvent(Event event){
        event.setCustomer(this);
        this.events.add(event);
    }

    public void addComment(Comment comment){
        comment.setCustomer(this);
        this.comments.add(comment);
    }

    public void addCustomerEvent(CustomerEventLocation customerEventLocation){
        customerEventLocation.setCustomer(this);
        this.customerEventLocations.add(customerEventLocation);
    }

    public Set<CustomerEventLocation> getCustomerEvents() {
        return customerEventLocations;
    }

    public void setCustomerEvents(Set<CustomerEventLocation> customerEventLocations) {
        this.customerEventLocations = customerEventLocations;
    }

    public UUID getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public CustomerGender getGender() {
        return gender;
    }

    public void setGender(CustomerGender gender) {
        this.gender = gender;
    }

    public CustomerRol getRol() {
        return rol;
    }

    public void setRol(CustomerRol rol) {
        this.rol = rol;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    public void addReaction(Reaction reaction){
        reaction.setCustomer(this);
        this.reactions.add(reaction);
    }
}
