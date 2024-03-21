import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InputTest {
    static WebDriver driver;
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        // passing the arguments using modifying in run configurations
//        driver.findElement(StringConstants.email).sendKeys(args[0]);
        driver.findElement(StringConstants.email).sendKeys("manojkumardev27@gmail.com");
        driver.findElement(StringConstants.password).sendKeys("Godhand27");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }



        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - log in or sign Up";
        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("test is passed");
        }else{
            System.out.println("test is failed");
        }



    }
}
