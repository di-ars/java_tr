package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().openHomePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone").withEmail("email").withGroup("test11"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> contactsBefore = app.contact().all();
        ContactData modifiedContact = contactsBefore.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstname2").withLastname("lastname2").withAddress("address2").withHomePhone("phone2").withEmail("email1");
        app.contact().modify(contact);
        Set<ContactData> contactsAfter = app.contact().all();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size(), "Contacts count must be the same after modification");

        contactsBefore.remove(modifiedContact);
        contactsBefore.add(contact);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
