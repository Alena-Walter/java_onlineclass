package ru.java.addressbook.test;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;
import ru.java.addressbook.model.GroupData;

public class ContactDeletionTest extends TestBase{


  @Test
  public void testContactDeletion() throws Exception {


    //check if no one contact exists
    if (! app.getContactHelper().isThereAContact()) {
      // then create one
      app.getNavigationHelper().gotoContactCreation();
      app.getContactHelper().createContact(new GroupContact("Elena1", "Walter", "Charlotte", "9262066973", null));

    }

    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().acceptNextAlert();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closeAlert();

  }


}
