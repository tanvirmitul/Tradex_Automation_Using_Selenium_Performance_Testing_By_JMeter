package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {

    @FindBy(xpath = "//a[normalize-space()='Sign Up']")
    public WebElement btnSignup;
    @FindBy(className = "Form_title__BLS66")
    public WebElement signupTitle;
    @FindBy(name = "email")
    WebElement txtEmail;
    @FindBy(name = "password")
    public WebElement txtPassword;
    @FindBy(name = "password_confirm")
    public WebElement txtConfirmPassword;
    @FindBy(name = "referral_code")
    public WebElement txtReferralCode;
    @FindBy(className = "Checkbox_tick__UL5OD")
    public WebElement checkBox;
    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    public WebElement btnSignup2;
    @FindBy(className = "SignIn_title__wEwdB")
    public WebElement verificTitle;
    @FindBy(className = "CodeVerificationInput_getCodeButton__smS8K")
    public WebElement btnGetcode;
    @FindBy(css = "[role=\"status\"]")
    public WebElement emailAlreadyUsedPopup;
    @FindBy(className = "go2072408551")
    public WebElement emailSentSuccessfulPopup;
    @FindBy(xpath = "//div[contains(text(),'Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character')]")
    public WebElement passValidError;
    @FindBy(xpath = "//div[normalize-space()='Passwords do not match']")
    public WebElement confirmPassError;
    @FindBy(xpath = "//div[normalize-space()='Must be 15 characters or less']")
    public WebElement refIdErrorMsg;
    @FindBy(xpath = "//div[normalize-space()='invalid email address']")
    public WebElement invalEmailErrorMsg;
    @FindBy(xpath = "//button[normalize-space()='Verify Code']")
    public WebElement btnVerifyCode;
    @FindBy(xpath = "//div[contains(text(),'Verification Code is Required')]")
    public WebElement validVeriErrorMsg;
    @FindBy(xpath = "//div[contains(text(),'Invalid code or expired')]")
    public WebElement valErrPopupMsg;
    @FindBy(name = "email_verify_code")
    public WebElement txtVeriCode;
    public Signup(WebDriver driver){
    PageFactory.initElements(driver,this);
}

public void doSignup(String email, String password, String confirmPassword) throws InterruptedException {

        Thread.sleep(2000);
        txtEmail.sendKeys(email);
        Thread.sleep(500);
        txtPassword.sendKeys(password);
        Thread.sleep(500);
        txtConfirmPassword.sendKeys(confirmPassword);
        Thread.sleep(500);

}
}
