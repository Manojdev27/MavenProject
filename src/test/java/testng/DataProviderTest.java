package testng;

import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderTest {

    @DataProvider(parallel = true)
    public static Object[][] getData() {
        return new Object[][]{
                {"manojkumardev27@gmail.com","Godhand27", "Manoj"}, {"Admin", "Admin123", "admin"},{"Facebook", "Facebook123", "mark"}
        };
    }

    // no. of rows - no. of times it is going to run your test
    // no. of columns - no. of parameters to your test method

    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String password, String firstName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("---headless");

//        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");

//        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id(username)));

        click(driver,StringConstants.email);
        click(driver,StringConstants.password);

//        driver.findElement(StringConstants.email).sendKeys(username);
//        driver.findElement(StringConstants.password).sendKeys(password);
//        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println(firstName);
//        Thread.sleep(3000);
        driver.quit();

    }

    public void click(WebDriver driver, By by){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}
