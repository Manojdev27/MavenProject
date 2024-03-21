package testng;
import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenersTest {

    @Test
    public void listenersTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        driver.findElement(StringConstants.password).sendKeys("Godhand27");
//        Assert.assertEquals(1,2);
        Thread.sleep(3000);
        driver.quit();
}

}
