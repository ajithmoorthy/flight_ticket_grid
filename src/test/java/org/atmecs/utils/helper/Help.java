package org.atmecs.utils.helper;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Help {
	public WebDriver click(String locators, WebDriver webdriver) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.click();
		return webdriver;
	}

	public WebDriver sendkeysString(String locators, WebDriver webdriver, String variable) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.sendKeys(variable);
		return webdriver;
	}

	public WebDriver sendkeysInt(String locators, WebDriver webdriver, String variable) {
		WebElement click_operation = webdriver.findElement(By.xpath(locators));
		click_operation.sendKeys(variable);
		return webdriver;
	}

	public WebDriver dropdown(String locators, WebDriver webdriver, int index) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		WebElement dropdown = webdriver.findElement(By.xpath(locators));
		dropdown.click();
		Select select = new Select(dropdown);
		select.deselectByIndex(index);
		return webdriver;
	}

	public boolean returnbool(String locators, WebDriver webdriver) {
		webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement bool = webdriver.findElement(By.xpath(locators));
		boolean boo = bool.isSelected();
		return boo;
	}

	public WebDriver sendkeysdropdown(String locators, WebDriver webdriver, String variable)
			throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(locators)));
		WebElement dropdown = webdriver.findElement(By.xpath(locators));
		dropdown.sendKeys(variable);
		WebElement options = webdriver.findElement(By.xpath(locators));
		options.sendKeys(Keys.ENTER);
		return webdriver;

	}

	public WebDriver clickcss(String locators, WebDriver webdriver) {
		WebDriverWait wait2 = new WebDriverWait(webdriver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locators)));
		WebElement click_operation = webdriver.findElement(By.cssSelector(locators));
		click_operation.click();
		return webdriver;
	}
	public WebDriver divdropdown(String locators, WebDriver webdriver,String locator,int index) {
	webdriver.findElement(By.xpath(locators)).click();
	ArrayList<WebElement> lst = (ArrayList<WebElement>) webdriver.findElements(By.xpath(locator));
	lst.get(3).click();
	return webdriver;
	}

}
