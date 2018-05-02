package ru.stqa.pft.mantis.tests;


import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @Test
    public void testResetPassword() throws IOException, MessagingException, ServiceException {
        skipIfNotFixed(0000002);
        List<UserData> users = app.db().users();
        UserData user = null;
        for (UserData u : users) {
            if (!u.getUsername().equals("administrator")) {
                user = u;
                break;
            }
        }

        String password = "password";
        String newPassword = "newpassword";
        app.james().deleteUser(user.getUsername());
        app.james().createUser(user.getUsername(), password);
        app.james().drainEmail(user.getUsername(), password);
        app.navigate().loginAs(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        app.userActions().resetPasswordForUser(user.getUsername());

        List<MailMessage> mailMessages = app.james().waitForMail(user.getUsername(), password, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.userActions().confirmNewPassword(confirmationLink, newPassword);

        assertTrue(app.newSession().login(user.getUsername(), newPassword));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);//return part of text which corresponds to regex
    }
}
