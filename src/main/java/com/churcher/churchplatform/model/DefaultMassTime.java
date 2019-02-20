package com.churcher.churchplatform.model;

import javax.persistence.*;
import java.time.LocalTime;

@MappedSuperclass
public abstract class DefaultMassTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime massTime;
    @ManyToOne
    @JoinColumn(name = "CHURCH_ID")
    private Church church;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getMassTime() {
        return massTime;
    }

    public void setMassTime(LocalTime massTime) {
        this.massTime = massTime;
    }

    public Church getChurch() {
        return church;
    }

    public void setChurch(Church church) {
        this.church = church;
    }

}
