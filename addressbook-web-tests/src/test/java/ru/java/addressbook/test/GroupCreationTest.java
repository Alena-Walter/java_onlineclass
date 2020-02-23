package ru.java.addressbook.test;


import org.testng.annotations.*;
import ru.java.addressbook.model.GroupData;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroups();
    app.getGroupHelper().initGroupCreation("new");
    app.getGroupHelper().fillGroupForm(new GroupData("Elena", "Walter", "New"));
    app.getGroupHelper().submitGroupCreation();
    app.getNavigationHelper().returntoGroupPage();
    app.logout();

  }


}
