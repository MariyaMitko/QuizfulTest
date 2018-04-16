package by.mitsko.quizful.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import by.mitsko.quizful.driver.SingletonDriver;
import by.mitsko.quizful.pages.LoginPage;

public class Steps {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser(){
		driver = SingletonDriver.getDriver();
	}

		
	public void closeDriver(){
		SingletonDriver.closeDriver();
	}

	public void loginQuizful(String username, String password){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}
	
	public String isLoggedIn(){
		LoginPage loginPage = new LoginPage(driver);
		WebElement userName = driver.findElement(By.xpath("//*[@id='user-panel']/li[1]/b/a"));
		String currentUserName  = userName.getText();
		return currentUserName;
	}
	
	public void editProfile(String nm, String snm, String by, String st, String comp, String countr, String z, String a){
		WebElement profile = driver.findElement(By.xpath("//*[@id='navigation']/li[7]/a"));
		profile.click();
		
		WebElement editing = driver.findElement(By.xpath("//*[@id='middle']/div[2]/div[1]/div[2]/div/a"));
		editing.click();
		
		WebElement arrow = driver.findElement(By.xpath("//*[@id='profile-personal-form']/div[2]/img"));
		arrow.click();
		
		WebElement name = driver.findElement(By.name("personalForm.name"));
		name.sendKeys(nm);
		
		WebElement surname = driver.findElement(By.name("personalForm.surname"));
		surname.sendKeys(snm);
		
		WebElement birthyear = driver.findElement(By.name("personalForm.birthyear"));
		birthyear.sendKeys(by);
		
		WebElement site = driver.findElement(By.name("personalForm.site"));
		site.sendKeys(st);
		
		WebElement company = driver.findElement(By.name("personalForm.company"));
		company.sendKeys(comp);
		
		WebElement country = driver.findElement(By.name("personalForm.countryId"));
		Select select = new Select(country);
		select.selectByVisibleText(countr);
		
		WebElement zone = driver.findElement(By.name("personalForm.zone"));
		Select select2 = new Select(zone);
		select2.selectByVisibleText(z);
		
		WebElement about = driver.findElement(By.name("personalForm.about"));
		about.sendKeys(a);
		
		WebElement save = driver.findElement(By.name("personalForm.save"));
		save.click();
		logger.info("Information was edited")
	}
	
	public void notice () throws InterruptedException{
		WebElement profile = driver.findElement(By.xpath("//*[@id='navigation']/li[7]/a"));
		profile.click();
		
		Thread.sleep(5000);
		
		WebElement editing = driver.findElement(By.xpath("//*[@id='middle']/div[2]/div[1]/div[2]/div/a"));
		editing.click();
		
		WebElement notice = driver.findElement(By.xpath("//*[@id='profile-notifications-form']/div[1]/img"));
		notice.click();
		
		Thread.sleep(5000);
		
		WebElement notifications = driver.findElement(By.name("notificationsForm.notificationsEnabled"));
		notifications.click();
					
		WebElement delivery = driver.findElement(By.name("notificationsForm.deliveryEnabled"));
		delivery.click();
		
		WebElement save = driver.findElement(By.name("notificationsForm.save"));
		save.click();
		
		logger.info("Notifications was edited")
		
	}
	
	public void privacy () throws InterruptedException{
		WebElement profile = driver.findElement(By.xpath("//*[@id='navigation']/li[7]/a"));
		profile.click();
		
                Thread.sleep(5000);
		
		WebElement editing = driver.findElement(By.xpath("//*[@id='middle']/div[2]/div[1]/div[2]/div/a"));
		editing.click();
		
		WebElement priv = driver.findElement(By.xpath("//*[@id='profile-privacy-form']/div[1]/img"));
		priv.click();
		
		Thread.sleep(5000);
		
		WebElement visible = driver.findElement(By.xpath("//*[@id='profile-privacy-form']/div[2]/form/table/tbody/tr[4]/td[1]/label/input"));
		visible.click();
		
		WebElement save = driver.findElement(By.name("privacyForm.save"));
		save.click();
		
		logger.info("Privasy was edited")
		
	}
	
    public String getText(){
		
		WebElement text = driver.findElement(By.xpath("//*[@id='personal-contacts']"));
		return text.getText();
}
}
