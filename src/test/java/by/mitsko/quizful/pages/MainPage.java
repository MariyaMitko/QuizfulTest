package by.mitsko.quizful.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage {
	private final String BASE_URL = "http://www.quizful.net/test";
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		
		driver.navigate().to(BASE_URL);
	}

}
