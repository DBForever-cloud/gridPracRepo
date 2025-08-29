package SeleniumGridPrac;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gridPracClass {
	@Parameters("browser")
	@Test
	public void gridTest(String browserName) throws MalformedURLException, URISyntaxException {
		
		String url="http://192.168.0.101:4444";
		DesiredCapabilities caps= new DesiredCapabilities();
		switch(browserName) {
		
		case "chrome":
			caps.setBrowserName("chrome");
			break;
		case "edge":
			caps.setBrowserName("MicrosoftEdge");
			break;
		case "firefox":
			caps.setBrowserName("firefox");
			break;
		default:
			System.out.println("No browser name found");
			
		}
		caps.setPlatform(Platform.WIN11);
		RemoteWebDriver driver= new RemoteWebDriver(new URI(url).toURL(),caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
		driver.get("https://www.amazon.com/");
		driver.close();
	}

}
