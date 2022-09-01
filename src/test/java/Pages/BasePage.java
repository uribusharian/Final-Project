package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    public final WebDriver driver;
    private final WebDriverWait wait;
    private int counter=1;
    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void waitUntilVisibilityElementLocated(By locator) {
        wait.until( ExpectedConditions.visibilityOfElementLocated( locator ) );
    }

    public void waitUntilPresenceOfElementLocated(By locator) {
        wait.until( ExpectedConditions.presenceOfElementLocated( locator ) );
    }

    public WebElement findElem(By locator) {
        return driver.findElement( locator );
    }


    public List<WebElement> findElems(By locator) {
        return driver.findElements( locator );
    }


    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return driver.findElement( locator ).getText();
    }

    //--------------------------------------------------
    // adding ability to concatenate a few methods on a web element e.g:
    // 		typeInto("hello", By.cssSelector("[firstName=\"q\"]")).click();
    public WebElement typeInto(String inputText, By locator) {
        findElem( locator ).sendKeys( inputText );
        return findElem( locator );
    }

    public WebElement click(By locator) {
        findElem( locator ).click();
        return findElem( locator );
    }

    //--------------------------------------------------

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement( locator ).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //--------------------------------------------------

    /*
     <select>
         <option value="paris"> Paris the beautiful city </option>
         <option value="nyc"> New York the big apple </option>
         <option value="vienna"> Vienna the great place to visit </option>
    </select>
    */
    public void selectFromDropDownListByValue(By locator, String value) {
        Select select = new Select( driver.findElement( locator ) );
        select.selectByValue( value );
    }

    public void selectFromDropDownListByVisibleText(By locator, String text) {
        Select select = new Select( driver.findElement( locator ) );
        select.selectByVisibleText( text );
    }


    public void selectFromDropDownListByIndex(By locator, int indx) {
        Select select = new Select( driver.findElement( locator ) );
        select.selectByIndex( indx );
    }
    //--------------------------------------------------

    public void visit(String url) {
        driver.get( url );
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 5, TimeUnit.SECONDS );
    }
    //--------------------------------------------------



    public void takeScreenShot(){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs( OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("./ScreenShots/Screenshot"+ counter + ".png"));
            counter++;
        } catch (IOException e) {
            System.out.println( e.getMessage() );
        }
    }
}
