package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        if (groups.size() == 0) {
            GroupData group = new GroupData().withName("new");
            app.goTo().groupPage();
            app.group().create(group);
            groups = app.db().groups();
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone")
                    .withMobilePhone("12345").withWorkPhone("12345").withEmail("email").inGroup(groups.iterator().next()));
        }
    }

    @Test
    public void testContactModification() {
        Contacts contactsBefore = app.db().contacts();
        ContactData modifiedContact = contactsBefore.iterator().next();
        File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("firstname2").withLastname("lastname2").withAddress("address2").withHomePhone("phone2")
                .withMobilePhone("222").withWorkPhone("33-33").withEmail("email1").withPhoto(photo).inGroup(app.db().groups().iterator().next());
        app.contact().openHomePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(contactsBefore.size()));
        Contacts contactsAfter = app.db().contacts();
        assertThat(contactsAfter, equalTo(contactsBefore.without(modifiedContact).withAdded(contact)));
    }
}
