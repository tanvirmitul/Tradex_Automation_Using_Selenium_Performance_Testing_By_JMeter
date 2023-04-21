package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.Logout;
import pages.Security;
import pages.Signup;
import setup.Setup;
import utils.Utils;

public class SecurityTestRunner extends Setup {
    Security security;
    Signup signup;
    Login login;
    Logout logout;
    @Test(priority = 1, description = "Verify google authenticator without any verification code")
    public void googleAuthenticBlankData() throws InterruptedException {
        login= new Login(driver);
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
        security.btnEnable.click();
        Thread.sleep(2000);
        security.btnNext.click();
        Thread.sleep(2000);
        Utils.doScroll2(driver);
        Thread.sleep(2000);
        for(int i=1;i<=3;i++){
            security.btnNext.click();
            Thread.sleep(2000);
        }
        Assert.assertEquals(security.valErrAuthCode.getText(),"Authentication Code is required");
        Thread.sleep(1000);
    }
    @Test(priority = 2, description = "Verify google authenticator with invalid verification code")
    public void googleAuthenInvalVeriCode() throws InterruptedException {
        logout=new Logout(driver);
        security= new Security(driver);
        security.txtAuthenCode.sendKeys("123456");
        security.btnNext.click();
        Thread.sleep(2000);
        Assert.assertEquals(security.invalOtpPopupMsg.getText(),"Invalid OTP code");
        Thread.sleep(6000);
        logout.profileIcon.click();
        Thread.sleep(1000);
        logout.logoutOpt.click();
        Thread.sleep(4000);
    }
    @Test(priority = 3, description = "Verify Login 2FA without any verification code")
    public void login2FWithoutVeriCode() throws InterruptedException {
        security=new Security(driver);
        signup= new Signup(driver);
        login= new Login(driver);
        logout=new Logout(driver);
        Thread.sleep(3000);
        driver.get(" https://exchange-tradex.nftarttoken.xyz/login");
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        login.doLogin("tanvirmitul048@mailinator.com","Tanvirmitul0-1997");
        login.btnLogin2.click();
        Thread.sleep(4000);
        security.securityOpt.click();
        Thread.sleep(3000);
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnEnable2.click();
        Thread.sleep(1000);
        security.btnContinue.click();
        Thread.sleep(1000);
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 4, description = "Verify Login 2FA with invalid verification code")
    public void login2FAInvalVeriCode() throws InterruptedException {
      security= new Security(driver);
      signup= new Signup(driver);
        signup.txtVeriCode.sendKeys("123456");
        security.btnContinue.click();
        Thread.sleep(1000);
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);
        security.btncross.click();
        Thread.sleep(3000);

    }
    @Test(priority = 5, description = "Verify Device Verification without any verification code")
    public void deviceVeriBlankCode() throws InterruptedException {
      security.btnEnable3.click();
        Thread.sleep(1000);
        security.btnContinue.click();
        Thread.sleep(1000);
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 6, description = "Verify Device Verification with invalid verification code")
    public void deviceVeriInvalCode() throws InterruptedException {
        signup.txtVeriCode.sendKeys("123456");
        security.btnContinue.click();
        Thread.sleep(1000);
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);
        security.btncross.click();
        Thread.sleep(3000);
    }
    @Test(priority = 7, description = "Verify change password without any data")
    public void changePasswordBlankData() throws InterruptedException {
        security= new Security(driver);
        signup=new Signup(driver);
        security.btnContinue2.click();
        Utils.doScroll4(driver);
        Thread.sleep(2000);
        security.btnContinue.click();
        Thread.sleep(2000);
        Assert.assertEquals(security.oldPassReqValidErrMsg.getText(),"Old password is required");
        Thread.sleep(500);
        Assert.assertEquals(security.newPassReqValidErrMsg.getText(),"New password is required");
        Thread.sleep(2000);
        Utils.doScroll3(driver);
        Assert.assertEquals(security.confirmPassReqValidErrMsg.getText(),"Confirm Password is required");
        Thread.sleep(500);
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
        Thread.sleep(500);
    }
    @Test(priority = 8, description = "Verify change password with invalid old password, new password, confirm password")
    public void changePassInvalCreds() throws InterruptedException {
        security= new Security(driver);
        signup= new Signup(driver);
        Thread.sleep(4000);
        security.txtOldPassword.sendKeys("tanvirmitul.com");
        security.txtNewPassword.sendKeys("mitultanvir.com");
        security.txtConfirmPassword.sendKeys("mitul.com");
        Assert.assertEquals(signup.passValidError.getText(),"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Assert.assertEquals(security.confirmPassValErrMsg.getText(),"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Assert.assertEquals(signup.confirmPassError.getText(),"Passwords do not match");
        Thread.sleep(3000);
    }
    @Test(priority = 9, description = "Verify change password with valid old password, new password, invalid old password")
    public void valOldPassNewPassInvalConfirmPass() throws InterruptedException {
        security=new Security(driver);
        signup= new Signup(driver);
        security.txtOldPassword.clear();
        security.txtNewPassword.clear();
        security.txtConfirmPassword.clear();
        Thread.sleep(2000);
        security.txtOldPassword.sendKeys("Tanvirmitul0-1997");
        security.txtNewPassword.sendKeys("Tanvirmitul0-1997");
        security.txtConfirmPassword.sendKeys("mitultanvir");
        Thread.sleep(500);
        Assert.assertEquals(signup.confirmPassError.getText(),"Passwords do not match");
        Thread.sleep(2000);
    }
    @Test(priority = 10, description = "Verify change password with valid old password, invalid new password, confirm password")
    public void invalNewConfirmPass() throws InterruptedException {
        security=new Security(driver);
        security.txtNewPassword.clear();
        security.txtConfirmPassword.clear();
        Thread.sleep(2000);
        security.txtNewPassword.sendKeys("tanvirmitul");
        security.txtConfirmPassword.sendKeys("mitultan");
        Thread.sleep(2000);
        Assert.assertEquals(signup.passValidError.getText(),"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Assert.assertEquals(signup.confirmPassError.getText(),"Passwords do not match");
        Thread.sleep(2000);
    }
    @Test(priority = 11, description = "Verify change password with invalid old password, valid new password, confirm password")
    public void invalOldPass() throws InterruptedException {
        security= new Security(driver);
        signup=new Signup(driver);
        security.txtOldPassword.clear();
        security.txtNewPassword.clear();
        security.txtConfirmPassword.clear();
        Thread.sleep(2000);
        security.txtOldPassword.sendKeys("tanvirmitul.com");
        security.txtNewPassword.sendKeys("Tanvirmitul0+1997");
        security.txtConfirmPassword.sendKeys("Tanvirmitul0+1997");
        Thread.sleep(2000);
        Assert.assertEquals(signup.passValidError.getText(),"Password must be at least 8 characters and contain at least one uppercase, one lowercase, one number and one special character");
        Thread.sleep(2000);
    }
    @Test(priority = 12, description = "Verify change password with valid old, new, confirm password and blank verification code")
    public void blankVeriCode() throws InterruptedException {
        security=new Security(driver);
        signup=new Signup(driver);
        security.txtOldPassword.clear();
        Thread.sleep(1000);
        security.txtOldPassword.sendKeys("Tanvirmitul0-1997");
        security.btnContinue.click();
        Thread.sleep(2000);
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
    }
    @Test(priority = 13, description = "Verify change password with invalid verification code")
    public void invalVeriCode() throws InterruptedException {
        security= new Security(driver);
        logout=new Logout(driver);
        signup= new Signup(driver);
        signup.txtVeriCode.sendKeys("123456");
        security.btnContinue.click();
        Thread.sleep(1000);
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);
        Utils.doScrollup(driver);
        Thread.sleep(2000);
        security.btncross.click();
        Thread.sleep(2000);
        logout.profileIcon.click();
        Thread.sleep(1000);
        logout.logoutOpt.click();
        Thread.sleep(2000);
    }
    @Test(priority = 14, description = "Verify anti phising code without any data")
    public void verifyAntiPhisingWithoutdata() throws InterruptedException {
        security=new Security(driver);
        signup= new Signup(driver);
        login= new Login(driver);
        logout=new Logout(driver);
        Thread.sleep(3000);
        driver.get(" https://exchange-tradex.nftarttoken.xyz/login");
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        login.doLogin("testautomation132@mailinator.com","Tanvirmitul0-1997");
        login.btnLogin2.click();
        Thread.sleep(4000);
        security.securityOpt.click();
        Thread.sleep(3000);
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnCreate.click();
        Thread.sleep(2000);
        security.btnContinue.click();
        Thread.sleep(1000);
        Assert.assertEquals(security.antiphisValErrMsg.getText(),"New anti-phishing code is required");
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 15, description = "Verify anti phising code with invalid anti-phising code")
    public void invalAntiPhisCode() throws InterruptedException {
        security=new Security(driver);
        security.txtAntiphisCode.sendKeys("1234");
        Thread.sleep(500);
        Assert.assertEquals(security.antiphisValErrMsg2.getText(),"Code must be between 6-20 characters");
        Thread.sleep(1000);
    }
    @Test(priority = 16, description = "Verify anti phising code with valid anti-phsing code & invalid verification code")
    public void invalVeriCodeValidAntiphisCode() throws InterruptedException {
        security=new Security(driver);
        signup=new Signup(driver);
        security.txtAntiphisCode.clear();
        Thread.sleep(1000);
        security.txtAntiphisCode.sendKeys("123456");
        signup.txtVeriCode.sendKeys("241569");
        Thread.sleep(1000);
        security.btnContinue.click();
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);
        security.btncross.click();
        Thread.sleep(2000);
    }
    @Test(priority = 17, description = "Verify that user can't remove minimum question limit")
    public void securityQstnMinQstnLimit() throws InterruptedException {
        security= new Security(driver);
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnCreate2.click();
        Thread.sleep(3000);
        security.btnAdd.click();
        Thread.sleep(500);
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnRemove.click();
        Thread.sleep(1000);
        Assert.assertEquals(security.quesLimitPopupMsg.getText(),"Your min question limit is 1");
        Thread.sleep(1000);
    }
    @Test(priority = 18, description = "Verify save question without adding any question and answer")
    public void veriSaveQstnWithoutAddQstnAns() throws InterruptedException {
        security= new Security(driver);
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnSave.click();
        Thread.sleep(500);
        Assert.assertEquals(security.qstnReqValErrMsg.getText(),"Question is required");
        Assert.assertEquals(security.ansReqValErrMsg.getText(),"Answer is required");
        Thread.sleep(1000);
    }
    @Test(priority = 19, description = "Verify save question without adding any question ")
    public void veriSaveQstnWithoutQstn() throws InterruptedException {

        Thread.sleep(500);
        security.txtAnswer.sendKeys("Mitul");
        security.btnSave.click();
        Thread.sleep(500);
        Assert.assertEquals(security.qstnReqValErrMsg.getText(),"Question is required");

    }
    @Test(priority = 20, description = "Verify save question without any verification code")
    public void saveQstnWithoutVeriCode() throws InterruptedException {
        security= new Security(driver);
        signup= new Signup(driver);
        Utils.doScrollUp2(driver);
        Thread.sleep(2000);
        security.btnQstnSelect.click();
       Thread.sleep(500);
       security.qstn1.click();
        Thread.sleep(500);
        security.txtAnswer.clear();
        Thread.sleep(500);
        security.txtAnswer.sendKeys("Dhaka");
        Utils.doScroll3(driver);
        Thread.sleep(2000);
        security.btnSave.click();
        Thread.sleep(500);
        security.btnContinue.click();
        Thread.sleep(500);
        String validVerErrMsg=signup.validVeriErrorMsg.getText();
        Assert.assertEquals(validVerErrMsg,"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 21, description = "Verify save question with invalid verification code")
    public void saveQstnInvalVeri() throws InterruptedException {
        security=new Security(driver);
        signup=new Signup(driver);
        signup.txtVeriCode.sendKeys("123456");
        security.btnContinue.click();
        Thread.sleep(3000);
        String veriPopupMsg=signup.valErrPopupMsg.getText();
        Thread.sleep(500);
        Assert.assertEquals(veriPopupMsg,"Invalid code or expired");
        Thread.sleep(1000);
    }
    @Test(priority = 22,description = "Verify email address verification without any data")
    public void emailAddressveriBlank() throws InterruptedException {
        security= new Security(driver);
        signup=new Signup(driver);
        driver.navigate().back();
        Thread.sleep(2000);
        security.btnChange.click();
        Thread.sleep(500);
        security.btnContinue.click();
        Thread.sleep(500);
        Assert.assertEquals(security.emailValErrMsg.getText(),"Email is required");
        Assert.assertEquals(signup.validVeriErrorMsg.getText(),"Verification Code is Required");
        Assert.assertEquals(security.veriValErrMsg2.getText(),"Verification Code is Required");
        Thread.sleep(1000);
    }
    @Test(priority = 23, description = "Verify email address verification with invalid email address")
    public void invalEmail() throws InterruptedException {
        login= new Login(driver);
        security=new Security(driver);
        login.txtEmail.sendKeys("tanvirmitul.com");
        Thread.sleep(500);
        security.btnContinue.click();
        Assert.assertEquals(login.txtEmail.getAttribute("validationMessage"),"Please include an '@' in the email address. 'tanvirmitul.com' is missing an '@'.");
        Thread.sleep(2000);
        security.btncross.click();
        Thread.sleep(2000);

    }
    @Test(priority = 24, description = "User can successfully see the login activity")
    public void userCanSeeAccActivity() throws InterruptedException {
        security= new Security(driver);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        security.btnMore.click();
        Thread.sleep(4000);
    }
    @Test(priority = 25, description = "User can successfully see the account activity")
    public void userCanSeeSecurityAcctivity() throws InterruptedException {
       security= new Security(driver);
       security.btnSecurityActivity.click();
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
    }
    @Test(priority = 26,description = "User can successfully see the device information")
    public void userCanSeeDeviceInfo() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(3000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        security.btnManage.click();
        Thread.sleep(4000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        Utils.doScrollUp3(driver);
        Thread.sleep(4000);
    }
    @Test(priority = 27, description = "User can successfully logout form device managemet page")
    public void userLogot() throws InterruptedException {
        security.btnLogoutDevice.click();
        Thread.sleep(4000);

//        security.btnLogout2.click();
//        Thread.sleep(3000);
    }

}
