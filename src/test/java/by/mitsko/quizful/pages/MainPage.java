package by.mitsko.quizful.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage {
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		// TODO Auto-generated method stub
		
	}

}
