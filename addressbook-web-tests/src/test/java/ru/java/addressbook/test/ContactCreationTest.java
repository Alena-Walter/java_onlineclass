package ru.java.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new GroupContact("Elena1", "Walter", "Charlotte", "9262066973", null));
    app.getContactHelper().submitContactForm();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }


}
