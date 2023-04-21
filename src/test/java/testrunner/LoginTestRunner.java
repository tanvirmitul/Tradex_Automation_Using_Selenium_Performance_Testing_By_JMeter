package testrunner;

import lombok.extern.java.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Login;
import pages.Signup;
import setup.Setup;
import utils.Utils;

public class LoginTestRunner extends Setup {
    Login login;
    Signup signup;

    @Test(priority = 1, description = "Verify user login with valid email  and invalid password")
    public void invalPassword() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        login= new Login(driver);
        signup=new Signup(driver);
        login.btnLogin.click();
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        String titleLogin= login.titleLogin.getText();
        Assert.assertEquals(titleLogin,"Login");
        Thread.sleep(1000);
        login.doLogin("tanvirmitul048@mailinator.com"," Tanvirmitul0-");
        login.btnLogin2.click();
        Thread.sleep(2000);
        String popupPassErr=login.valErrPopupMsg.getText();
        Assert.assertEquals(popupPassErr,"Invalid password");
        Thread.sleep(1000);
    }
    @Test(priority = 2, description = "Verify user login with invalid email.")
    public void invalEmail() throws InterruptedException {
        login= new Login(driver);
        signup= new Signup(driver);
        login.txtEmail.clear();
        Thread.sleep(1000);
        login.txtPassword.clear();
        Thread.sleep(500);
        login.doLogin(" tanvirmitulgmail.com","Tanvirmitul0-1997");
        Thread.sleep(1000);
        String invalEmailErrorMsg=signup.invalEmailErrorMsg.getText();
        Assert.assertEquals(invalEmailErrorMsg,"invalid email address");
        Thread.sleep(1000);
        Assert.assertFalse(login.btnLogin2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 3, description = "Verify user login with invalid credentials")
    public void invalCreds() throws InterruptedException {
        login= new Login(driver);
        signup= new Signup(driver);
        login.txtEmail.clear();
        Thread.sleep(500);
        login.txtPassword.clear();
        Thread.sleep(500);
        login.doLogin(" tanvirmitulgmail.com","tanvirmitul0-");
        Thread.sleep(1000);
        String invalEmailErrorMsg=signup.invalEmailErrorMsg.getText();
        Assert.assertEquals(invalEmailErrorMsg,"invalid email address");
        Thread.sleep(500);
        String passError=signup.passValidError.getText();
        Assert.assertEquals(passError,"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Thread.sleep(500);
    }
    @Test(priority = 4, description = "Verify user login with valid non-registered user")
    public void nonRegUser() throws InterruptedException {
        login= new Login(driver);
        signup= new Signup(driver);
        login.txtEmail.clear();
        Thread.sleep(500);
        login.txtPassword.clear();
        Thread.sleep(500);
        login.doLogin("tanvirmitul@gmail.com","Tanvirmitul0-1996");
        Thread.sleep(1000);
        login.btnLogin2.click();
        Thread.sleep(2000);
        String userNotFoundPopupMsg= login.userNotFoundPopupMsg.getText();
        Assert.assertEquals(userNotFoundPopupMsg,"User not found!");
        Thread.sleep(1000);
    }
    @Test(priority = 5, description = "User can successfully login with valid credentials.")
    public void login() throws InterruptedException {
        login= new Login(driver);
        login.txtEmail.clear();
        Thread.sleep(500);
        login.txtPassword.clear();
        Thread.sleep(500);
        login.doLogin("tanvirmitul048@mailinator.com","Tanvirmitul0-1997");
        Thread.sleep(1000);
        login.btnLogin2.click();
        Thread.sleep(2000);
        String logSuccessPopupmsg= login.logSuccessPopupMsg.getText();
        Assert.assertEquals(logSuccessPopupmsg,"Logged in successfully");
        Thread.sleep(4000);
        Assert.assertEquals(login.dashboardTitle.getText(),"Dashboard");
        Thread.sleep(1000);
    }
}
