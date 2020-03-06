package ru.java.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().gotoGroups();

        //check if no one group exists
        if (! app.getGroupHelper().isThereAGroup()) {
            // then create one
            app.getGroupHelper().createGroup(new GroupData("Walter1", null, null));

        }
        
        app.getNavigationHelper().gotoGroups();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroups();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("Elena1", "Walter", null));
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returntoGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before);
    }
}
