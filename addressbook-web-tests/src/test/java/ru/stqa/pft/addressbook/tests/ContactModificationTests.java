package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("new", "", "new", "", null, "", "", "new", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, "", "", "", ""));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
