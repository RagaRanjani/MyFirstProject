package MyJavaPackage;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class MyFirstJavaClass
{
     public  WebDriver driver;
    @BeforeClass
    public void Initialize()
    {
        String driverPath = "C:\\Selenium\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }



    @Test
    public  void AssertText()
    {
        driver.get("https://www.seleniumhq.org/");
        driver.findElement(By.id("menu_documentation")).click();
        	driver.findElement(By.linkText("Selenium WebDriver")).click();
          assertEquals("Selenium WebDriver — Selenium Documentation", driver.getTitle());
          String text =  driver.findElement(By.id("how-does-webdriver-drive-the-browser-compared-to-selenium-rc")).getText();
        	assertEquals("How Does WebDriver ‘Drive’ the Browser Compared to Selenium-RC?",text);

    }

    @Test

    public  void  VerifyCheckbox()
    {
        driver.get("http://www.w3schools.com/html/html_form_input_types.asp");
        driver.findElement(By.name("vehicle1")).click();
      boolean checkbox =  driver.findElement(By.name("vehicle1")).isSelected();
      assertTrue(checkbox);
        boolean checkbox1 =  driver.findElement(By.name("vehicle2")).isSelected();
        assertFalse(checkbox1);
       String check =  driver.findElement(By.name("vehicle1")).getAttribute("value");
       System.out.println(check +"is" +checkbox );
    }

    @Test

    public  void  SelectRadioButton()
    {

    }

    @After

    public  void  CloseDriver()
    {
        driver.close();
        driver.quit();
    }

}
