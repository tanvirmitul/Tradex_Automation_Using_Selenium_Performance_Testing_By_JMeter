package testrunner;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import pages.Signup;
import setup.Setup;
import utils.Utils;

public class ForgotPasswordTestRunner extends Setup {
    ForgotPassword forgotPassword;
    Login login;
    Signup signup;
    @BeforeTest
    public void visitpage() throws InterruptedException {
        driver.get(" https://exchange-tradex.nftarttoken.xyz/login");
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);

    }
    @Test(priority = 1, description = "Verify forgot password with invalid email")
    public void invalEmail() throws InterruptedException {
     forgotPassword= new ForgotPassword(driver);
     login= new Login(driver);
     signup= new Signup(driver);
     forgotPassword.forgotPassOpt.click();
     Thread.sleep(1000);
     forgotPassword.btnConfirm.click();
     Thread.sleep(3000);
     login.txtEmail.sendKeys("tanvir.com");
     Thread.sleep(2000);
     Assert.assertEquals(forgotPassword.invalEmailErrMsg.getText(),"invalid email address");
     Thread.sleep(1000);
    }
    @Test(priority = 2, description = "Verify forgot password with non-registered email")
    public void nonRegEmail() throws InterruptedException {
        login= new Login(driver);
        login.txtEmail.clear();
        Thread.sleep(500);
        login.txtEmail.sendKeys("tanvir@gmail.com");
        forgotPassword.btnContinue.click();
        Thread.sleep(2000);
        Assert.assertEquals(forgotPassword.NoUserFoundPopupMsg.getText(),"No user found");
        Thread.sleep(1000);
    }
    @Test(priority = 3, description = "Verify forgot password without providing any data")
    public void blankData() throws InterruptedException {
        login= new Login(driver);
        login.txtEmail.clear();
        Thread.sleep(500);
        login.txtEmail.sendKeys("tanvirmitul048@mailinator.com");
        forgotPassword.btnContinue.click();
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        forgotPassword.btnContinue.click();
        Thread.sleep(1000);
        String msg= forgotPassword.txtVerificCode.getAttribute("validationMessage");
        Assert.assertEquals(msg,"Please fill out this field.");
        Thread.sleep(1000);
    }
    @Test(priority = 4, description = "Verify forgot password with invalid verification code, valid new password,confirm password")
    public void invalCodePass() throws InterruptedException {
        signup=new Signup(driver);
        forgotPassword.txtVerificCode.sendKeys("123456");
        signup.txtPassword.sendKeys("Tanvirmitul0-1997");
        signup.txtConfirmPassword.sendKeys("Tanvirmitul0-1997");
        forgotPassword.btnContinue.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.valErrPopupMsg.getText(),"Invalid code or expired");
        Thread.sleep(1000);
    }
    @Test(priority = 5, description = "Verify forgot password with invalid verification code, valid new password,invalid confirm password")
    public void invalConfrimPassVeriCode() throws InterruptedException {
        forgotPassword= new ForgotPassword(driver);
        signup= new Signup(driver);
        signup.txtConfirmPassword.clear();
        Thread.sleep(1000);
        signup.txtConfirmPassword.sendKeys("Tanvirmitul0-");
        forgotPassword.btnContinue.click();
        Thread.sleep(1000);
        Assert.assertEquals(signup.confirmPassError.getText(),"Passwords do not match");
        Thread.sleep(1000);

    }
}
