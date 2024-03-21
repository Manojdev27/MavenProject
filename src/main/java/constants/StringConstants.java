package constants;

import org.openqa.selenium.By;

public class StringConstants {

    public static String url = "https://www.amazon.in/";

    public static String hamburgerMenu =  "nav-hamburger-menu";

   public static By mobilesAndComputers = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a");

    public static By allMobilePhones = By.xpath("/html/body/div[3]/div[2]/div/ul[8]/li[3]/a");

    public static By email = By.xpath("//*[@id=\"email\"]");
    public static By password = By.name("pass");
}
