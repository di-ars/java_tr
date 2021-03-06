package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegistrationTests extends TestBase {

    //@BeforeMethod //must be commented for james
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException, com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException, ServiceException {
        skipIfNotFixed(0000002);
        long now = System.currentTimeMillis();
        String password = "password";
        String user = String.format("user%s", now);
        String email = String.format("user%s@localhost", now);
        app.james().createUser(user, password); //must be uncommented for james
        app.registration().start(user, email);
        //List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000); //must be commented for james
        List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000); //must be uncommented for james
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);//return part of text which corresponds to regex
    }

    //@AfterMethod(alwaysRun = true) //must be commented for james
    public void stopMailServer() {
        app.mail().stop();
    }
}
