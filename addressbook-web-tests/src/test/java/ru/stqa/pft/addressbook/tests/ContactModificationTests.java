package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().openHomePage();
        if (app.contact().list().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone").withEmail("email").withGroup("test11"));
            app.contact().openHomePage();
        }
    }

    @Test
    public void testContactModification() {
        List<ContactData> contactsBefore = app.contact().list();
        int index = contactsBefore.size() - 1;
        ContactData contact = new ContactData()
                .withId(contactsBefore.get(index).getId()).withFirstname("firstname2").withLastname("lastname2").withAddress("address2").withHomePhone("phone2").withEmail("email1");
        app.contact().modify(index, contact);
        app.contact().openHomePage();
        List<ContactData> contactsAfter = app.contact().list();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size(), "Contacts count must be the same after modification");

        contactsBefore.remove(index);
        contactsBefore.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
