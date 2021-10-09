package webapp.TopicServlet;

import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  @Test
  public void checkTitle() {
	  //Load republic poly website as a new page
	  webDriver.navigate().to("http://localhost:8087/Forum/Home.jsp");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver.getTitle(), "Home");
	  
	  System.out.println("title: "+webDriver.getTitle());
	  
	  //Retrieve explore now button using it's class name and click on it
	  webDriver.findElement(By.className("topics")).click();

	  //Assert the new title to check that the title contain RP360 and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver.getTitle().contains("Topics"));
	  System.out.println("new title: "+webDriver.getTitle());

  }
  
  
  public void checkTopic() {
	  //Load republic poly website as a new page
	  webDriver.navigate().to("http://localhost:8087/Forum/TopicServlet");
	  Assert.assertEquals(webDriver.getTitle(), "Topics");
	  	  
	  //Retrieve explore now button using it's class name and click on it
		String name = webDriver.findElement(By.className("thread")).getAttribute("href");
	  
	  //Assert the new title to check that the title contain RP360 and the button had successfully bring us to the new page
	  Assert.assertTrue(name.contains("http://localhost:8087/Forum/threads.php"));
	  System.out.println("Hyperlink for thread: "+name);

  }
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //use C:\Program Files\Google\Chrome\chromedriver_win32
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver_win32_2\\chromedriver.exe");

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}

