package Pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Home extends TestBase {
    public void dropdown() {
        WebElement drop = driver.findElement(By.id("searchDropdownBox1"));
        Select sel = new Select(drop);
        sel.selectByVisibleText("Amazon Devices");

    }

    public void searchbox() throws InterruptedException {


        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        searchbox.sendKeys("iphone");
        Thread.sleep(2000);
        searchbox.clear();
        searchbox.sendKeys("Mackbook");
        Thread.sleep(2000);
        searchbox.clear();
        searchbox.sendKeys("Samsung");
    }

    public void clickonButton() {

        WebElement searchclick = driver.findElement(By.xpath("//input[@class='nav-input' and@ value='Go']"));
        searchclick.click();


    }
    public void doall() throws InterruptedException {
        WebElement drop = driver.findElement(By.id("searchDropdownBox"));
        WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchclick = driver.findElement(By.xpath("//input[@class='nav-input' and@ value='Go']"));

        Select sel = new Select(drop);
        sel.selectByVisibleText("Amazon Devices");

        searchbox.sendKeys("iphone");
        searchclick.click();
        Thread.sleep(2000);

    }



}
