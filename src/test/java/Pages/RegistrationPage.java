package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

    // the home page URL
    String baseURL = "https://www.yahoo.com/";

    // constructor
    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        super( driver, wait );
    }


    //  Fields (locators)
    By signInBtn = By.cssSelector( "[href=\"https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin\"]" );
    By createAccountBtn = By.cssSelector( "[id=\"createacc\"]" );
    By firstName = By.cssSelector(  "[id=\"usernamereg-firstName\"]");
    By lastName = By.cssSelector(  "[id=\"usernamereg-lastName\"]");
    By email = By.cssSelector( "[name=\"userId\"]" );
    By password = By.cssSelector( "[id=\"usernamereg-password\"]" );
    By birthYear = By.cssSelector( "[name=\"birthYear\"]" );
    By submit = By.cssSelector( "[id=\"reg-submit-button\"]" );
    By regFirstNameErr = By.cssSelector( "[id=\"reg-error-firstName\"]");
    By regLastNameErr = By.cssSelector("[id=\"reg-error-lastName\"]");
    By regEmailErr = By.cssSelector(  "[id=\"reg-error-userId\"]");
    By regPasswordErr = By.cssSelector(  "[id=\"reg-error-password\"]");
    By regBirthYearErr = By.cssSelector(  "[id=\"reg-error-birthYear\"]");

    // Methods
    public void visitRegistrationPage() {

        super.visit( baseURL );
    }

    public void clickSignIn() {

       findElem( signInBtn ).click();
    }

    public void clickRegister() {
           findElem( createAccountBtn ).click();

    }




    public void tryToRegister ( String firstNameKeys,String lastNameKeys, String emailKeys, String passwordKeys,String birthYearKeys){

        findElem( firstName ).sendKeys(firstNameKeys );
        findElem( lastName ).sendKeys(lastNameKeys  );
        findElem( email ).sendKeys(emailKeys  );
        findElem( password ).sendKeys(passwordKeys  );
        findElem( birthYear ).sendKeys(birthYearKeys  );
        findElem( submit ).click();
    }

    public String getFirstNameErrMsg() {

        waitUntilPresenceOfElementLocated( regFirstNameErr );
        String errMsg = findElem(regFirstNameErr).getText();
        System.out.println(errMsg);
        return errMsg ;

    }
    public String getLastNameErrMsg() {

        waitUntilPresenceOfElementLocated( regLastNameErr );
        String errMsg = findElem(regLastNameErr  ).getText();
        System.out.println(errMsg);
        return errMsg ;

    }
    public String getEmailErrMsg() {

        waitUntilPresenceOfElementLocated( regEmailErr );
        String errMsg = findElem(regEmailErr  ).getText();

        return errMsg ;

    }
    public String getPasswordErrMsg() {

        waitUntilPresenceOfElementLocated( regPasswordErr );
        String errMsg = findElem(regPasswordErr  ).getText();

        return errMsg ;

    }
    public String getBirthYearErrMsg() {

        waitUntilPresenceOfElementLocated( regBirthYearErr );
        String errMsg = findElem(regBirthYearErr  ).getText();

        return errMsg ;

    }


}