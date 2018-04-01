package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        ContactData contactData = new ContactData("firstname", "lastname", "address", "phone", "email", "test11");
        app.goTo().homePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.goTo().contactCreationPage();
            app.getContactHelper().createContact(contactData);
            app.goTo().homePage();
        }
        ContactData newContactData = new ContactData("firstname2", "lastname2", "address2", "phone2", "email1", null);
        List<ContactData> contactsBefore = app.getContactHelper().getContactsList();
        app.getContactHelper().initContactModification(contactsBefore.size() - 1);
        app.getContactHelper().fillContactForm(newContactData, false);
        app.getContactHelper().submitContactModification();
        app.goTo().homePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactsList();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size(), "Contacts count must be the same after modification");

        contactsBefore.remove(contactsBefore.size() - 1);
        contactsBefore.add(newContactData);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
