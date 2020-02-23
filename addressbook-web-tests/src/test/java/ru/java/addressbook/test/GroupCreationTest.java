package ru.java.addressbook.test;


import org.testng.annotations.*;
import ru.java.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroups();
    app.initGroupCreation("new");
    app.fillGroupForm(new GroupData("Elena", "Walter", "New"));
    app.submitGroupCreation();
    app.returntoGroupPage();
    app.logout();

  }


}
