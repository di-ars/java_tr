package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

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
    public void testContactDeletion() {
        Set<ContactData> contactsBefore = app.contact().all();
        ContactData deletedContact = contactsBefore.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> contactsAfter = app.contact().all();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() - 1, "After contact deleted count of contacts must be decreased at 1");

        contactsBefore.remove(deletedContact);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
