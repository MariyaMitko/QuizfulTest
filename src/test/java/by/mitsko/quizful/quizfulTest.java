package by.mitsko.quizful;

import org.testng.annotations.Test;

import by.mitsko.quizful.pages.LoginPage;
import by.mitsko.quizful.steps.Steps;
import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class quizfulTest {
	private Steps st;
	private WebDriver driver;
	
	
  @Test
  public void loginTest() {
	  String currentUserName =  st.isLoggedIn();
	 Assert.assertEquals("user is not logged", "MariaMM", currentUserName);
 }
  
  @Test
  public void InfoTest() {
	  
	  st.editProfile("Maria", "Mitsko", "1990", "mariyamitko.by", "BelGeodesy", "Беларусь", "Белоруссия/Минск(GMT+3)", "I'm study Java");
	  Assert.assertTrue(st.getText().contains("Maria Mitsko"));
	  Assert.assertTrue(st.getText().contains("1990"));
	  Assert.assertTrue(st.getText().contains("mariyamitko.by"));
	  Assert.assertTrue(st.getText().contains("Беларусь"));
	  Assert.assertTrue(st.getText().contains("Белоруссия/Минск(GMT+3)"));
	  Assert.assertTrue(st.getText().contains("I'm study Java"));
	  
  }
  
  @Test
  public void noticeTest() throws InterruptedException {
	    st.notice();
	  
	    Thread.sleep(5000);
	    Assert.assertTrue(st.getText().contains("нет"));
	    Assert.assertTrue(st.getText().contains("выключены"));
	   
		
  }
  
  @Test
  public void privacyTest() throws InterruptedException {
	    st.privacy();
	    
	    Thread.sleep(5000);
	    Assert.assertTrue(st.getText().contains("только мне"));
		
  }
  @BeforeClass
  public void login() throws InterruptedException {
	  
	  st = new Steps();
      st.initBrowser();
      Thread.sleep(2000);
      st.loginQuizful("MariaMM", "qwert12345");
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  @AfterClass
  public void afterClass() {
  }

 

}
