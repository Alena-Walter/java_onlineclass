package ru.java.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;
import ru.java.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    List<GroupContact> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new GroupContact("Elena1", "Walter", "Charlotte", "9262066973", null));
    app.getContactHelper().submitContactForm();
    app.getNavigationHelper().gotoHomePage();
    List<GroupContact> after = app.getContactHelper().getContactList();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1);
    System.out.println(after.size());
  }


}
