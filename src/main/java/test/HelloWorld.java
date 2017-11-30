package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HelloWorld{  
@Test
public void test(){
	 System.setProperty("webdriver.chrome.driver","D:/workspaces/cccis/chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
      driver.get("http://mail.163.com/");
      driver.close();
   } 
}