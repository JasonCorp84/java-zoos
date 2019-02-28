package com.zoo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    // One Zoo to many telephones
    // this has to be the same as the Zoo zoo which serves as a foreign key
    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoo")
    private Set<Telephone> phones = new HashSet<>();

    // the mappedBy zoos is equal with the other side od the manytomany relationship
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "zoos")
    @JsonIgnoreProperties("zoos")
    private Set<Animal> animals;

    public Zoo() {
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public Set<Telephone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Telephone> phones) {
        this.phones = phones;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}
