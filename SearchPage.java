package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class SearchPage {
    private WebDriver driver;
    private By searchBox = By.xpath("//input[@name='q']");
    private By searchButton = By.xpath("(//input[@class='gNO89b'])[2]");

    public SearchPage(WebDriver driver){
        this.driver =driver;
    }

    public FirstResultPage setSearchWord (String searchWord){
        driver.findElement(searchBox).sendKeys(searchWord);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        return new FirstResultPage(driver);
    }


}
