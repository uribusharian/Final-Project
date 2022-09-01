package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingPage extends BasePage {


    //Constructors
    public ShoppingPage(WebDriver driver, WebDriverWait wait) {
        super( driver, wait );
    }
    // Fields

    // the home page URL
    String baseURL = "https://www.shopping.yahoo.com/";

    By firstResultName = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:first-child>a>div>:nth-child(4)>:nth-child(2)" );
    By firstResultPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:first-child>a>div>div:nth-child(4)>div>span" );
    By secondResultName = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(2)>a>div>:nth-child(4)>:nth-child(2)" );
    By secondResultPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(2)>a>div>div:nth-child(4)>div>span" );
    By thirdResultName = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(3)>a>div>:nth-child(4)>:nth-child(2)" );
    By thirdResultPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(3)>a>div>div:nth-child(4)>div>span" );
    By forthResultName = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(4)>a>div>:nth-child(4)>:nth-child(2)" );
    By forthResultPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(4)>a>div>div:nth-child(4)>div>span" );
    By sortByDiscountBtn = By.cssSelector( "[class=\"Sorting___StyledDiv-sc-97zxb5-8 SAFfd\"]>a:nth-child(3)" );
    By sortByPriceBtn = By.cssSelector( "[class=\"Sorting___StyledDiv-sc-97zxb5-8 SAFfd\"]>a:nth-child(4)" );
    By shoppingSearchBar = By.cssSelector( "[name=\"p\"]" );
    By shoppingSearchBtn = By.cssSelector( "[class=\"button1\"]" );
    By firstResultActualPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:first-child>a>div>div:nth-child(4)>div>:first-child" );
    By secondResultActualPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(2)>a>div>div:nth-child(4)>div>:first-child" );
    By thirdResultActualPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(3)>a>div>div:nth-child(4)>div>:first-child" );
    By forthResultActualPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(4)>a>div>div:nth-child(4)>div>:first-child" );
    By firstResultPreviousPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:first-child>a>div>div:nth-child(4)>div>:nth-child(2)" );
    By secondResultPreviousPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(2)>a>div>div:nth-child(4)>div>:nth-child(2)" );
    By thirdResultPreviousPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(3)>a>div>div:nth-child(4)>div>:nth-child(2)" );
    By forthResultPreviousPrice = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(4)>a>div>div:nth-child(4)>div>:nth-child(2)" );
    By firstAmountSaved = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:first-child>a>div>div:nth-child(3)>span" );
    By secondAmountSaved = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(2)>a>div>div:nth-child(3)>span" );
    By thirdAmountSaved = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(3)>a>div>div:nth-child(3)>span" );
    By forthAmountSaved = By.cssSelector( "[class=\"Grid__Container-sc-1xfj9j2-0 dCKJnw ResultList__GridWrapper-sc-1iyk8ze-0 bxqinw\"]>:nth-child(4)>a>div>div:nth-child(3)>span" );

    //Methods
    public void visitShoppingPage() {
        visit( baseURL );

    }

    public void searchTerm(String theTerm) {
        findElem( shoppingSearchBar ).sendKeys( theTerm );
        findElem( shoppingSearchBtn ).click();
    }

    public ArrayList<Double> printPriceNumber() {
        var arr = new ArrayList<Double>();
        var results = new ArrayList<String>();
        waitUntilPresenceOfElementLocated( firstResultPrice );
        String results1 = findElem( firstResultPrice ).getText();
        String results2 = findElem( secondResultPrice ).getText();
        String results3 = findElem( thirdResultPrice ).getText();
        String results4 = findElem( forthResultPrice ).getText();
        results.add( results1 );
        results.add( results2 );
        results.add( results3 );
        results.add( results4 );
        for (String result : results) {
            result = result.substring( 1 );
            String s = result.replaceAll( ",", "" );
            double price = Double.parseDouble( s );
            arr.add( price );
        }
        System.out.println( arr );

        return arr;

    }


    public ArrayList<String> resultsNameStrings() {

        var arr = new ArrayList<String>();
        String first = findElem( firstResultName ).getText();
        String second = findElem( secondResultName ).getText();
        String third = findElem( thirdResultName ).getText();
        String forth = findElem( forthResultName ).getText();
        arr.add( first );
        arr.add( second );
        arr.add( third );
        arr.add( forth );

        return arr;
    }

    public void sortByDiscount() {

        findElem( sortByDiscountBtn ).click();
    }

    public void sortByPrice() {

        findElem( sortByPriceBtn ).click();
    }

    public ArrayList<Double> checkDiscountDifference() {
        var results = new ArrayList<String>();
        var arr = new ArrayList<Double>();
        String ap1 = findElem( firstResultActualPrice ).getText();
        String ap2 = findElem( secondResultActualPrice ).getText();
        String ap3 = findElem( thirdResultActualPrice ).getText();
        String ap4 = findElem( forthResultActualPrice ).getText();
        String pp1 = findElem( firstResultPreviousPrice ).getText();
        String pp2 = findElem( secondResultPreviousPrice ).getText();
        String pp3 = findElem( thirdResultPreviousPrice ).getText();
        String pp4 = findElem( forthResultPreviousPrice ).getText();

        results.add( ap1 );
        results.add( pp1 );
        results.add( ap2 );
        results.add( pp2 );
        results.add( ap3 );
        results.add( pp3 );
        results.add( ap4 );
        results.add( pp4 );

        for (String result : results) {
            result = result.substring( 1 );
            String s = result.replaceAll( ",", "" );
            double price = Double.parseDouble( s );
            arr.add( price );
        }
        double discountValue1 = arr.get( 1 ) - arr.get( 0 );
        double discountValue2 = arr.get( 3 ) - arr.get( 2 );
        double discountValue3 = arr.get( 5 ) - arr.get( 4 );
        double discountValue4 = arr.get( 7 ) - arr.get( 6 );
        arr.clear();
        arr.add( discountValue1 );
        arr.add( discountValue2 );
        arr.add( discountValue3 );
        arr.add( discountValue4 );

        return arr;
    }

    public ArrayList<Double> getAmountSaved() {

        var resultsAfterCleaning = new ArrayList<String>();
        var arr = new ArrayList<Double>();
        String as1 = findElem( firstAmountSaved ).getText();
        String as2 = findElem( secondAmountSaved ).getText();
        String as3 = findElem( thirdAmountSaved ).getText();
        String as4 = findElem( forthAmountSaved ).getText();
        as1 = as1.replaceAll( ",", "" );
        as2 = as2.replaceAll( ",", "" );
        as3 = as3.replaceAll( ",", "" );
        as4 = as4.replaceAll( ",", "" );

        resultsAfterCleaning.add( as1 +",");
        resultsAfterCleaning.add( as2  +",");
        resultsAfterCleaning.add( as3  +",");
        resultsAfterCleaning.add( as4 );

        StringBuilder resultStr = new StringBuilder();
        for (String result : resultsAfterCleaning) {
            for (int i = 0; i < result.length(); i++) {

                if (Character.isDigit( result.charAt( i ) )) {
                    resultStr.append( result.charAt( i ) );
                } else if (result.charAt( i ) == '.') {
                    resultStr.append( result.charAt( i ) );
                } else if (result.charAt( i ) == ',') {
                    resultStr.append( result.charAt( i ) );
                }


            }

        }
        String res = String.valueOf( resultStr );
        List<String> l1 = new ArrayList<>();
        l1.add( res );
        l1 = new ArrayList<>(Arrays.asList(res.split(",")));
        for (String curr:l1) {
            double price = Double.parseDouble(curr);
            arr.add( price );
        }

        return arr;
    }


}










