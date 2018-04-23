package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        List<UserData> users = app.db().users();
        UserData user = null;
        for (UserData u : users) {
            if (!u.getUsername().equals("administrator")) {
                user = u;
                break;
            }
        }

        String newPassword = "newpassword";
        app.navigate().loginAs(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.userActions().resetPasswordForUser(user.getUsername());

        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.userActions().confirmNewPassword(confirmationLink, newPassword);

        assertTrue(app.newSession().login(user.getUsername(), newPassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);//return part of text which corresponds to regex
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
