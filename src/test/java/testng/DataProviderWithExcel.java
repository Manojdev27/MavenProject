package testng;

import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {

    @DataProvider(parallel = true)
    public static Object[][] getData() {
       Object[][] a = new Object[2][2];
       return a;
    }

    // no. of rows - no. of times it is going to run your test
    // no. of columns - no. of parameters to your test method

    @Test(dataProvider = "getData")
    public void dataProviderTest(String username, String password, String firstName) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(StringConstants.email).sendKeys(username);
        driver.findElement(StringConstants.password).sendKeys(password);
        System.out.println(firstName);
        Thread.sleep(3000);
        driver.quit();

    }
}
