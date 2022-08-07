package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SecondResultPage {
    private WebDriver driver;
    private By thirdPage = By.xpath("//a[@aria-label ='Page 3']");

    public SecondResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollDown (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }

    public ThirdResultPage clickThirdPage(){
        driver.findElement(thirdPage).click();
        return new ThirdResultPage(driver);
    }

    public int countResults(){
        return driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).size();
    }
}
