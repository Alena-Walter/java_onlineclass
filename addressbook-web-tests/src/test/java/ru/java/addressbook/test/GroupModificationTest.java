package ru.java.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

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
        List<GroupData> before = app.getGroupHelper().getGroupList();
        //int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().selectGroups(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData (before.get(before.size() - 1).getId(),"Elena_for test", "I did", null);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().returntoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
