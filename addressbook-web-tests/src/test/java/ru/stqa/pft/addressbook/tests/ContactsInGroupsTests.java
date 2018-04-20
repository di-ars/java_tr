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
        if (app.db().contacts().size() == 0) {
            app.goTo().contactCreationPage();
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone")
                    .withMobilePhone("12345").withWorkPhone("12345").withEmail("email"));
        }
    }

    @Test
    public void testContactAddedToGroup() {
        GroupData groupToAdd = new GroupData().withName("test_group").withHeader("header").withFooter("footer");
        app.goTo().groupPage();
        app.group().create(groupToAdd);
        groupToAdd.withId(app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt());//set proper (max) id to created group

        app.contact().openHomePage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groupsBefore = contact.getGroups();
        app.contact().addToGroup(contact, groupToAdd);
        contact = app.db().contactById(contact.getId());
        Groups groupsAfter = contact.getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupToAdd)));
    }

    @Test
    public void testContactDeletedFromGroup() {
        Groups groups = app.db().groups();
        if (groups.size() == 0) {
            GroupData group = new GroupData().withName("test_group");
            app.goTo().groupPage();
            app.group().create(group);
        }

        GroupData groupToDeleteFrom;
        app.contact().openHomePage();
        ContactData contact = app.db().contacts().iterator().next();
        Groups groupsBefore = contact.getGroups();
        if (groupsBefore.size() == 0) {
            groupToDeleteFrom = app.db().groups().iterator().next();
            app.contact().addToGroup(contact, groupToDeleteFrom);
            contact = app.db().contactById(contact.getId());
            groupsBefore = contact.getGroups();
        } else {
            groupToDeleteFrom = groupsBefore.iterator().next();
        }
        app.contact().deleteFromGroup(contact, groupToDeleteFrom);
        contact = app.db().contactById(contact.getId());
        Groups groupsAfter = contact.getGroups();
        assertThat(groupsAfter, equalTo(groupsBefore.without(groupToDeleteFrom)));
    }
}
