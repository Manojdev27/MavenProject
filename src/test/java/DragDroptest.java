import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDroptest {

    static WebDriver driver;
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        // for drag and drop
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
//      actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        actions.dragAndDrop(draggable,droppable).build().perform();

        driver.switchTo().defaultContent();
        WebElement element = driver.findElement(By.xpath("//a[text()='Forum']"));
        actions.moveToElement(element).click().build().perform();

//        driver.findElement(By.xpath("//a[text()='Resizable']")).click();

        driver.close();
    }
}
