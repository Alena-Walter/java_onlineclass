package ru.java.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    gotoGroups();
    selectGroups();
    deleteSelectedGroups();
    returntoGroupPage();
  }

}
