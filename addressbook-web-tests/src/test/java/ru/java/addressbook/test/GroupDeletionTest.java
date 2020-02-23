package ru.java.addressbook.test;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    app.gotoGroups();
    app.selectGroups();
    app.deleteSelectedGroups();
    app.returntoGroupPage();
  }

}
