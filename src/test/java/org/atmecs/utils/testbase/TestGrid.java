package org.atmecs.utils.testbase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


	/*	
		 * http://55.55.53.104:4444/grid/register http://55.55.53.104:4444/wd/hub
		 * 
		 * 
		 * java -Dwebdriver.gecko.driver=
		 * "C:\\Users\\ajith.periyasamy\\eclipse-workspace1\\ticket\\libs\\geckodriver.exe"
		 * -jar C:\selenium\selenium-server-standalone-3.141.59.jar -role node -hub
		 * http://55.55.53.104:4444/grid/register
		 * 
		 * java -Dwebdriver.chrome.driver=
		 * "C:\\Users\\ajith.periyasamy\\eclipse-workspace1\\ticket\\libs\\chromedriver.exe"
		 * -jar C:\selenium\selenium-server-standalone-3.141.59.jar -role node -hub
		 * http://55.55.53.104:4444/grid/register
		 * 
		 * for creating hub in grid==== java -jar
		 * selenium-server-standalone-3.141.59.jar port-4444 -role hub
		 

		

		public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
		return new RemoteWebDriver(new URL("http://55.55.54.68:2000/wd/hub"), getBrowserCapabilities(browser));
		}

		private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		switch (browserType) {
		case "firefox":
		System.out.println(" Ready  to  Opening OneWay in firefox driver");
		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		return cap;
		case "chrome":
		System.out.println(" Ready to Opening TwoWay in chrome driver");
		DesiredCapabilities capC= new DesiredCapabilities();
		capC.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		return capC;
		default:
		System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
		DesiredCapabilities capfirefox= new DesiredCapabilities();
		capfirefox.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		return capfirefox;

		}

package com.cheapticket.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

public static RemoteWebDriver getDriver(String browser) throws MalformedURLException {
return new RemoteWebDriver(new URL("http://55.55.54.68:2000/wd/hub"), getBrowserCapabilities(browser));
}

private static DesiredCapabilities getBrowserCapabilities(String browserType) {
switch (browserType) {
case "firefox":
System.out.println(" Ready  to  Opening OneWay in firefox driver");
DesiredCapabilities cap= new DesiredCapabilities();
cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
return cap;
case "chrome":
System.out.println(" Ready to Opening TwoWay in chrome driver");
DesiredCapabilities capC= new DesiredCapabilities();
capC.setCapability(CapabilityType.BROWSER_NAME, "chrome");
return capC;
default:
System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
DesiredCapabilities capfirefox= new DesiredCapabilities();
capfirefox.setCapability(CapabilityType.BROWSER_NAME, "firefox");
return capfirefox;

}
}


@BeforeClass
 @Parameters("browser")
public void setUp(String browser) throws IOException
{
FileInputStream input = new FileInputStream(".\\src\\test\\resources\\locators\\locators.properties");

loc.load(input);
driver=BaseClass.getDriver(browser);
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}

}
*/