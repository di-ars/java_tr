package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreationPage();
            app.getContactHelper().createContact(new ContactData("firstname", "lastname", "address", "phone", "email", "test11"));
        }
        List<ContactData> contactsBefore = app.getContactHelper().getContactsList();
        app.getContactHelper().selectContact(contactsBefore.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactsList();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() - 1, "After contact deleted count of contacts must be decreased at 1");

        contactsBefore.remove(contactsBefore.size() - 1);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
