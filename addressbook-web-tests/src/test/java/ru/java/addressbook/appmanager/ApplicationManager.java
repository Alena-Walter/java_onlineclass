package ru.java.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.java.addressbook.model.GroupContact;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ApplicationManager {
    public WebDriver wd;
    public GroupHelper groupHelper;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        wd = new FirefoxDriver();

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        login("admin", "secret");

    }

    public void login(String username, String password) {
        groupHelper.initGroupCreation("user");
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.id("LoginForm")).click();
        groupHelper.initGroupCreation("pass");
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
      wd.findElement(By.linkText("Logout")).click();
    }

    public void returntoGroupPage() {
      wd.findElement(By.linkText("group page")).click();
    }

    public void stop() {
        wd.quit();
    }

    public boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    public boolean isAlertPresent() {
      try {
        wd.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    public void gotoGroups() {
      wd.findElement(By.linkText("groups")).click();
    }

    public void acceptNextAlert() {
      acceptNextAlert = true;
    }

    public void closeAlert() {
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void deleteContact() {
      wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
        //groupHelper.selectGroups();
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitContactForm() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void fillContactForm(GroupContact groupContact) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(groupContact.getFirstname());
      wd.findElement(By.xpath("//div[@id='content']/form/label[3]")).click();
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(groupContact.getLastname());
      wd.findElement(By.name("theform")).click();
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(groupContact.getAddress());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(groupContact.getMobile());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(groupContact.getEmail());
    }

    public void gotoContactCreation() {
      wd.findElement(By.linkText("add new")).click();
    }

    public String closeAlertAndGetItsText() {
      try {
        Alert alert = wd.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert();
      }
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
