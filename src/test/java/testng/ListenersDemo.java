package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersDemo implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(STR."\{result.getName()} is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(STR."\{result.getName()} is started");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(STR."\{result.getName()} is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(STR."\{result.getName()} is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am a before suite");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am a after suite");
    }
}
