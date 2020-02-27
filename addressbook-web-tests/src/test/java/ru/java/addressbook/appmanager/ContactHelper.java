package ru.java.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.java.addressbook.model.GroupContact;

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

    public void selectContact() {
        click(By.name("selected[]"));

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
}
