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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.junit.jupiter.api.Test;

/**
 * Selenium test to simulate the process of creating a slider with valid input.
 * This test fills out the form fields for creating a new slider and verifies 
 * that the slider is created successfully.
 * 
 * Test Steps:
 * 1. Open the application.
 * 2. Navigate to the "Show All Slider Items" page.
 * 3. Navigate to the "Create New Slider" page.
 * 4. Fill in all required slider details with valid values.
 * 5. Save the new slider.
 * 6. Verify that the "Slider was successfully created." message appears.
 * 
 * Expected result: The application should display a success message upon creating the slider.
 * 
 * Dependencies:
 * Ensure the Selenium WebDriver is properly set up and the application is running locally.
 * 
 * @author Guntas
 */
public class CreateSliderPassSelenium {
    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    /**
     * Sets up the Selenium WebDriver before each test.
     * Initializes the ChromeDriver, JavascriptExecutor, and necessary variables.
     */
    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    /**
     * Tears down the Selenium WebDriver after each test.
     * Closes the browser and quits the WebDriver session.
     */
    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test case for creating a slider with valid input.
     * 
     * Steps:
     * 1. Open the homepage of the application.
     * 2. Navigate to the "Show All Slider Items" page.
     * 3. Navigate to the "Create New Slider" page.
     * 4. Fill in all fields with valid slider data.
     * 5. Save the slider.
     * 6. Verify that the success message "Slider was successfully created." is displayed.
     */
    @Test
    public void createslider() {
        // Step 1: Open the application homepage
        driver.get("http://localhost:8080/Slider/");
        
        // Step 2: Set the browser window size
        driver.manage().window().setSize(new Dimension(945, 1060));
        
        // Step 3: Navigate to the "Show All Slider Items" page
        driver.findElement(By.linkText("Show All Slider Items")).click();
        
        // Step 4: Navigate to the "Create New Slider" page
        driver.findElement(By.linkText("Create New Slider")).click();
        
        // Step 5: Click on the 'size' field and input value
        driver.findElement(By.id("j_idt12:size")).click();
        driver.findElement(By.id("j_idt12:size")).sendKeys("40");
        
        // Step 6: Click on the 'x' field and input value
        driver.findElement(By.id("j_idt12:x")).click();
        driver.findElement(By.id("j_idt12:x")).sendKeys("10");
        
        // Step 7: Click on the 'y' field and input value
        driver.findElement(By.id("j_idt12:y")).click();
        driver.findElement(By.id("j_idt12:y")).sendKeys("10");
        
        // Step 8: Click on the 'maxTravel' field and input value
        driver.findElement(By.id("j_idt12:maxTravel")).click();
        driver.findElement(By.id("j_idt12:maxTravel")).sendKeys("10");
        
        // Step 9: Click on the 'currentTravel' field and input value
        driver.findElement(By.id("j_idt12:currentTravel")).click();
        driver.findElement(By.id("j_idt12:currentTravel")).click(); // Click again to focus
        WebElement element = driver.findElement(By.id("j_idt12:currentTravel"));
        Actions builder = new Actions(driver);
        builder.doubleClick(element).perform();  // Double-click to focus
        driver.findElement(By.id("j_idt12:currentTravel")).sendKeys("10");
        
        // Step 10: Click on the 'mvtDirection' field and input value
        driver.findElement(By.id("j_idt12:mvtDirection")).click();
        driver.findElement(By.id("j_idt12:mvtDirection")).sendKeys("1100");
        
        // Step 11: Click on the 'dirChangeCount' field and input value
        driver.findElement(By.id("j_idt12:dirChangeCount")).click();
        driver.findElement(By.id("j_idt12:dirChangeCount")).sendKeys("010");
        
        // Step 12: Click the 'Save' button to create the slider
        driver.findElement(By.linkText("Save")).click();
        
        // Step 13: Verify the success message that the slider was created successfully
        assertThat(driver.findElement(By.cssSelector("table:nth-child(1) td")).getText(), 
                is("Slider was successfully created."));
    }
}
