package testng;

import constants.StringConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReading {

    @DataProvider(parallel = false)
    public static Object[][] getData() throws IOException {

        File file = new File(System.getProperty("user.dir")+"/testdata.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int lastRowNum = sheet.getLastRowNum();
        System.out.println(STR."lastRowNum = \{lastRowNum}");
//        String value = sheet.getRow(1).getCell(1).getStringCellValue();
//        System.out.println(value);

        int lastCellNum = sheet.getRow(0).getLastCellNum();
        System.out.println(lastCellNum);

//        Object[][] a = new Object[lastRowNum][lastCellNum];
//
//
//        for (int i = 1; i < lastRowNum; i++) {
//
//            for (int j = 0; j < lastCellNum; j++) {
//                a[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
//
//            }
//        }
//        return a;
//    }

        Object[][] a = new Object[lastRowNum][1];
        Map<String,String> map;

        for (int i = 1; i < lastRowNum; i++) {
            map = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
               String key = sheet.getRow(0).getCell(j).getStringCellValue();
               String value = sheet.getRow(i).getCell(j).getStringCellValue();
               map.put(key,value);
            }
            a[i-1][0] = map;
        }
return a;
    }

    // Using method parameters reading excel values
//    @Test(dataProvider = "getData")
//    public void dataProviderTest(String username, String password,String firstName,String lastName) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.facebook.com/");
//        driver.findElement(StringConstants.email).sendKeys(username);
//        driver.findElement(StringConstants.password).sendKeys(password);
//
//        Thread.sleep(3000);
//        driver.quit();
//
//    }

    // using Hashmap reading excel values
    @Test(dataProvider = "getData")
    public void dataProviderTest(Map<String, String> data) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(StringConstants.email).sendKeys(data.get("username"));
        driver.findElement(StringConstants.password).sendKeys(data.get("password"));

        Thread.sleep(3000);
        driver.quit();

    }
}
