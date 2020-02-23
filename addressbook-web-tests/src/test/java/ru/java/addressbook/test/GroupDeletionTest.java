package ru.java.addressbook.test;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    app.getNavigationHelper().gotoGroups();
    app.getGroupHelper().selectGroups();
    app.getGroupHelper().deleteSelectedGroups();
    app.getNavigationHelper().returntoGroupPage();
  }

}
