package io.codelex.firstsample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    @JsonProperty("firstName")
    private String name;
    @JsonProperty("lastName")
    private String surname;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
