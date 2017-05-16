package model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by domino on 5/15/17.
 */
public class Contact {

    private String displayName;

    private String name;

    private String surname;

    private String address;

    private String email;

    private String phoneNo;

    public Contact() {
    }

    public Contact(String displayName, String name, String surname, String address, String email, String phoneNo) {
        this.displayName = displayName;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return new EqualsBuilder()
                .append(displayName, contact.displayName)
                .append(name, contact.name)
                .append(surname, contact.surname)
                .append(address, contact.address)
                .append(email, contact.email)
                .append(phoneNo, contact.phoneNo)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(displayName)
                .append(name)
                .append(surname)
                .append(address)
                .append(email)
                .append(phoneNo)
                .toHashCode();
    }

    @Override
    public String toString() {
        return displayName;
    }
}
