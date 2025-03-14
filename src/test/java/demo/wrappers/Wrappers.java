package demo.wrappers;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */
    public static void enterText(WebElement element, String text){
        try{

            element.clear();
            element.sendKeys(text);

        }catch(Exception e){
            e.printStackTrace();
        }

     }


     public static void radioButton(ChromeDriver driver, String value){
        try{

            List <WebElement> radioButtons = driver.findElements(By.xpath("//div[contains(@class,'zwllIb')]"));
            for(WebElement radioButton: radioButtons){
                if(radioButton.getText().equals(value)){
                    radioButton.click();
                }
                break;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

     }

     public static void checkBoxes(ChromeDriver driver, String dropdowntext){
        try{
          List <WebElement> checkBoxes = driver.findElements(By.xpath("//label[contains(@class,'Yri8Nb')]"));
          for(WebElement checkBox:checkBoxes){
            if(checkBox.getText().equals(dropdowntext)){
                if(!checkBox.isSelected()){
                    checkBox.click();
                }
                break;
            }
          }
        }

        catch(Exception e){
            e.printStackTrace();
        }

     }

     public static void clickDropDown(ChromeDriver driver){
         WebElement titleDropDown= driver.findElement(By.xpath("//div[contains(@class,'KKjvXb')]"));
         titleDropDown.click();

    }

    public static void selectTitle(ChromeDriver driver, String abv){
        List<WebElement> titles = driver.findElements(By.xpath("//div[contains(@class,'ncFHed')]//div[contains(@class,'OIC90c')]"));
        for(WebElement title :titles){
            if(title.getText().equals(abv)){
                title.click();
            }
            break;
        }
    }


    public static void date(ChromeDriver driver){
        try{
            WebElement dateField = driver.findElement(By.xpath("//input[@type='date']"));
            LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = sevenDaysAgo.format(formatter);
            System.out.println(formattedDate);
            dateField.sendKeys(formattedDate);
        }
        catch(Exception e){
            e.printStackTrace();
        }
       

    }


public static void clickonElement(ChromeDriver driver, WebElement element){
    try{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }
    catch(Exception e){
        e.printStackTrace();
    }
}


}




