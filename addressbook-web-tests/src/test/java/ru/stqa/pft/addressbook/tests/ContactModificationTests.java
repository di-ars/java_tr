package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoEditContactPage();
        ContactData contactData = new ContactData("new", "", "new", "", null, "", "", "new", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, null, "", "", "");
        app.getContactHelper().fillContactForm(contactData, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
