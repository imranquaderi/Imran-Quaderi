package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import java.util.logging.Level;
// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    
    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */
    @Test
    public void testCase01() throws InterruptedException{
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(2000);
        
        WebElement nameField = driver.findElement(By.xpath("//input[@aria-labelledby='i1 i4']"));
        nameField.sendKeys("Crio Learner");
        Thread.sleep(2000);
        

        WebElement YAYP = driver.findElement(By.xpath("//textarea[@aria-describedby='i7 i8']"));
        long epochTime = System.currentTimeMillis() / 1000; // Get epoch time in seconds
        String response = "I want to be the best QA Engineer! " + epochTime;
        YAYP.sendKeys(response);
        Thread.sleep(2000);

        WebElement ATExp = driver.findElement(By.xpath("//span[text()='0 - 2']"));
        ATExp.click();
        Thread.sleep(2000);

        WebElement learnJava =driver.findElement(By.xpath("//span[text()='Java']"));
        learnJava.click();

        WebElement learnSelenium = driver.findElement(By.xpath("//span[text()='Selenium']"));
        learnSelenium.click();

        WebElement learnTestNG = driver.findElement(By.xpath("//span[text()='TestNG']"));
        learnTestNG.click();

        Thread.sleep(2000);

        WebElement choose = driver.findElement(By.xpath("//span[text()='Choose']"));
        choose.click();
        Thread.sleep(2000);

        WebElement Mr = driver.findElement(By.xpath("(//span[text()='Mr'])[2]"));
        Mr.click();
        Thread.sleep(2000);

        // Calculate the date 7 days ago
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = sevenDaysAgo.format(formatter);
        System.out.println(formattedDate);

        // Locate the date input field and enter the calculated date
        WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
        dateField.sendKeys(formattedDate);
        Thread.sleep(2000);


        Actions action = new Actions(driver);
        action.
        keyDown(Keys.TAB).
        keyUp(Keys.TAB).
        keyDown(Keys.TAB).
        keyUp(Keys.TAB).
        sendKeys("7").
        keyDown(Keys.TAB).
        keyUp(Keys.TAB).
        sendKeys("30").
        perform();

        // WebElement hourField = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        // hourField.sendKeys("7");

        // WebElement minuteField = driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        // minuteField.sendKeys("30");

        WebElement submitButton = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
        submitButton.click();
        Thread.sleep(2000);

        WebElement sussessMessage = driver.findElement(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']"));
        System.out.println(sussessMessage.getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Thanks for your response, Automation Wizard!']")));

        if(sussessMessage.getText().contains("Thanks for your response, Automation Wizard!"))
        {
            System.out.println("QA_XGOOGLE_FORM Project Passed");
        }
        else{
            System.out.println("QA_XGOOGLE_FORM Project Failed");
        }

    }
     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}