package ru.java.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {

    selectContact();
    acceptNextAlert();
    deleteContact();
    closeAlert();

  }


}
