package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contact = new ContactData().withFirstname("test").withLastname("test").withAddress("test").withHomePhone("12345").withEmail("contact@contact.com").withGroup("test11");
        Set<ContactData> contactsBefore = app.contact().all();
        app.goTo().contactCreationPage();
        app.contact().createContact(contact);
        Set<ContactData> contactsAfter = app.contact().all();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() + 1, "Contacts count must be enlarged at 1 after new contact created");

        contact.withId(contactsAfter.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        contactsBefore.add(contact);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
