package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
    @FindBy(xpath = "//button[normalize-space()='Forgot password?']")
    public WebElement forgotPassOpt;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement btnConfirm;
    @FindBy(xpath = "//div[contains(text(),'invalid email address')]")
    public WebElement invalEmailErrMsg;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement btnContinue;
    @FindBy(xpath = "//div[contains(text(),'No user found')]")
    public WebElement NoUserFoundPopupMsg;
    @FindBy(name = "code")
    public WebElement txtVerificCode;
    public ForgotPassword(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
