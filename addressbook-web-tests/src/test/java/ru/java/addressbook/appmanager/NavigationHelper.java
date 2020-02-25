package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returntoGroupPage() {

        click(By.linkText("group page"));
    }

    public void gotoGroups() {

        click(By.linkText("groups"));
    }

    public void gotoHomePage() {

        click(By.linkText("home page"));
    }

    public void gotoContactCreation() {

        click(By.linkText("add new"));
    }
}
