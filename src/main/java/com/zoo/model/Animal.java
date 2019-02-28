package com.zoo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalid;

    private String animaltype;

    // when we delete one animal we want to make sure all related fields are deleted also
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "zooanimals",
        joinColumns = {@JoinColumn(name = "zooid")},
        inverseJoinColumns = {@JoinColumn(name = "animalid")})
    private Set<Zoo> zoos;

    public Animal() {
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<Zoo> getZoos() {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos) {
        this.zoos = zoos;
    }
}
