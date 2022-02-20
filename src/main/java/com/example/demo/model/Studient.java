package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Studient {
    private int id;
    private String name;
    private String lastName;
    private String birthDate;

    public Studient() {
        id = 0;
        name = new String();
        lastName = new String();
        birthDate = new String();
    }

    public Studient(@JsonProperty("name") String name, @JsonProperty("lastname") String lastName, @JsonProperty("birthdate") String birthDate) {
        this.id = 0;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Studient(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("lastname") String lastName, @JsonProperty("birthdate") String birthDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Studient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Studient)) return false;
        Studient studient = (Studient) o;
        return getId() == studient.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
