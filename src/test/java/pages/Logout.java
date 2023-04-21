package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    @FindBy(xpath = "//img[@alt='User Avatar']")
    public WebElement profileIcon;
    @FindBy(xpath = "//div[contains(text(),'Log Out')]")
    public WebElement logoutOpt;
    @FindBy(xpath = "//div[contains(text(),'Logout Successful!')]")
    public WebElement logoutSuccessPopupMsg;
    public Logout(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

}
