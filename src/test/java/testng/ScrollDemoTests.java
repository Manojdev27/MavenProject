package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScrollDemoTests {

    private WebDriver driver;

    @Test
    public void scrollTest() throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        try{
            WebElement element = driver.findElement(By.xpath("//a[text()='About Us 1']"));
        }catch (NoSuchElementException e){
            System.out.println("About us is not important, move on to careers page");
        }

        WebElement elements = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[2]/a"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("window.scrollBy(0,600)");
//        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//          javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);",element);
//          Thread.sleep(2000);
        javascriptExecutor.executeScript("arguments[0].click();",elements);
//        javascriptExecutor.executeScript("arguments[1].click();",element,elements);
        Thread.sleep(2000);

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/target.png");
        FileUtils.copyFile(source,target);

        javascriptExecutor.executeScript("alert('Welcome to Amazon.com');");
        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.quit();
    }
}
