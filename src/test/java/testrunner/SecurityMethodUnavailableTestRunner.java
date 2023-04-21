package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import setup.Setup;
import utils.Utils;

import java.util.ArrayList;

public class SecurityMethodUnavailableTestRunner extends Setup {
    Security security;
    Signup signup;
    Login login;
    Logout logout;
    SecurityMethodUnavailable securityMethodUnavailable;
    @Test(priority = 1, description = "Verify Security method unavailable? without select any issue")
    public void selctMethodWithoutIssue() throws InterruptedException {
        login= new Login(driver);
        securityMethodUnavailable= new SecurityMethodUnavailable(driver);
        driver.get(" https://exchange-tradex.nftarttoken.xyz/login");
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        login.doLogin("tanvirmitul048@mailinator.com","Tanvirmitul0-1997");
        login.btnLogin2.click();
        Thread.sleep(4000);
        security= new Security(driver);
        security.securityOpt.click();
        Thread.sleep(4000);
        Assert.assertEquals(security.securityTitle.getText(),"Security");
        Thread.sleep(1000);
        security.btnChange.click();
        Thread.sleep(1000);
        securityMethodUnavailable.secrtyMethdUnavlOpt.click();
        Thread.sleep(3000);
        ArrayList<String> windw= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windw.get(1));
        Thread.sleep(1000);
        security.btnContinue.click();
        Thread.sleep(1000);
        Assert.assertEquals(securityMethodUnavailable.selctIssuePopupMsg.getText(),"Please, select an issue");
        Thread.sleep(1000);
    }
    @Test(priority = 2, description = "Verify that user can't reset email address with blank data")
    public void restEmailBlankData() throws InterruptedException {
        signup= new Signup(driver);
        signup.checkBox.click();
        security=new Security(driver);
        Thread.sleep(2000);
        security.btnContinue.click();
        Thread.sleep(4000);
        Utils.doScroll4(driver);
        Thread.sleep(2000);
        securityMethodUnavailable.btnReset.click();
        Thread.sleep(500);
        Assert.assertEquals(securityMethodUnavailable.newEmailValErrMsg.getText(),"New Email is required");
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");

    }
    @Test(priority = 3, description = "Verify reset email address with invalid email")
    public void resetEmailWithInvalEmail() throws InterruptedException {
        login= new Login(driver);
        securityMethodUnavailable= new SecurityMethodUnavailable(driver);
        signup= new Signup(driver);
        login.txtEmail.sendKeys("tanvirmitul.com");
        Thread.sleep(500);
        securityMethodUnavailable.btnReset.click();
        Thread.sleep(1000);
        Assert.assertEquals(login.txtEmail.getAttribute("validationMessage"),"Please include an '@' in the email address. 'tanvirmitul.com' is missing an '@'.");
        Thread.sleep(1000);
    }
    @Test(priority = 4, description = "Verify reset email address with invalid email and invalid verification code")
    public void resetEmailInvalEmailVeriCode() throws InterruptedException {
        signup= new Signup(driver);
        securityMethodUnavailable= new SecurityMethodUnavailable(driver);
        signup.txtVeriCode.sendKeys("123456");
        securityMethodUnavailable.btnReset.click();
        Thread.sleep(1000);
        Assert.assertEquals(login.txtEmail.getAttribute("validationMessage"),"Please include an '@' in the email address. 'tanvirmitul.com' is missing an '@'.");
        Thread.sleep(1000);
    }
    @Test(priority = 5, description = "Verify reset email address with valid email and invalid verification code")
    public void resetEmailOldEmailInvalVeriCode() throws InterruptedException {
        signup= new Signup(driver);
        securityMethodUnavailable= new SecurityMethodUnavailable(driver);
        login= new Login(driver);
        login.txtEmail.clear();
        login.txtEmail.sendKeys("tanvirmitul048@mailinator.com");
        Thread.sleep(500);
        securityMethodUnavailable.btnReset.click();
        Thread.sleep(2000);
        Assert.assertEquals(securityMethodUnavailable.invalSecurityPopupMsg.getText(),"User already exists usings this email");
        Thread.sleep(1000);
    }
}
