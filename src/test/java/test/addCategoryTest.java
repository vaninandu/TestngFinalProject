package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CategoryListPage;
import util.BrowserFactory;

public class addCategoryTest {

	WebDriver driver;

	@BeforeMethod

	public void init() {
		// creates connection between browserFactory and AllCheckBoxesChecked drivers
		driver = BrowserFactory.init();
	}

	@Test (priority = 1)
	public void validateUserAbleToAddCategory() {

		CategoryListPage category = PageFactory.initElements(driver, CategoryListPage.class);

		Assert.assertEquals(category.addCategory(), true);
	}

	@Test (priority = 2)
	public void validateUserNotAbleToAddDuplicateCategory() {
		CategoryListPage category = PageFactory.initElements(driver, CategoryListPage.class);

		Assert.assertEquals(category.addDuplicateCategory(), true);

	}
	
	@Test (priority = 3)
	public void validateMonthDropDown() {
		CategoryListPage category = PageFactory.initElements(driver, CategoryListPage.class);
		Assert.assertEquals(category.dropDownList(),12);

		
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.tearDown();
	}

}
