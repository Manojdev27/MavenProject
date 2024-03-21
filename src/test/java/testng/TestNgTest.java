package testng;

import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgTest {
    static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyFacebookInvalidPasswordError(){


        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        driver.findElement(StringConstants.password).sendKeys("Godhand");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//        driver.findElement(By.xpath("//a[text()='Log in with password']")).click();
        driver.findElement(By.id("pass")).sendKeys("Godhand");
        driver.findElement(By.id("loginbutton")).click();
        String errMessage = driver.findElement(By.className("_9ay7")).getText();
        String expectedError = "The password that you've entered is incorrect. Forgotten password?";
        System.out.println(errMessage);
        Assert.assertEquals(errMessage,expectedError);

    }
    @Test(priority = 2)
    public void verifyFacebookPageTitle(){

        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        driver.findElement(StringConstants.password).sendKeys("Godhand27");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

//        if(actualTitle.equals(expectedTitle)){
//            System.out.println("test is passed");
//        }else{
//            System.out.println("test is failed");
//        }
      String actualTitle = driver.getTitle();
      String expectedTitle = "(3) Facebook";
      Assert.assertEquals(actualTitle,expectedTitle);

    }
}
