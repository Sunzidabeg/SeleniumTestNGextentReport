package PagesTest;

import Pages.Home;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomeTest extends TestBase {
Home h=new Home();
    @Test
    public void dropdownTest() {
       h.dropdown();
    }

    @Test
    public void searchboxTest() throws InterruptedException {
h.searchbox();


    }

    @Test
    public void clickonButtonTest() {

        h.clickonButton();


    }
    @Test(enabled = false)
    public void doallTest() throws InterruptedException {
       h.doall();
    }




}
