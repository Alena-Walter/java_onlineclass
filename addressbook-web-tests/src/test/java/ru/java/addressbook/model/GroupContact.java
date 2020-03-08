package ru.java.addressbook.model;

import java.util.Objects;

public class GroupContact {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String mobile;
    private final String email;

    public GroupContact(String firstname, String lastname, String address, String mobile, String email) {
        this.id = null;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public GroupContact(String id, String firstname, String lastname, String address, String mobile, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "GroupContact{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupContact contact = (GroupContact) o;
        return Objects.equals(id, contact.id) &&
                Objects.equals(firstname, contact.firstname) &&
                Objects.equals(lastname, contact.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }


}
