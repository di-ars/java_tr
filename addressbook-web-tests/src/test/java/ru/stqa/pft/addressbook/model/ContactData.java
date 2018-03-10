package ru.stqa.pft.addressbook.model;

import java.awt.*;
import java.util.Date;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final Image photo;
    private final String title;
    private final String company;
    private final String address;

    //Telephone fields
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String faxPhone;

    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final Date birthday;
    private final Date anniversary;
    private final String group; //todo group not String

    //Secondary fieds
    private final String addressSecondary;
    private final String home;
    private final String notes;

    public ContactData(String firstname, String middlename, String lastname, String nickname, Image photo, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String faxPhone, String email, String email2, String email3, String homepage, Date birthday, Date anniversary, String group, String addressSecondary, String home, String notes) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.photo = photo;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.faxPhone = faxPhone;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.birthday = birthday;
        this.anniversary = anniversary;
        this.group = group;
        this.addressSecondary = addressSecondary;
        this.home = home;
        this.notes = notes;
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
}
