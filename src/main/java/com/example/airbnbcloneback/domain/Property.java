package com.example.airbnbcloneback.domain;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Property {

    @Id
    long id;
    int numberOfRooms;
    double price;
    boolean isAvailable;
    @OneToMany
    List<Photo> pictures;

    @Embedded
    Address address;

    @RolesAllowed("dfd")
    void m(){

    }

}
