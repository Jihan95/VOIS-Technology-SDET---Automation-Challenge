package base;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SearchPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BaseTests {
    private WebDriver driver;


    protected SearchPage searchPage;


    @BeforeClass
    public void setUP() throws IOException {

        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        driver = new FirefoxDriver();

        File file = new File("E://vodafone task data//TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet2 = workbook.getSheetAt(0);
        String URL = sheet2.getRow(0).getCell(1).toString();

        driver.get(URL);
        searchPage = new SearchPage(driver);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
