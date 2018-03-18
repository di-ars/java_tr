package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoContactCreationPage();
        ContactData contactData = new ContactData("test", "", "test", "", null, "", "", "test", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, "test11", "", "", "");
        app.getContactHelper().fillContactForm(contactData, true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().gotoHomePage();
    }
}
