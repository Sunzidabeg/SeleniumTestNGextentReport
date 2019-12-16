package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {
    public static WebDriver driver = null;

    private static ExtentReports extent;
    private static ThreadLocal parentTest = new ThreadLocal();
    private static ThreadLocal test = new ThreadLocal();

    @BeforeSuite
    public void beforeSuite() {
        extent = ExtentManager.createInstance("extentReport.html");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        extent.attachReporter(htmlReporter);
    }
    @AfterSuite
    public synchronized void afterSuite() {

        extent.flush();
    }

    @BeforeClass
    public synchronized void beforeClass() {
        ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
    }

    @BeforeMethod
    public  void beforeMethod() throws IOException {
        setup();
        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

        // log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test.info("This step shows usage of info(details)");

        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");

    }



    public void setup()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sunzida\\IdeaProjects\\ProjectObjModelDec14\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown() {
        driver.close();

    }


    }












