package ru.stqa.pft.addressbook.model;

import java.awt.*;
import java.util.Date;

public class ContactData {
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

    public ContactData(String firstname, String lastname, String address, String homePhone, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homePhone = homePhone;
        this.email = email;
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
