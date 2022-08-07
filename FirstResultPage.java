package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FirstResultPage {
    private WebDriver driver;
    private By secondPage = By.xpath("//a[@aria-label ='Page 2']");

    public FirstResultPage(WebDriver driver){
        this.driver =driver;
    }
    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
    public SecondResultPage clickSecondPage(){
        driver.findElement(secondPage).click();
        return new SecondResultPage(driver);
    }
}
