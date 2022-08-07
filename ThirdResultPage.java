package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThirdResultPage {

    private WebDriver driver;

    public ThirdResultPage(WebDriver driver){
        this.driver = driver;
    }

    public int countResults(){
        return driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']")).size();
    }
}
