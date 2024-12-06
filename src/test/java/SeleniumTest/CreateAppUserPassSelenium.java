package SeleniumTest;

// Generated by Selenium IDE

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Selenium test to automate the creation of an AppUser in the application.
 * This test uses a Chrome WebDriver to navigate the application UI and validate
 * the creation of a new AppUser entity.
 * 
 * Steps:
 * 1. Open the application.
 * 2. Navigate to the "Create New AppUser" page.
 * 3. Fill in the AppUser details (userid, password, groupname).
 * 4. Save the new AppUser.
 * 5. Verify that the newly created AppUser is listed in the AppUser table.
 * 
 * Dependencies:
 * Ensure the Selenium WebDriver is set up correctly and the application is running locally.
 * 
 * @author Guntas
 */
public class CreateAppUserPassSelenium {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  /**
   * Sets up the Selenium WebDriver and initializes the environment for testing.
   * This method is executed before each test.
   */
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  /**
   * Tears down the Selenium WebDriver and cleans up after testing.
   * This method is executed after each test.
   */
  @After
  public void tearDown() {
    driver.quit();
  }

  /**
   * Test case for creating a new AppUser.
   * 
   * Steps:
   * 1. Navigate to the application homepage.
   * 2. Navigate to the "Show All AppUser Items" page.
   * 3. Navigate to the "Create New AppUser" page.
   * 4. Enter valid user details for "userid", "password", and "groupname".
   * 5. Save the new user.
   * 6. Verify that the user appears in the "Show All AppUser Items" table.
   */
  @Test
  public void createappuser() {
    // Step 1: Open the application homepage
    driver.get("http://localhost:8080/Slider/");
    
    // Step 2: Set browser window size
    driver.manage().window().setSize(new Dimension(945, 1060));
    
    // Step 3: Navigate to "Show All AppUser Items" page
    driver.findElement(By.linkText("Show All AppUser Items")).click();
    
    // Step 4: Navigate to "Create New AppUser" page
    driver.findElement(By.linkText("Create New AppUser")).click();
    
    // Step 5: Fill in AppUser details
    driver.findElement(By.id("j_idt12:userid")).click();
    driver.findElement(By.id("j_idt12:userid")).sendKeys("ayan");
    driver.findElement(By.id("j_idt12:password")).sendKeys("1234");
    driver.findElement(By.id("j_idt12:groupname")).sendKeys("Admin");
    
    // Step 6: Save the new AppUser
    driver.findElement(By.linkText("Save")).click();
    
    // Step 7: Navigate back to "Show All AppUser Items" page
    driver.findElement(By.linkText("Show All AppUser Items")).click();
    
    // Step 8: Verify that the new user appears in the AppUser table
    assertThat(driver.findElement(By.cssSelector(".jsfcrud_odd_row:nth-child(7) > td:nth-child(2)")).getText(), is("ayan"));
  }
}
