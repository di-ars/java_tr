package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contactData = new ContactData("test", "", "test", "", null, "", "", "test", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, "test11", "", "", "");
        List<ContactData> contactsBefore = app.getContactHelper().getContactsList();
        app.getNavigationHelper().gotoContactCreationPage();
        app.getContactHelper().createContact(contactData);
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> contactsAfter = app.getContactHelper().getContactsList();
        Assert.assertEquals(contactsAfter.size(), contactsBefore.size() + 1, "Contacts count must be enlarged at 1 after new contact created");

        contactsBefore.add(contactData);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);
        Assert.assertEquals(contactsAfter, contactsBefore);
    }
}
