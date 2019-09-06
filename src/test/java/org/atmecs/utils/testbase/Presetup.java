package org.atmecs.utils.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.flight_ticket.App;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Presetup {
	protected WebDriver driver;
	App app = new App();
	File inputfile = new File("./src/test/resources/testdata/login.xlsx");

	@BeforeTest
	@Parameters({"portnum"})
	public void setup(String portnumber) throws IOException {
		Properties prop = property(Filepath.webdriver_file);
		if(portnumber.equalsIgnoreCase(""))
		{
			 String nodeUrl="http://55.55.53.104:14479/wd/hub";
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN10);
			driver=new RemoteWebDriver(new URL(nodeUrl),cap);	
		}
		else {
		switch (prop.getProperty("webdrivername")) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			FirefoxOptions op=new FirefoxOptions();
			op.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
			driver = new FirefoxDriver(op);
			break;
		case "Ie":
			System.setProperty("webdriver.ie.driver", "./libs/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "Edge":
			System.setProperty("webdriver.edge.driver", "./libs/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		}
	}


	public Properties property(String path) throws IOException {
		File file = new File(path);
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		return prop;
	}

}
