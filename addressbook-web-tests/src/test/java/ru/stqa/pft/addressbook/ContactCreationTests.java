package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
    @Test
    public void testContactCreation() {
        gotoContactCreationPage();
        fillContactForm(new ContactData("test", "", "test", "", null, "", "", "test","12345", "", "", "", "contact@contact.com", "", "", "", null, null, "", "", "", ""));
        submitContactCreation();
        returnToHomePage();
    }
}
