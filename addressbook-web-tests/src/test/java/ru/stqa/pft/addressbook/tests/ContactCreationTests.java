package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.gotoContactCreationPage();
        app.fillContactForm(new ContactData("test", "", "test", "", null, "", "", "test", "12345", "", "", "", "contact@contact.com", "", "", "", null, null, "", "", "", ""));
        app.submitContactCreation();
        app.returnToHomePage();
    }
}
