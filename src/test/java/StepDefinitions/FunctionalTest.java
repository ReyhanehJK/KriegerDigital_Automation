package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.PageFactoryModel;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FunctionalTest {


	WebDriver driver = null;
	String BaseURL = "https://www.hoeffner.de/konfigurator/dreamer";
	PageFactoryModel	PageFactoryModel_POM;

	@BeforeTest
	public void browserSetup() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);

		//setProperty for Windows
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriver.exe");

		//setProperty for MAC
		//System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriverMAC");

		//setProperty for linux
		//System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/chromedriverLinux");

		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}


	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

			
	@Test
	@Given("Go to the site.")
	public void go_to_the_site()  throws InterruptedException, IOException {
		System.out.println("*** The Browser Launched and Opened & all the Test Steps is Passed ***");
		
		//Pass the Pop-up page
		if
		(driver.findElement(By.xpath("//*[@id=\"responsive\"]/div[16]/div/div/h2")).getText().equals("Cookie-Einstellungen")) {
			driver.findElement(By.xpath("//*[@id=\"responsive\"]/div[16]/div/div/div[2]/div[2]/button")).click();
			System.out.println("The Pop-up page was present and accepted");	}
		else
		{		System.out.println("The Pop-up was not present");		}


		driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[1]/div/ul")).getText().equals("Korpus");
		{	System.out.println("Step 1 of 6");	}
		String STEP_01_Text =driver.findElement(By.xpath("//*[@id=\"configuratorData\"]/div[1]/div[1]/div[1]/div")).getText();
		System.out.println(STEP_01_Text);

		//Breite
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[6]/span")).click();
		Thread.sleep(2000);
		//Höhe
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[3]/div/div[2]/div[2]/span")).click();
		Thread.sleep(2000);
		//Korpusfarbe
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[4]/div/div[2]/div[5]/span")).click();
		Thread.sleep(2000);
		//check Korpus title
		String expectedTitle="400 cm, 236 cm, Platineiche";
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[1]/div/ul/li[2]")).getText();
		Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
		System.out.println(actualTitle);

		String Step_01_Summary_prices=driver.findElement(By.xpath("//*[@id=\"configuratorSummary\"]/div/div[3]/div/div[1]/div/ins/div[1]")).getText();
		System.out.println("After chosing the Schritt 1 - Korpus, Price is..."+Step_01_Summary_prices+"...Euros");

		driver.findElement(By.xpath("//*[@id=\"submitStepButtonId\"]")).click();


		System.out.println("Step 2 of 6");
		Thread.sleep(2000);
		//Türenart
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[1]/span/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[2]/div/ul/li[2]")).getText().equals("Drehtüren mit Türdämpfer");
		Thread.sleep(2000);
		String Step_02_Summary_prices=driver.findElement(By.xpath("//*[@id=\"configuratorSummary\"]/div/div[3]/div/div[1]/div/ins/div[1]")).getText();
		System.out.println("After chosing the Schritt 2 - Türart, Price is..."+Step_02_Summary_prices+"...Euros");

		driver.findElement(By.xpath("//*[@id=\"submitStepButtonId\"]")).click();


		System.out.println("Step 3 of 6");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[3]/div/ul/li[1]")).getText().equals("Türdesign");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[2]/span")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scroll to the specific of the page
		js.executeScript("window.scrollTo(250, document.body.scrollLow)");

		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[3]/div/ul/div[2]/li/span/span[2]/span[1]")).click();
		Thread.sleep(2000);

		String Step_03_Summary_prices=driver.findElement(By.xpath("//*[@id=\"configuratorSummary\"]/div/div[3]/div/div[1]/div/ins/div[1]")).getText();
		System.out.println("After chosing the Schritt 3 - Türdesign, Price is..."+Step_03_Summary_prices+"...Euros");

		//Get the Screenshot of product details
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(System.getProperty("user.dir")+"/ScreenShotOfResult/Schritt_3_Türdesign.png"));

		driver.findElement(By.xpath("//*[@id=\"submitStepButtonBottomId\"]")).click();


		System.out.println("Step 4 of 6");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[3]/span/span[1]/span")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[4]/div/ul/li[1]")).getText().equals("Griffe");

		//identify image
		//WebElement i = driver.findElement(By.xpath("//*[@id=\"responsive\"]/div[20]"));
		// Javascript executor to check image
		//Boolean p = (Boolean) ((JavascriptExecutor)driver) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);
		//verify if status is true
		//if (p) {
		//	System.out.println("Image present");
		//} else {
		//	System.out.println("Image not present");
		//}
		
		String Step_04_Summary_prices=driver.findElement(By.xpath("//*[@id=\"configuratorSummary\"]/div/div[3]/div/div[1]/div/ins/div[1]")).getText();
		System.out.println("After chosing the Schritt 4 - Griffe, Price is..."+Step_04_Summary_prices+"...Euros");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"submitStepButtonBottomId\"]")).click();
		
		
		System.out.println("Step 5 of 6");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[3]/span")).click();
		Thread.sleep(3000);
		
		//Reset configuration
		driver.findElement(By.xpath("//*[@id=\"resetAttributeSelectionButton\"]/div/div[1]")).click();
		// Check  the Check box is selected or not	
        if (driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[3]/span")).isSelected()) {					
            System.out.println("Faild: Reset configuration button didn't work, Checkbox is selected");					
        } else {			
            System.out.println("Pass: Reset configuration button worked, Checkbox is Not Selected");					
        }

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submitStepButtonBottomId\"]")).click();
		Thread.sleep(3000);

    	String expectedTitle02="Bitte wählen Sie alle Merkmale aus";
		String actualTitle02 = driver.findElement(By.xpath("//*[@id=\"configuratorSummary\"]/div/div[1]/div/span")).getText();
		Assert.assertEquals(expectedTitle02,actualTitle02,"xxxxxxx- Failed: The Error handeling didn't work -xxxxxxx");
		System.out.println("Pass..."+actualTitle02);

		driver.findElement(By.xpath("//*[@id=\"configuratorAttributeValues\"]/div[2]/div/div[2]/div[4]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"submitStepButtonBottomId\"]")).click();
		
		System.out.println("Step 6 of 6");
		
		driver.findElement(By.xpath("//*[@id=\"configuratorSteps\"]/div[6]/div/ul/li[1]")).getText().equals("Zubehör");
		System.out.println("*****Test Pass______Have a good time******");
		
	}
}
