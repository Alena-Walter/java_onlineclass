package ru.java.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.java.addressbook.model.GroupData;

public class GroupHelper {
    private WebDriver wd;
    public GroupHelper(WebDriver wd) {
        this.wd = wd;
    }


    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void initGroupCreation(String s) {
        click(By.name(s));
    }

    public void deleteSelectedGroups() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }

    public void selectGroups() {
        click(By.name("selected[]"));
    }
}
