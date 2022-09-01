package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SearchPage extends BasePage {

    // Constructors
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super( driver, wait );
    }

    // Fields
    By searchBar = By.cssSelector( "[id=\"ybar-sbq\"]" );
    By searchBtn = By.cssSelector( "[id=\"ybar-search\"]" );
    By resultsLoc = By.cssSelector( "[class=\"compTitle fc-smoke\"]>h2>span" );
    By firstNonAdResult = By.cssSelector( "[class=\" reg searchCenterMiddle\"]>:first-child>:first-child>:first-child>h3>a" );
    By secondNonAdResult = By.cssSelector( "[class=\" reg searchCenterMiddle\"]>:nth-child(3)>:first-child>:first-child>h3>a" );
    By thirdNonAdResult = By.cssSelector( "[class=\" reg searchCenterMiddle\"]>:nth-child(4)>:first-child>:first-child>h3>a" );
    By forthNonAdResult = By.cssSelector( "[class=\" reg searchCenterMiddle\"]>:nth-child(5)>:first-child>:first-child>h3>a" );
    By fifthNonAdResult = By.cssSelector( "[class=\" reg searchCenterMiddle\"]>:nth-child(6)>:first-child>:first-child>h3>a" );



    // Methods

    public void visitSearchPage()
    {
        visit( "https://www.yahoo.com/" );
    }

    public void searchTerm(String theTerm) {
        findElem( searchBar ).sendKeys( theTerm );
        findElem( searchBtn ).click();
    }


    public int printResultNumber() {
        String results = findElem( resultsLoc ).getText();
        int resultNumber = 0;
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < results.length(); i++) {
            if (Character.isDigit( results.charAt( i ) )) {
                resultStr.append( (results.charAt( i )) );

            }
        }
        resultNumber = Integer.parseInt( resultStr.toString() );
        return resultNumber;
    }

    public ArrayList<String> nonAdsResultStrings() {
        ArrayList<String> arr = new ArrayList<String>();
        String first = findElem( firstNonAdResult ).getText();
        String second = findElem( secondNonAdResult ).getText();
        String third = findElem( thirdNonAdResult ).getText();
        String forth = findElem( forthNonAdResult ).getText();
        String fifth = findElem( fifthNonAdResult ).getText();
        arr.add( first );
        arr.add( second );
        arr.add( third );
        arr.add( forth );
        arr.add( fifth );
        return arr;
    }

}

