package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        ContactData contactData = new ContactData("firstname", "lastname", "address", "phone", "email","test11");
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(contactData);
            app.getNavigationHelper().gotoHomePage();
        }
        List<ContactData> contactsBefore = app.getContactHelper().getContactsList();
        app.getContactHelper().initContactModification(contactsBefore.size()-1);
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactsList();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size(), "Contacts count must be the same after modification");
    }
}
