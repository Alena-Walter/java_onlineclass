package ru.java.addressbook;


import org.testng.annotations.*;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {

    initGroupCreation("new");
    fillGroupForm(new GroupData("Elena", "Walter", "New"));
    submitGroupCreation();
    returntoGroupPage();
    logout();

  }


}
