package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    public WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void returntoGroupPage() {
      wd.findElement(By.linkText("group page")).click();
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
}
