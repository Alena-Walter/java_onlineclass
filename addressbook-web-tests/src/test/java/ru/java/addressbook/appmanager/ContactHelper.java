package ru.java.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.java.addressbook.model.GroupContact;
import ru.java.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ContactHelper extends HelperBase{

    public boolean acceptNextAlert = true;

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void acceptNextAlert() {
      acceptNextAlert = true;
    }

    public void closeAlert() {
      assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
    }

    public void deleteContact() {

        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact( int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));

    }

    public void submitContactForm() {

        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(GroupContact groupContact) {
        type(By.name("firstname"), groupContact.getFirstname());
        type(By.name("lastname"), groupContact.getLastname());
        type(By.name("address"), groupContact.getAddress());
        type(By.name("mobile"), groupContact.getMobile());
        type(By.name("email"), groupContact.getEmail());

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

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));

    }

    public void createContact(GroupContact contact) {
        fillContactForm(contact);
        submitContactForm();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupContact> getContactList() {
        List<GroupContact> contacts = new ArrayList<GroupContact>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {

            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");

            GroupContact contact = new GroupContact(id, firstname, lastname, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
