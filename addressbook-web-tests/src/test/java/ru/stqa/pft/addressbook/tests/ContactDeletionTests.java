package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

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
    public void testContactDeletion() {
        List<ContactData> contactsBefore = app.contact().list();
        int index = contactsBefore.size() - 1;
        app.contact().delete(index);
        List<ContactData> contactsAfter = app.contact().list();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() - 1, "After contact deleted count of contacts must be decreased at 1");

        contactsBefore.remove(index);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
