package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactsInGroupsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
    /*    Groups groups = app.db().groups();
        if (groups.size() == 0) {
            GroupData group = new GroupData().withName("test_group");
            app.goTo().groupPage();
            app.group().create(group);
        }*/
        if (app.db().contacts().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone")
                    .withMobilePhone("12345").withWorkPhone("12345").withEmail("email"));
        }
    }

    @Test
    public void testContactAddedToGroup() {
       /* ContactData contact = new ContactData().withFirstname("test").withLastname("test");
        app.goTo().contactCreationPage();
        app.contact().createContact(contact);
        contact.withId(app.db().contacts().stream().mapToInt((c) -> c.getId()).max().getAsInt());//set proper (max) id to created contact
        GroupData groupToAdd = app.db().groups().iterator().next();
        Groups groupsBefore = contact.getGroups(); //expected to be empty
        app.contact().addContactToGroup(contact, groupToAdd);
        contact = app.db().contacts().iterator().next();
        Groups groupsAfter = contact.getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupToAdd)));*/


        GroupData groupToAdd = new GroupData().withName("test_group");
        app.goTo().groupPage();
        app.group().create(groupToAdd);
        groupToAdd.withId(app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt());//set proper (max) id to created group

        app.contact().openHomePage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groupsBefore = contact.getGroups();
        app.contact().addContactToGroup(contact, groupToAdd);
        contact = app.db().contacts().iterator().next();
        Groups groupsAfter = contact.getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupToAdd)));



    }
}
