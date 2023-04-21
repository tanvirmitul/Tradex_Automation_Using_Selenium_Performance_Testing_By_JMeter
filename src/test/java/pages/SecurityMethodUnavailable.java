package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityMethodUnavailable {
    @FindBy(xpath = "//a[normalize-space()='Security method unavailable?']")
    public WebElement secrtyMethdUnavlOpt;
    @FindBy(xpath = "//span[normalize-space()='Please, select an issue']")
    public WebElement selctIssuePopupMsg;
    @FindBy(xpath = "//div[contains(text(),'User already exists usings this email')]")
    public WebElement invalSecurityPopupMsg;
    @FindBy(xpath = "//div[normalize-space()='New Email is required']")
    public WebElement newEmailValErrMsg;
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    public WebElement btnReset;
    public SecurityMethodUnavailable(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
