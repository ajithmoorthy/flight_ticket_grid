package org.atmecs.utils.roundtrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.atmecs.utils.constants.Filepath;
import org.atmecs.utils.flight_ticket.App;
import org.atmecs.utils.helper.Help;
import org.atmecs.utils.testbase.Presetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Edit extends Pricechoosen {
	@DataProvider(name = "edit")
	public String[][] getedit() throws IOException {
		String array[][] = null;
		array = app.returnLocator(Filepath.edit_file);
		return array;

	}

	@Test(priority = 2, dataProvider = "edit")
	public void edit(String firstname, String lastname) throws IOException, InterruptedException {
		Properties prop = property(Filepath.editloc_file);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("loc.radiobtn.mr.xpath"))));
			//driver = help.click(prop.getProperty("loc.radiobtn.mr.xpath"), driver);
			driver = help.sendkeysString(prop.getProperty("loc.txtfield.firstname.xpath"), driver, firstname);
			driver = help.sendkeysString(prop.getProperty("loc.txtfield.lastname.xpath"), driver, lastname);
			driver = help.click(prop.getProperty("loc.button.continueaddon.xpath"), driver);
			driver.findElement(By.xpath(prop.getProperty("loc.drodown.dd.xpath"))).click();
			ArrayList<WebElement> lst = (ArrayList<WebElement>) driver.findElements(By.xpath(prop.getProperty("loc.dateoptions.options.xpath")));
			lst.get(3).click();
			driver=help.divdropdown(prop.getProperty("loc.dropdown.mm.xpath"),driver,prop.getProperty("loc.dateoptions.options.xpath") ,3);
			driver=help.divdropdown(prop.getProperty("loc.dropdown.yyy.xpath"),driver,prop.getProperty("loc.dateoptions.options.xpath") , 3);
			driver = help.click(prop.getProperty("loc.button.seatselect.xpath"), driver);
			driver=help.click(prop.getProperty("loc.btn.finalcontinue.xpath"), driver);
		driver.close();
	}

}
