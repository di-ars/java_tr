package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.contact().openHomePage();
        if (app.contact().all().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone")
                    .withMobilePhone("12345").withWorkPhone("12345").withEmail("email").withGroup("test11"));
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts contactsBefore = app.contact().all();
        ContactData deletedContact = contactsBefore.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(contactsBefore.size() - 1));
        Contacts contactsAfter = app.contact().all();
        assertThat(contactsAfter, equalTo(contactsBefore.without(deletedContact)));
    }
}
