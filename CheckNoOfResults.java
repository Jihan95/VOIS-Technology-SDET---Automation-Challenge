package Tests;

import base.BaseTests;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FirstResultPage;
import pages.SecondResultPage;
import pages.ThirdResultPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckNoOfResults  extends BaseTests {

    @Test
    public void checkEqualityOfResults () throws IOException {

        File file = new File("E://vodafone task data//TestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet =workbook.getSheetAt(0);
        String searchWord =sheet.getRow(1).getCell(1).toString();

        FirstResultPage firstResultPage = searchPage.setSearchWord(searchWord);
        firstResultPage.scrollDown();
        SecondResultPage secondResultPage = firstResultPage.clickSecondPage();
        secondResultPage.scrollDown();
        int noOfSecondPageResults = secondResultPage.countResults();
        ThirdResultPage thirdResultPage = secondResultPage.clickThirdPage();
        int noOfThirdPageResults = thirdResultPage.countResults();
        Assert.assertEquals(noOfSecondPageResults,noOfThirdPageResults);


    }
}
