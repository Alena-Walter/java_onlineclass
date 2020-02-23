package ru.java.addressbook.test;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {

    app.selectContact();
    app.acceptNextAlert();
    app.deleteContact();
    app.closeAlert();

  }


}
