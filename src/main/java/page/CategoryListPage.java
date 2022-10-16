package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CategoryListPage extends BasePage {
	WebDriver driver;

	public CategoryListPage(WebDriver driver) {
		this.driver = driver;
	}

	// WebElements

	@FindBy(how = How.NAME, using = "categorydata")
	WebElement CATEGORY_DATA_ELEMENT;

	@FindBy(how = How.XPATH, using = "//span[@id='extra']//input[@type='submit']")
	WebElement ADD_CATEGORY_ELEMENT;

	@FindBy(how = How.XPATH, using = "//select[@name='due_month']")
	WebElement DROPDOWN_ELEMENT;

	// Corresponding methods
	public boolean addCategory() {

		System.out.println(CATEGORY_DATA_ELEMENT);
		CATEGORY_DATA_ELEMENT.sendKeys("TEST" + genRandomNum(999));

		// To get the Value entered in the text box
		String categoryValue = CATEGORY_DATA_ELEMENT.getAttribute("value");
		ADD_CATEGORY_ELEMENT.click();

		// To find all the categories listed in the page
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='controls']//span"));

		for (int i = 0; i < allElements.size(); i++) {

			if (allElements.get(i).getText().equals(categoryValue)) {
				return true;
			}
		}
		return false;

	}

	public boolean addDuplicateCategory() {

		CATEGORY_DATA_ELEMENT.sendKeys("TEST" + genRandomNum(999));

		// To get the Value entered in the text box
		String categoryValue = CATEGORY_DATA_ELEMENT.getAttribute("value");
		System.out.println(categoryValue);
		ADD_CATEGORY_ELEMENT.click();

		CATEGORY_DATA_ELEMENT.sendKeys(categoryValue);
		ADD_CATEGORY_ELEMENT.click();

		String warningText = ("The category you want to add already exists:" + categoryValue);

		List<WebElement> l = driver.findElements(By.xpath("//body[contains(text(),warningText)]"));
		// verify list size
		if (l.size() > 0) {
			System.out.println("Text: " + warningText + " is present. ");
			return true;
		} else {
			return false;
		}
	}

	public int dropDownList() {

		String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
		Select select = new Select(DROPDOWN_ELEMENT);
		List<WebElement> options = select.getOptions();
		int count = 0;

		// dropdown options
		for (WebElement dropdown : options) {

			System.out.println("dropdown options " + dropdown.getText());

			// String Array
			for (int i = 0; i < months.length; i++) {
				System.out.println("String list " + months[i]);
				if (dropdown.getText().equalsIgnoreCase(months[i])) {

					count++;
					break;
				}
			}

		}
		return count;
	}

}
