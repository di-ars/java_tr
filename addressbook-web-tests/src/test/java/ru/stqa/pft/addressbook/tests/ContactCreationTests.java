package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contact = new ContactData().withFirstname("test").withLastname("test").withAddress("test").withHomePhone("12345").withEmail("contact@contact.com").withGroup("test11");
        Contacts contactsBefore = app.contact().all();
        app.goTo().contactCreationPage();
        app.contact().createContact(contact);
        Contacts contactsAfter = app.contact().all();
        assertThat(contactsAfter.size(), equalTo(contactsBefore.size() + 1));

        assertThat(contactsAfter, equalTo(
                contactsBefore.withAdded(contact.withId(contactsAfter.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
