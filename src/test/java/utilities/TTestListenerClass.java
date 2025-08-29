package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TTestListenerClass implements ITestListener {
	
	ExtentReports report= ExtentRepUtil.getReport();
	ThreadLocal<ExtentTest> test= new ThreadLocal<>();	
	
	public void onTestStart(ITestResult result) {
		ExtentTest t= report.createTest(result.getName());
		test.set(t);
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test.get().log(Status.PASS, "Test Passsed"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, "Test Failed"+result.getThrowable());
		System.out.println("Test Failed");
	}
	
	public void onFinish(ITestContext context) {
		try {
			ExtentRepUtil.openReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
		report.flush();
	}
}
