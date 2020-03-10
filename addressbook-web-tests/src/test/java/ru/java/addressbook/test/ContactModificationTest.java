package ru.java.addressbook.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;

import java.util.HashSet;
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
        app.getContactHelper().selectContact(0);
        //app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification();


        //GroupContact contact = new GroupContact (before.get(before.size() - 1).getId(),"Elena", "Walter6", null, null, null);
        GroupContact contact = new GroupContact (before.get(0).getId(),"Elena", "Walter6", null, null, null);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();

        List<GroupContact> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());
        //System.out.println(after.size());

        //before.remove(before.size() - 1);
        before.remove(0);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
