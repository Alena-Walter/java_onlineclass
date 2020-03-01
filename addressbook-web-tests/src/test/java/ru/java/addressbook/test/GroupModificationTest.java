package ru.java.addressbook.test;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroups();
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Elena1", "Walter", null));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returntoGroupPage();
    }
}
