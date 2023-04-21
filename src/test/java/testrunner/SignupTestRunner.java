package testrunner;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Signup;
import setup.Setup;
import utils.Utils;

public class SignupTestRunner extends Setup {

    @Test (priority = 1, description = " User can successfully send the verification code to email with valid credentials")
    public void signup() throws InterruptedException {
//        driver.switchTo().newWindow(WindowType.TAB);
//        Thread.sleep(5000);
//        driver.get("https://mail.google.com/mail/u/1/?ogbl#inbox");
//        gmail.txtEmail.sendKeys("tanvirhmitul97@gmail.com");
//        gmail.btnNext.click();
//        Thread.sleep(1000);
//        gmail.txtPassword.sendKeys("tanvirmitul0-1997");
//        gmail.btnNext.click();
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testauto180@mailinator.com","Tanvirmitul0-1997","Tanvirmitul0-1997");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        signup.checkBox.click();
        Thread.sleep(500);
        signup.btnSignup2.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.verificTitle.getText(),"Sign Up Verification");
        Thread.sleep(2000);
        signup.btnGetcode.click();
        Thread.sleep(1000);
        String text=signup.emailSentSuccessfulPopup.getText();
        System.out.println(text);
        Thread.sleep(2000);
        Assert.assertEquals(text,"Email sent successfully");
        Thread.sleep(2000);
    }
    @Test(priority = 2,description = "Check that user can't register without clicking on signing up condition check box.")
    public void withoutClickCheckbox() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup("testauto181@mailinator.com","Tanvirmitul0-1997","Tanvirmitul0-1997");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 3, description = "Verify that user can't register with registered email.")
    public void signupRegisteredEmail() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testautomation060@mailinator.com","Tanvirmitul0-1997","Tanvirmitul0-1997");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        signup.checkBox.click();
        Thread.sleep(500);
        signup.btnSignup2.click();
        Thread.sleep(3000);
        String text=signup.emailAlreadyUsedPopup.getText();
        Thread.sleep(2000);
        Assert.assertEquals(text,"Email already used.");
        Thread.sleep(1000);
//        driver.close();

    }
    @Test(priority = 4, description = "Verify user registration with invalid password & confirm password.")
    public void invalidPassConfirmPass() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testautomation060@mailinator.com"," hossainmitul12345","hossainmitul12345");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        String passError=signup.passValidError.getText();
        String confirmPassError=signup.confirmPassError.getText();
        Assert.assertEquals(passError,"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Thread.sleep(500);
        Assert.assertEquals(confirmPassError,"Passwords do not match");
        Thread.sleep(500);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 5, description = "Verify user registration with invalid referral id.")
    public void invalRefId() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testautomation060@mailinator.com","Tanvirmitul0-1996","Tanvirmitul0-1996");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(1000);
        signup.txtReferralCode.sendKeys("123hosain45454ffgggg");
        Thread.sleep(500);
        String refError=signup.refIdErrorMsg.getText();
        Assert.assertEquals(refError,"Must be 15 characters or less");
        Thread.sleep(500);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 6, description = "Verify user registration with invalid email id")
    public void invalEmail() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup("tanvirmitul.com","Tanvirmitul0-1996","Tanvirmitul0-1996");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(1000);
        String invalEmailErrorMsg=signup.invalEmailErrorMsg.getText();
        Assert.assertEquals(invalEmailErrorMsg,"invalid email address");
        Thread.sleep(500);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 7, description = "Verify user registration with all invalid credentials.")
    public void allInvalCred() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup("tanvirmitul.com"," tanvirmitul"," Tanvirmitul");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(1000);
        signup.txtReferralCode.sendKeys("gfdgdgdfggdfdfdgg");
        String invalEmailErrorMsg=signup.invalEmailErrorMsg.getText();
        Assert.assertEquals(invalEmailErrorMsg,"invalid email address");
        Thread.sleep(500);
        String passError=signup.passValidError.getText();
        String confirmPassError=signup.confirmPassError.getText();
        Assert.assertEquals(passError,"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Thread.sleep(500);
        Assert.assertEquals(confirmPassError,"Passwords do not match");
        Thread.sleep(500);
        String refError=signup.refIdErrorMsg.getText();
        Assert.assertEquals(refError,"Must be 15 characters or less");
        Thread.sleep(500);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority =8, description = "Verify user registration without any data")
    public void blankData() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        Assert.assertFalse(signup.btnSignup2.isEnabled());
        Thread.sleep(1000);
    }
    @Test(priority = 9, description ="Verify user registration without verification code" )
    public void blankVeriCode() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testauto182@mailinator.com","Tanvirmitul0-1997","Tanvirmitul0-1997");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        signup.checkBox.click();
        Thread.sleep(500);
        signup.btnSignup2.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.verificTitle.getText(),"Sign Up Verification");
        Thread.sleep(2000);
        signup.btnVerifyCode.click();
        Thread.sleep(500);
        String validVerErrMsg=signup.validVeriErrorMsg.getText();
        Assert.assertEquals(validVerErrMsg,"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 10, description = "Verify user registration with invalid verification code")
    public void invalVericode() throws InterruptedException {
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        Signup signup= new Signup(driver);
        signup.btnSignup.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.signupTitle.getText(),"Sign Up");
        Thread.sleep(500);
        signup.doSignup(" testauto183@mailinator.com","Tanvirmitul0-1997","Tanvirmitul0-1997");
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        signup.checkBox.click();
        Thread.sleep(500);
        signup.btnSignup2.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.verificTitle.getText(),"Sign Up Verification");
        Thread.sleep(2000);
        signup.btnVerifyCode.click();
        Thread.sleep(500);
        String validVerErrMsg=signup.validVeriErrorMsg.getText();
        Assert.assertEquals(validVerErrMsg,"Verification Code is Required");
        Thread.sleep(1000);
        signup.txtVeriCode.sendKeys("123456");
        signup.btnVerifyCode.click();
        Thread.sleep(1000);
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);

    }
}
