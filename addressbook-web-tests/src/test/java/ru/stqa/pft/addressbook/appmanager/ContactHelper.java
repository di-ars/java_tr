package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void createContact(ContactData contactData) {
        fillContactForm(contactData, true);
        submitContactCreation();
        contactCache = null;
        openHomePage();
    }

    public void modify(ContactData contactData) {
        initContactModificationById(contactData.getId());
        fillContactForm(contactData, false);
        submitContactModification();
        contactCache = null;
        openHomePage();
        if (contactData.getGroups().size() != 0) {
            addToGroup(contactData,contactData.getGroups().iterator().next());
        }
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContacts();
        contactCache = null;
        openHomePage();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean isCreation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        attach(By.name("photo"), contactData.getPhoto());


        if (isCreation) {
            if (contactData.getGroups().size() > 0) {
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        openHomePage();
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            contactCache.add(new ContactData()
                    .withId(id).withFirstname(firstName).withLastname(lastName).withAllPhones(allPhones).withAllEmails(allEmails));
        }
        return contactCache;
    }

    public void initContactModificationById(int id) {
//        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
//        WebElement row = checkbox.findElement(By.xpath("./../.."));
//        List<WebElement> cells = row.findElements(By.tagName("td"));
//        cells.get(7).findElement(By.tagName("a")).click();

//        wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();

//        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

//        wd.findElement(By.xpath("//input[@id='" + id + "']/../../td/a/img[@title='Edit']/..")).click();
        wd.findElement(By.xpath(String.format("//input[@id='%s']", id))).findElement(By.xpath("./../../td/a/img[@title='Edit']/..")).click();
    }

    public void openHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId()).withFirstname(firstName).withLastname(lastName)
                .withHomePhone(homePhone).withMobilePhone(mobilePhone).withWorkPhone(workPhone)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public void addToGroup(ContactData contact, GroupData group) {
        selectContactById(contact.getId());
        new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
        click(By.name("add"));
        openHomePage();
    }

    public void deleteFromGroup(ContactData contact, GroupData group) {
        new Select(wd.findElement(By.name("group"))).selectByValue(Integer.toString(group.getId()));
        selectContactById(contact.getId());
        click(By.name("remove"));
        openHomePage();
    }
}
