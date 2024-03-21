import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

//      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manoj Targaryen\\Downloads\\New folder\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(StringConstants.url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id(StringConstants.hamburgerMenu)).click();
        Thread.sleep(3000);
        driver.findElement(StringConstants.mobilesAndComputers).click();
        Thread.sleep(10000);

        WebElement element = driver.findElement(StringConstants.allMobilePhones);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
        Thread.sleep(3000);

        WebElement mobileAndAccessories = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[6]/div/a[2]/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mobileAndAccessories).build().perform();
        Thread.sleep(3000);

        WebElement mobile = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[3]/div[14]/div[2]/div/div[2]/ul/li[5]/a"));
        actions.click(mobile).build().perform();
        Thread.sleep(3000);
        driver.close();
    }
}