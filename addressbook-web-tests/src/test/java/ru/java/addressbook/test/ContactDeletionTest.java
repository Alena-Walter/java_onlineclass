package ru.java.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {

    app.getContactHelper().selectContact();
    app.getContactHelper().acceptNextAlert();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();

  }


}
