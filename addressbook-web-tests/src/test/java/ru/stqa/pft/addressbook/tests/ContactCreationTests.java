package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        ContactData contactData = new ContactData("test", "", "test", "", null, "", "", "test", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, "test11", "", "", "");
        app.getNavigationHelper().gotoContactCreationPage();
        app.getContactHelper().createContact(contactData);
        app.getNavigationHelper().gotoHomePage();
    }
}
