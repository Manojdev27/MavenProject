package dockertests;

import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DockerTest {

   @Test
   public void dockerTests() throws MalformedURLException, InterruptedException {
        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
       DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
       desiredCapabilities.setBrowserName("chrome");
       WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities);
//       WebDriver driver = new RemoteWebDriver(new URL("http://54.253.164.86:4444"),desiredCapabilities);// Aws Docker Url
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
       driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
       driver.findElement(StringConstants.password).sendKeys("Godhand27");
       driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println(driver.getTitle());
        Thread.sleep(7000);
        driver.quit();
    }
}
