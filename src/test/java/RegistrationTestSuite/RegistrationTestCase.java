package RegistrationTestSuite;

import Pages.RegistrationPage;
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

public class RegistrationTestCase {

    private RegistrationPage rp;
    private WebDriver driver;
    private WebDriverWait wait;
    private ExcelUtils eu;


    public void registration(String firstName, String lastName,String email, String password, String birthYear) {
        rp.visitRegistrationPage();
        rp.clickSignIn();
        rp.clickRegister();
        rp.tryToRegister( firstName, lastName, email, password, birthYear );

    }

    @BeforeClass
    public void setUp(){
        driver = WebDriverUtils.createDriverObj( 2 );
        wait = new WebDriverWait(driver, Duration.ofSeconds( 5 ));
        rp = new RegistrationPage(driver,wait);
        eu = new ExcelUtils();
    }
    @DataProvider(name = "data-for-first-name-registration")
    private Object[][] dataForFirstNameRegistration(){
            return eu.initDataProvider( 0 ,0,1);
         }

    @DataProvider(name = "data-for-last-name-registration")
    private Object[][] dataForLastNameRegistration() {
        return eu.initDataProvider( 0,1,2 );
    }
    @DataProvider(name = "data-for-empty-email-registration")
    private Object[][] dataForEmptyEmailRegistration() {
        return eu.initDataProvider( 0 ,2,3);

    }
    @DataProvider(name = "data-for-only-spacial-characters-email-registration")
    private Object[][] dataForOnlySpacialCharsEmailRegistration() {
        return eu.initDataProvider( 0 ,3,4);

    }
    @DataProvider(name = "data-for-letters-and-spacial-characters-email-registration")
    private Object[][] dataForLettersAndSpacialCharsEmailRegistration() {
        return eu.initDataProvider( 0 ,4,5);

    }
    @DataProvider(name = "data-for-email-too-short-registration")
    private Object[][] dataForEmailTooShortRegistration() {
        return eu.initDataProvider( 0 ,5,8);

    }
    @DataProvider(name = "data-for-email-already-exist-registration")
    private Object[][] dataForEmailAlreadyExistRegistration() {
        return eu.initDataProvider( 0 ,8,9);

    }

    @DataProvider(name = "data-for-empty-password-registration")
    private Object[][] dataForEmptyPassWordRegistration() {
        return eu.initDataProvider( 0 ,9,10);

    }
    @DataProvider(name = "data-for-password-is-too-short-registration")
    private Object[][] dataForPassWordIsTooShortRegistration() {
        return eu.initDataProvider( 0 ,10,17);

    }

    @DataProvider(name = "data-for-password-is-too-simple-registration")
    private Object[][] dataForPassWordIsTooSimpleRegistration() {
        return eu.initDataProvider( 0 ,17,19);

    }

    @DataProvider(name =  "data-for-password-is-not supported-registration")
    private Object[][] dataForPassWordIsNotSupportedRegistration() {
        return eu.initDataProvider( 0 ,19,20);

    }

    @DataProvider(name =  "data-for-birth-year-is-missing-registration")
    private Object[][] dataForBirthYearIsMissing() {
        return eu.initDataProvider( 0 ,20,21);

    }

    @DataProvider(name =  "data-for-birth-year-is-too-low-registration")
    private Object[][] dataForBirthYearIsTooLow() {
        return eu.initDataProvider( 0 ,21,22);

    }

    @DataProvider(name = "data-for-birth-year-is-too-High-registration")
    private Object[][] dataForBirthYearIsTooHigh() {
        return eu.initDataProvider( 0 ,22,23);

    }

    @DataProvider(name =  "data-for-birth-year-is-NaN-registration")
    private Object[][] dataForBirthYearIsNaN() {
        return eu.initDataProvider( 0 ,23,24);

    }


    @Test(dataProvider = "data-for-first-name-registration" )
    public void registrationFirstName(String firstName, String lastName,String email, String password, String birthYear) {
       registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getFirstNameErrMsg(), "This is required." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-last-name-registration" )
    public void registrationLastName(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getLastNameErrMsg(), "This is required." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-empty-email-registration" )
    public void registrationEmptyEmail(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getEmailErrMsg(), "This is required." );
        rp.takeScreenShot();

    }

    @Test(dataProvider = "data-for-only-spacial-characters-email-registration" )
    public void registrationWithOnlySpacialCharsEmail(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getEmailErrMsg(), "Please use at least one letter in your username." );
        rp.takeScreenShot();

    }

    @Test(dataProvider ="data-for-letters-and-spacial-characters-email-registration" )
    public void registrationWithLettersAndSpacialCharsEmail(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getEmailErrMsg(), "You can only use letters, numbers, periods (‘.’), and underscores (‘_’) in your username." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-email-too-short-registration" )
    public void registrationEmailTooShort(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getEmailErrMsg(), "That email address is too short, please use a longer one." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-email-already-exist-registration" )
    public void registrationEmailAlreadyExist(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getEmailErrMsg(), "A Yahoo account already exists with this email address. Sign in." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-empty-password-registration" )
    public void registrationPassWordIsEmpty(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getPasswordErrMsg(), "This is required." );
        rp.takeScreenShot();
    }
    @Test(dataProvider ="data-for-password-is-too-short-registration" )
    public void registrationPassWordIsTooShort(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getPasswordErrMsg(), "Your password isn’t strong enough, try making it longer." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-password-is-too-simple-registration" )
    public void registrationPassWordIsTooSimple(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getPasswordErrMsg(), "Please create a stronger password, the one you submitted is too easy to guess." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-password-is-not supported-registration" )
    public void registrationPassWordIsNotSupported(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getPasswordErrMsg(), "Please use only letters, numbers, and common punctuation characters." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-birth-year-is-missing-registration" )
    public void registrationBirthYearIsMissing(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getBirthYearErrMsg(), "This is required.");
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-birth-year-is-too-low-registration" )
    public void registrationBirthYearIsTooLow(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getBirthYearErrMsg(), "That doesn’t look right, please re-enter your birthday." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-birth-year-is-too-High-registration" )
    public void registrationBirthYearIsTooHigh(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getBirthYearErrMsg(), "That doesn’t look right, please re-enter your birth year." );
        rp.takeScreenShot();
    }

    @Test(dataProvider ="data-for-birth-year-is-NaN-registration" )
    public void registrationBirthYearIsNaN(String firstName, String lastName,String email, String password, String birthYear) {
        registration( firstName, lastName, email, password, birthYear );
        Assert.assertEquals( rp.getBirthYearErrMsg(), "That doesn’t look right, please re-enter your birth year." );
        rp.takeScreenShot();
    }

    @AfterClass
    public void cleanUp(){
        driver.close();
    }

}
