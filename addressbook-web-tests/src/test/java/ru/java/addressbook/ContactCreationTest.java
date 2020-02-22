package ru.java.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    gotoContactCreation();
    fillContactForm(new GroupContact("Elena", "Walter", "Charlotte", "9262066973", "dorial@yandex.ru"));
    submitContactForm();
    gotoHomePage();
  }


}
