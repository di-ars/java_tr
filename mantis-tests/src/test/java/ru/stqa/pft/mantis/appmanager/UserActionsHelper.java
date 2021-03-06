package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class UserActionsHelper extends HelperBase {

    public UserActionsHelper(ApplicationManager app) {
        super(app);
    }

    public void resetPasswordForUser(String username) {
        click(By.cssSelector("a[href='/mantisbt-2.13.1/manage_overview_page.php']"));
        waitLocator(By.linkText("Manage Users"));
        click(By.linkText("Manage Users"));
        waitLocator(By.name("username"));
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Manage User']"));
        waitLocator(By.cssSelector("input[value='Reset Password']"));
        click(By.cssSelector("input[value='Reset Password']"));
    }

    public void confirmNewPassword(String link, String password) {
        wd.get(link);
        waitLocator(By.name("password"));
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("button[type='submit']"));
    }

}
