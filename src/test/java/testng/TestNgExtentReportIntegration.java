package testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestNgExtentReportIntegration {
    ExtentReports extent;
    ExtentTest loginTest;

    @BeforeSuite
    public void beforeSuite(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/index.html");
        extent.attachReporter(spark);
    }

        @BeforeMethod
        public void setup(Method method){
            loginTest = extent.createTest(method.getName());
        }
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        loginTest.pass("url is loaded");
        Thread.sleep(3000);
        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        Thread.sleep(3000);
        loginTest.pass("email id is entered");
        driver.findElement(StringConstants.password).sendKeys("Godhand27");
        Thread.sleep(3000);
        loginTest.pass("password is entered");
        driver.quit();
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        loginTest.pass("url is loaded");
        Thread.sleep(3000);
        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        Thread.sleep(3000);
        loginTest.pass("email id is entered");
        driver.findElement(StringConstants.password).sendKeys("Godhand");
        Thread.sleep(3000);
        loginTest.pass("password is entered");
        driver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
    }
}
