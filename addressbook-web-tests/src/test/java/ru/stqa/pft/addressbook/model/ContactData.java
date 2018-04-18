package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;

    @Expose
    @Column(name = "firstname")
    private String firstname;

    @XStreamOmitField
    @Transient
    private String middlename;

    @Expose
    @Column(name = "lastname")
    private String lastname;

    @XStreamOmitField
    @Transient
    private String nickname;

    @XStreamOmitField
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    @XStreamOmitField
    @Transient
    private String title;

    @XStreamOmitField
    @Transient
    private String company;

    @Expose
    @Transient
    private String address;

    //Telephone fields
    @XStreamOmitField
    @Transient
    private String allPhones;

    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;

    @XStreamOmitField
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;

    @XStreamOmitField
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;

    @XStreamOmitField
    @Transient
    private String faxPhone;

    @XStreamOmitField
    @Transient
    private String allEmails;
    @Expose
    @Transient
    private String email;
    @XStreamOmitField
    @Transient
    private String email2;
    @XStreamOmitField
    @Transient
    private String email3;
    @XStreamOmitField
    @Transient
    private String homepage;
    @XStreamOmitField
    @Transient
    private Date birthday;
    @XStreamOmitField
    @Transient
    private Date anniversary;

    @Expose
    @Transient
    private String group; //todo group not String

    //Secondary fieds
    @XStreamOmitField
    @Transient
    private String addressSecondary;
    @XStreamOmitField
    @Transient
    private String home;
    @XStreamOmitField
    @Transient
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

    public String getAllPhones() {
        return allPhones;
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

    public String getAllEmails() {
        return allEmails;
    }

    public String getEmail() {
        return email;
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

    public File getPhoto() {
        return new File(photo);
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
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

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
