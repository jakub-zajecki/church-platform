package com.churcher.churchplatform.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Test implements Serializable {

    private static final long serialVersionUID = -1764970284520387975L;
    public String name;

    public Test() {
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }
}


