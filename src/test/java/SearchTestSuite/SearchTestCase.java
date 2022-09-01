package SearchTestSuite;

import Pages.SearchPage;
import Utils.ExcelUtils;
import Utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

public class SearchTestCase {

    private SearchPage sp;
    private WebDriver driver;
    private WebDriverWait wait;
    private ExcelUtils eu;

    @BeforeClass
    public void setUp(){
        driver = WebDriverUtils.createDriverObj( 2 );
        wait = new WebDriverWait(driver, Duration.ofSeconds( 5 ));
        sp = new SearchPage(driver,wait);
        eu = new ExcelUtils();
    }

    @DataProvider(name = "data-for-search")
    private Object[][] searchForData(){
        return eu.initDataProvider( 1,0,1);
    }


    public void search(String theTerm) {
        sp.visitSearchPage();
        sp.searchTerm(theTerm);
    }

    @Test(dataProvider= "data-for-search")
    public void resultsAreBiggerThenZero(String theTerm) {
        search( theTerm );
        int res = sp.printResultNumber();
        Assert.assertTrue( res>0 );
        sp.takeScreenShot();
    }

    @Test(dataProvider= "data-for-search")
    public void firstPageResultsContainingSearchTerm(String theTerm) {
        search( theTerm );
        ArrayList<String> arr = sp.nonAdsResultStrings();
        for (int i = 0, arrSize = arr.size(); i < arrSize; i++) {
            String s = arr.get( i );
            Assert.assertTrue( s.toLowerCase( Locale.ROOT ).contains( theTerm.toLowerCase( Locale.ROOT ) ), "the " + i + " Result does not contain the term " + theTerm );
            sp.takeScreenShot();
        }


    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
