package ru.java.addressbook.test;


import org.testng.Assert;
import org.testng.annotations.*;
import ru.java.addressbook.model.GroupData;

import java.util.List;


public class GroupCreationTest extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroups();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("Walter1", null, null));
    app.getNavigationHelper().returntoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);
    app.getSessionHelper().logout();
  }


}
