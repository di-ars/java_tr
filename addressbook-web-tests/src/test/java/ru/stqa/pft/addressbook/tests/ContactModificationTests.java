package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

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
    public void testContactModification() {
        Contacts contactsBefore = app.contact().all();
        ContactData modifiedContact = contactsBefore.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstname2").withLastname("lastname2").withAddress("address2").withHomePhone("phone2")
                .withMobilePhone("222").withWorkPhone("33-33").withEmail("email1");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(contactsBefore.size()));
        Contacts contactsAfter = app.contact().all();
        assertThat(contactsAfter, equalTo(contactsBefore.without(modifiedContact).withAdded(contact)));
    }
}
