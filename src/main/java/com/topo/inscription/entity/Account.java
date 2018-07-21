package com.topo.inscription.entity;

import java.util.Date;

public class Account {

    private int id;
    private String name;
    private String surname;
    private Date birthDate;
    private char gender;
    private String email;
    private String telephone;
    private String webSite;
    private String coutry;
    private String region;
    private String city;
    private String street;
    private String code;
    private String passwordHash;

    public Account() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (gender != account.gender) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (surname != null ? !surname.equals(account.surname) : account.surname != null) return false;
        if (birthDate != null ? !birthDate.equals(account.birthDate) : account.birthDate != null) return false;
        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        if (telephone != null ? !telephone.equals(account.telephone) : account.telephone != null) return false;
        if (webSite != null ? !webSite.equals(account.webSite) : account.webSite != null) return false;
        if (coutry != null ? !coutry.equals(account.coutry) : account.coutry != null) return false;
        if (region != null ? !region.equals(account.region) : account.region != null) return false;
        if (city != null ? !city.equals(account.city) : account.city != null) return false;
        if (street != null ? !street.equals(account.street) : account.street != null) return false;
        if (code != null ? !code.equals(account.code) : account.code != null) return false;
        return passwordHash != null ? passwordHash.equals(account.passwordHash) : account.passwordHash == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (coutry != null ? coutry.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", webSite='" + webSite + '\'' +
                ", coutry='" + coutry + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", code='" + code + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }
}
