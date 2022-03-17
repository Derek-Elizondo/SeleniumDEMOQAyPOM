package seleniumDEMOQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumDemoQA {
	public String basUrl = "https://demoqa.com/elements";
	String driverPath = "src/test/resources/drivers/chromedriver";
	public WebDriver driver;
	
	@BeforeMethod
	private void startDriver() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(basUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void checkbox() { 
		
		WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("item-1")));
		
		WebElement menuCheckbox = driver.findElement(By.id("item-1"));
		menuCheckbox.click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/button[1]/*[1]")));
		
		WebElement openCheckbox = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/span[1]/button[1]/*[1]"));
		openCheckbox.click();
		
		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/label[1]/span[1]/*[1]")));
		
		WebElement checkbox = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/ol[1]/li[1]/ol[1]/li[3]/span[1]/label[1]/span[1]/*[1]"));
		checkbox.click();
		
		WebElement sucessMessage = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.check-box-tree-wrapper:nth-child(2) div.display-result.mt-4 > span.text-success:nth-child(2)"));
		Assert.assertEquals(sucessMessage.getText(), "downloads");
		
		
		
	}
	
	@Test
	public void webtables() throws InterruptedException {
		
		Thread.sleep(10000);
		
		
		WebElement menuWebtables = driver.findElement(By.id("item-3"));
		menuWebtables.click();
		
		WebElement trash1 = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.web-tables-wrapper:nth-child(2) div.ReactTable.-striped.-highlight div.rt-table div.rt-tbody div.rt-tr-group:nth-child(3) div.rt-tr.-odd div.rt-td:nth-child(7) div.action-buttons span:nth-child(2) svg:nth-child(1) > path:nth-child(1)"));
		trash1.click();
		
		WebElement trash2 = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.web-tables-wrapper:nth-child(2) div.ReactTable.-striped.-highlight div.rt-table div.rt-tbody div.rt-tr-group:nth-child(2) div.rt-tr.-even div.rt-td:nth-child(7) div.action-buttons span:nth-child(2) svg:nth-child(1) > path:nth-child(1)"));
		trash2.click();
		
		WebElement modifyIcon = driver.findElement(By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div.web-tables-wrapper:nth-child(2) div.ReactTable.-striped.-highlight div.rt-table div.rt-tbody div.rt-tr-group:nth-child(1) div.rt-tr.-odd div.rt-td:nth-child(7) div.action-buttons span.mr-2:nth-child(1) > svg:nth-child(1)"));
		modifyIcon.click();
		
		WebElement firstname = driver.findElement(By.cssSelector("#firstName"));
		firstname.sendKeys("Derek");
		
		WebElement salary = driver.findElement(By.cssSelector("#salary"));
		salary.sendKeys("10,000,000");
		
		WebElement submit = driver.findElement(By.id("submit"));
		submit.click();
		
		
	}
	
	@AfterMethod
	
	public void quit() {
		driver.quit();
	}
	
	
	
	

	

}
