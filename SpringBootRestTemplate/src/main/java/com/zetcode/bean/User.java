package com.zetcode.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
/*
 * The User bean maps to the JSON user object.
 *  Spring uses Jackson library to bind JSON data to Java classes.
 *   Since the JSON attributes do not match the Java attributes, we use @JsonProperty to fix this.
 */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("last_name")
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    @Override
    public String toString() {

        final var sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        
        return sb.toString();
    }
}