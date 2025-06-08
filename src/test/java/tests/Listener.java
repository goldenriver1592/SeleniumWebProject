package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am in onTestStart method " + result.getMethod().getMethodName() + " start");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("I am in onTestFailure method " + result.getMethod().getMethodName() + " failed");
    }


}
