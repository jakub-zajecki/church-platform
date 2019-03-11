package com.churcher.churchplatform.model;

import javax.persistence.*;

@Entity
public class Priest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "CHURCH_ID")
    private Church church;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

    public Long getId() {
        return id;
    }
}
