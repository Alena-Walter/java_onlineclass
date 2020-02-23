package ru.java.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ApplicationManager {
    public WebDriver wd;
    private ContactHelper contactHelper;
    public GroupHelper groupHelper;
    public StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        wd = new FirefoxDriver();

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
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

    public void gotoHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void gotoContactCreation() {
      wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
