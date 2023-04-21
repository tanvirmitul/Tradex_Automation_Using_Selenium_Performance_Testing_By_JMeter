package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Security {
    @FindBy(xpath = "//a[contains(text(),'Security')]")
    public WebElement securityOpt;
    @FindBy(xpath = "(//*[contains(text(),'Security')])[9]")
    public WebElement securityTitle;
    @FindBy(xpath = "//button[contains(text(),'Enable')]")
    public WebElement btnEnable;
    @FindBy(xpath = "(//button[contains(text(),'Enable')])[2]")
    public WebElement btnEnable2;
    @FindBy(xpath = "(//button[contains(text(),'Enable')])[3]")
    public WebElement btnEnable3;
    @FindBy(xpath = "//button[normalize-space()='Next']")
    public WebElement btnNext;
    @FindBy(xpath = "//div[contains(text(),'Authentication Code is required')]")
    public WebElement valErrAuthCode;
    @FindBy(name = "code")
    public WebElement txtAuthenCode;
    @FindBy(xpath = "//div[contains(text(),'Invalid OTP code')]")
    public WebElement invalOtpPopupMsg;
    @FindBy(xpath = "//a[normalize-space()='Security']")
    public WebElement securityOpt2;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement btnContinue;
    @FindBy(xpath = "(//button[contains(text(),'Change')])[2]")
    public WebElement btnContinue2;
    @FindBy(xpath = "//button[@class='Modal_close__qRRpj']")
    public WebElement btncross;
    @FindBy(xpath = "//div[normalize-space()='Old password is required']")
    public WebElement oldPassReqValidErrMsg;
    @FindBy(xpath = "//div[normalize-space()='New password is required']")
    public WebElement newPassReqValidErrMsg;
    @FindBy(xpath = "//div[contains(text(),'Confirm Password is required')]")
    public WebElement confirmPassReqValidErrMsg;
    @FindBy(name = "old_password")
    public WebElement txtOldPassword;
    @FindBy(name = "new_password")
    public WebElement txtNewPassword;
    @FindBy(name = "password_confirm")
    public WebElement txtConfirmPassword;
    @FindBy(xpath = "(//div[contains(text(),'Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character')])[2]")
    public WebElement confirmPassValErrMsg;
    @FindBy(xpath = "(//div[contains(text(),'Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character')])[2]")
    public WebElement newPassValErrMsg;
    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement btnCreate;
    @FindBy(xpath = "//div[contains(text(),'New anti-phishing code is required')]")
    public WebElement antiphisValErrMsg;
    @FindBy(name = "new_anti_phishing_code")
    public WebElement txtAntiphisCode;
    @FindBy(xpath = "//div[normalize-space()='Code must be between 6-20 characters']")
    public WebElement antiphisValErrMsg2;
    @FindBy(xpath = "(//button[contains(normalize-space(),'Create')])[2]")
    public WebElement btnCreate2;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    public WebElement btnAdd;
    @FindBy(xpath = "//button[normalize-space()='Remove']")
    public WebElement btnRemove;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    public WebElement btnSave;
    @FindBy(xpath = "//div[contains(text(),'Question is required')]")
    public WebElement qstnReqValErrMsg;
    @FindBy(xpath = "//div[contains(text(),'Answer is required')]")
    public WebElement ansReqValErrMsg;
    @FindBy(xpath = "//div[contains(text(),'Your min question limit is 1')]")
    public WebElement quesLimitPopupMsg;
    @FindBy(name = "answer_key0")
    public WebElement txtAnswer;
    @FindBy(xpath = "//div[@aria-hidden='true']")
    public WebElement btnQstnSelect;
    @FindBy(xpath = "//div[contains(text(),'Select..')]")
    public WebElement txtQstnSelect;
    @FindBy(xpath = "//div[contains(text(),'In what city were you born?')]")
    public WebElement qstn1;
    @FindBy(xpath = "//button[contains(text(),'Change')]")
    public WebElement btnChange;
    @FindBy(xpath = "//button[normalize-space()='More']")
    public WebElement btnMore;
    @FindBy(xpath = "//div[normalize-space()='Email is required']")
    public WebElement emailValErrMsg;
    @FindBy(xpath = "(//div[contains(text(),'Verification Code is Required')])[2]")
    public WebElement veriValErrMsg2;
    @FindBy(xpath = "//li[contains(.,'Security Activity')]")
    public WebElement btnSecurityActivity;
    @FindBy(className = "css-qc6sy-singleValue")
    public WebElement drpdwnActivities;
    @FindBy(xpath = "//button[normalize-space()='Manage']")
    public WebElement btnManage;
    @FindBy(xpath = "//button[normalize-space()='Logout & Remove Other Devices']")
    public WebElement btnLogoutDevice;
    @FindBy(xpath = "(//button[normalize-space()='Logout'])[30]")
    public WebElement btnLogout2;
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    public WebElement btnCancel;
    public Security(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
