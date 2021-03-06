package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContactsFromXML() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
            for (ContactData contact : contacts) {
                contact.groups = new HashSet<GroupData>();
            }
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJSON() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            StringBuilder json = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                json.append(line);
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json.toString(), new TypeToken<List<ContactData>>() {
            }.getType()); //List<ContactData>.class
            for (ContactData contact : contacts) {
                contact.groups = new HashSet<GroupData>();
            }
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        if (groups.size() == 0) {
            GroupData group = new GroupData().withName("new");
            app.goTo().groupPage();
            app.group().create(group);
        }
    }

    @Test(dataProvider = "validContactsFromJSON")
    public void testContactCreation(ContactData contact) {
        /*File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData()
                .withFirstname("test").withLastname("test").withAddress("test").withHomePhone("12345")
                .withMobilePhone("12345").withWorkPhone("12345").withEmail("contact@contact.com").withGroup("test11")
                .withPhoto(photo);*/
        contact.inGroup(app.db().groups().iterator().next());
        Contacts contactsBefore = app.db().contacts();
        app.goTo().contactCreationPage();
        app.contact().createContact(contact);
        assertThat(app.contact().count(), equalTo(contactsBefore.size() + 1));
        Contacts contactsAfter = app.db().contacts();
        assertThat(contactsAfter, equalTo(
                contactsBefore.withAdded(contact.withId(contactsAfter.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}