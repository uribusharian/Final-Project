package ShoppingTestSuite;

import Pages.ShoppingPage;
import Utils.ExcelUtils;
import Utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Locale;

public class ShoppingTestCase {


    private ShoppingPage sp;
    private WebDriver driver;
    private WebDriverWait wait;
    private ExcelUtils eu;



    @BeforeClass
    public void setUp() {
        driver = WebDriverUtils.createDriverObj( 2 );
        wait = new WebDriverWait( driver, Duration.ofSeconds( 5 ) );
        sp = new ShoppingPage( driver, wait );
        eu = new ExcelUtils();
    }
    @DataProvider(name = "data-for-shopping")
    private Object[][] DataForShopping(){
        return eu.initDataProvider( 2,0,2);
    }

    public void search(String theTerm) {
        sp.visitShoppingPage();
        sp.searchTerm(theTerm);
    }
    @Test(dataProvider= "data-for-shopping")
    public void firstPageResultsContainingSearchTerm(String theTerm) {
        search( theTerm );
        ArrayList<String> arr = sp.resultsNameStrings();
        for (int i = 0, arrSize = arr.size(); i < arrSize; i++) {
            String s = arr.get( i );
            Assert.assertTrue( s.toLowerCase( Locale.ROOT ).contains( theTerm.toLowerCase( Locale.ROOT ) ), "the " + i + " Result does not contain the term " + theTerm );
            sp.takeScreenShot();
        }
    }

    @Test(dataProvider= "data-for-shopping")
    public void sortByPriceAscending(String theTerm) throws InterruptedException {
        search( theTerm );
        sp.sortByPrice();
        Thread.sleep( 3000 );
        ArrayList<Double> arr = sp.printPriceNumber();
        Assert.assertTrue( arr.get( 0 ) <= arr.get( 1 ) && arr.get( 1 ) <= arr.get( 2 )&& arr.get( 2) <= arr.get( 3 ));
        sp.takeScreenShot();
    }
    @Test(dataProvider= "data-for-shopping")
    public void sortByPriceDescending(String theTerm) throws InterruptedException {
        search( theTerm );
        sp.sortByPrice();
        sp.sortByPrice();
        Thread.sleep( 3000 );
        ArrayList<Double> arr = sp.printPriceNumber();
        Assert.assertTrue( arr.get( 0 ) >= arr.get( 1 ) && arr.get( 1 ) >= arr.get( 2 )&& arr.get( 2) >= arr.get( 3 ));
        sp.takeScreenShot();
    }

    @Test(dataProvider= "data-for-shopping")
    public void testDiscountDifference (String theTerm) throws InterruptedException, IOException {
        search( theTerm );
        sp.sortByDiscount();
        Thread.sleep( 1000 );
        ArrayList<Double> arr = sp.getAmountSaved();
        ArrayList<Double> arr2 = sp.checkDiscountDifference();
        Assert.assertEquals( arr,arr2 );
        sp.takeScreenShot();
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}