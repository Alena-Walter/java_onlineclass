package ru.java.addressbook.test;

import org.testng.annotations.Test;
import ru.java.addressbook.model.GroupContact;

public class ContactModificationTest extends TestBase {

    @Test
    public void testContactModification () {

        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new GroupContact("Elena", "Walter", "Charlotte", "9262066973", "dorial@yandex.ru"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }

}
