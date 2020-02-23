package ru.java.addressbook.test;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new GroupContact("Elena", "Walter", "Charlotte", "9262066973", "dorial@yandex.ru"));
    app.getContactHelper().submitContactForm();
    app.getNavigationHelper().gotoHomePage();
  }


}
