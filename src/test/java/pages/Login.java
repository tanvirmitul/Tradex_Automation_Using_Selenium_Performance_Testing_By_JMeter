package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    @FindBy(xpath = "//a[contains(normalize-space(),'Login')]")
    public WebElement btnLogin;
    @FindBy(name = "email")
    public WebElement txtEmail;
    @FindBy(name = "password")
    public WebElement txtPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement btnLogin2;
    @FindBy(xpath = "//h3[normalize-space()='Login']")
    public WebElement titleLogin;
    @FindBy(xpath = "//div[contains(text(),'Invalid password')]")
    public WebElement valErrPopupMsg;
    @FindBy(xpath = "//div[contains(text(),'User not found!')]")
    public WebElement userNotFoundPopupMsg;
    @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
    public WebElement dashboardTitle;

    @FindBy(xpath = "//div[contains(text(),'Logged in successfully')]")
    public WebElement logSuccessPopupMsg;
    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }
}
