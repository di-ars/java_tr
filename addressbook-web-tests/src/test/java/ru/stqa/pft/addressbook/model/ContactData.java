package ru.stqa.pft.addressbook.model;

import java.awt.*;
import java.util.Date;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private Image photo;
    private String title;
    private String company;
    private String address;

    //Telephone fields
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String faxPhone;

    private String email;
    private String email2;
    private String email3;
    private String homepage;
    private Date birthday;
    private Date anniversary;
    private String group; //todo group not String

    //Secondary fieds
    private String addressSecondary;
    private String home;
    private String notes;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getAnniversary() {
        return anniversary;
    }

    public String getAddressSecondary() {
        return addressSecondary;
    }

    public String getHome() {
        return home;
    }

    public String getNotes() {
        return notes;
    }

    public Image getPhoto() {
        return photo;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;

    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
