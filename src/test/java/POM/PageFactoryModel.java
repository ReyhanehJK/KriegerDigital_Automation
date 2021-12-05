package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageFactoryModel {

// it just some example of POM model
	
	@FindBy(xpath = "//*[@id=\\\"configuratorAttributeValues\\\"]/div[2]/div/div[2]/div[6]/span")
	WebElement btn_Breite;

	@FindBy(xpath = "//*[@id=\\\"configuratorAttributeValues\\\"]/div[3]/div/div[2]/div[2]/span")
	WebElement btn_Höhe;

	@FindBy(xpath = "//*[@id=\\\"configuratorAttributeValues\\\"]/div[4]/div/div[2]/div[5]/span")
	WebElement btn_Korpusfarbe;

	@FindBy(xpath = "//*[@id=\\\"submitStepButtonId\\\"]")
	WebElement btn_Submit;



	WebDriver driver;	
	public void SingUp_PF(WebDriver driver) {
		this.driver = driver;

		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}


	public void clickOnBreite() {
		btn_Breite.click();
	}

	public void ClickOnHöhe() {
		btn_Höhe.click();
	}	

	public void ClickOnKorpusfarbe() {
		btn_Korpusfarbe.click();
	}

	public void ClickOnSubmit() {
		btn_Submit.click();
	}

}


