package ru.java.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;

import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification () {

        //check if no one contact exists
        if (! app.getContactHelper().isThereAContact()) {
            // then create one
            app.getNavigationHelper().gotoContactCreation();
            app.getContactHelper().createContact(new GroupContact("Elena1", "Walter", "Charlotte", "9262066973", null));

        }
        app.getNavigationHelper().gotoHomePage();
        List<GroupContact> before = app.getContactHelper().getContactList();
        //int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new GroupContact("Elena", "Walter6", null, null, null));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
        List<GroupContact> after = app.getContactHelper().getContactList();
        //int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size());
        System.out.println(after.size());
    }

}
