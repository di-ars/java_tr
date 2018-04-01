package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contact = new ContactData().withFirstname("test").withLastname("test").withAddress("test").withHomePhone("12345").withEmail("contact@contact.com").withGroup("test11");
        List<ContactData> contactsBefore = app.contact().list();
        app.goTo().contactCreationPage();
        app.contact().createContact(contact);
        app.contact().openHomePage();
        List<ContactData> contactsAfter = app.contact().list();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() + 1, "Contacts count must be enlarged at 1 after new contact created");

        contactsBefore.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
