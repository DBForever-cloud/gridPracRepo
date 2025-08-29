package utilities;

import java.awt.Desktop;
import java.awt.Window;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepUtil {
	
	public static ExtentReports report;
	public static ExtentReports getReport() {
		
		if(report==null) {
			String path=System.getProperty("user.dir")+"\\target\\ExtentReport\\report.html";
			ExtentSparkReporter spark= new ExtentSparkReporter(path);
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("Tester", "Baishali");
			report.setSystemInfo("OS", System.getProperty("user.dir"));
			report.flush();
		}
		
		return report;
	}

	public static void openReport() throws IOException {
		String path=System.getProperty("user.dir")+"\\target\\ExtentReport\\report.html";
		File file= new File(path);
		if(file.exists()==true) {
			Desktop.getDesktop().browse(file.toURI());
		}
	}
}
