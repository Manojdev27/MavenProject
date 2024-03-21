import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement fileUpload = driver.findElement(By.id("uploadfile_0"));
        fileUpload.sendKeys(System.getProperty("user.dir")+"/testUpload.txt");
        Thread.sleep(5000);

        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("submitbutton")).click();
        Thread.sleep(2000);
        driver.close();

    }
}
