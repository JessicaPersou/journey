package com.persou.journey.employer.datasources.model.valueObject;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String zipcode;
    private String city;
    private String state;
    private String country;

    protected Address() {
    }

    public Address(String street, String number, String neighborhood, String zipcode, String city, String state,
                   String country) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", number='" + number + '\'' +
            ", neighborhood='" + neighborhood + '\'' +
            ", zipcode='" + zipcode + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", country='" + country + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(number, address.number) &&
            Objects.equals(neighborhood, address.neighborhood) &&
            Objects.equals(zipcode, address.zipcode) && Objects.equals(city, address.city) &&
            Objects.equals(state, address.state) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, neighborhood, zipcode, city, state, country);
    }
}
