package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationExercisePage {
    public AutomationExercisePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    public WebElement signupLoginButonu;

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement newUserSignupYazisi;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signupNameKutusu;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signupEmailKutusu;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signupButonu;

    @FindBy(id = "id_gender1")
    public WebElement genderMale;

    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreatedYazisi;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailKutusu;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement loginPasswordKutusu;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButonu;

    @FindBy(xpath = "//i[@class='fa fa-user']/parent::a")
    public WebElement loggedInAsYazisi;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginHataMesaji;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButonu;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy(id = "submit_search")
    public WebElement aramaButonu;

    @FindBy(xpath = "//a[@data-product-id='1']")
    public WebElement ilkUrunAddToCart;

    @FindBy(xpath = "//u[text()='View Cart']")
    public WebElement viewCartLinki;

    @FindBy(xpath = "//td[@class='cart_description']//a")
    public WebElement sepettekiUrunIsmi;

    @FindBy(xpath = "//*[@id=\"dismiss-button\"]/div/svg/path[1]")
    public WebElement close_vignette;





}
