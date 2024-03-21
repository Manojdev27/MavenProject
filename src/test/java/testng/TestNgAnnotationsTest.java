package testng;

import org.testng.annotations.*;

public class TestNgAnnotationsTest {

    @BeforeSuite
    public void beforeSuite(){

        System.out.println("in before suite");
    }

    @BeforeTest
    public void beforeTest(){

        System.out.println("in before test");
    }


    @BeforeClass
    public void beforeClass(){

        System.out.println("in before Class");
    }


    @BeforeMethod
    public void beforeMethod(){

        System.out.println("in before Method");
    }

    @Test
    public void test1(){

        System.out.println("Test1");
    }

    @Test
    public void test2(){

        System.out.println("Test2");
    }

    @Test(invocationCount = 10, threadPoolSize = 5)
    public void test3(){

        System.out.println("Test3");
    }

    @Test(timeOut = 3L)
    public void test4() throws InterruptedException {
//        Thread.sleep(5000);
        System.out.println("Test4");
    }

    @Test(dependsOnMethods = "important")
    public void test5(){
        System.out.println("Test5");
    }

    @Test(dependsOnGroups = {"login"})
    public void test6() {
        System.out.println("Test6");
    }

    @Test()
    public void important(){
        System.out.println("important");
    }

    @Test(groups = {"login", "regression"})
    public void importMethod(){
        System.out.println("importMethod");
    }
    @Test(groups = {"login","smoke"})
    public void importance(){
        System.out.println("importance");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("in after test");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("in after method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("in after suite");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("in after Class");
    }
}
