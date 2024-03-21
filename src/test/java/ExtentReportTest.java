import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTest {
    public static void main(String[] args) {
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/index.html");
        extent.attachReporter(spark);
        ExtentTest loginTest = extent.createTest("Login Test");
        loginTest.pass("test case login is passed");
        loginTest.fail("test case login failed");

        ExtentTest homePageTest = extent.createTest("Home Page Test");
        homePageTest.assignAuthor("Harry");
        homePageTest.assignCategory("smoke").assignCategory("regression").assignCategory("home page test");
        homePageTest.pass("username is entered");
        homePageTest.pass("password is entered");
        homePageTest.pass("login is successful");

        ExtentTest newTest = extent.createTest("New Test");
        newTest.assignAuthor("Hermione").assignAuthor("Ron");
        newTest.assignCategory("regression").assignCategory("new test");
        newTest.pass("username is entered");
        newTest.pass("password is entered");
        newTest.pass("login is successful");

        extent.flush();// producing the report --> writes all the lines in to the html

    }
}
