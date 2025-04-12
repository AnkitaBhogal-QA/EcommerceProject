package com.Demowebshop.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demowebshop.GenericLib.BaseTest;
import com.Demowebshop.ObjectRepository.SearchPage;
import com.aventstack.extentreports.Status;

public class SearchItemTest extends BaseTest{
	
	@Test
	public void toSearchItem() throws IOException
	{
		String itemName = f.getDataFromProperty(PROPERTYPATH, "item");
		
		test.log(Status.INFO, "Step 1: Enter item name and click search");
		SearchPage sp = new SearchPage(driver);
		sp.searchItem(itemName);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/search?q=computer");
		test.log(Status.INFO, "Step 2:" + itemName+ " Search Pass");
		
	}

}
