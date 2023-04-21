package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login;
import pages.Logout;
import setup.Setup;
import utils.Utils;

public class LogoutTestRunner extends Setup {
    @Test(description = "User can successfully logout from the system")
    public void logout() throws InterruptedException {
        Login login= new Login(driver);
        Logout logout= new Logout(driver);
        driver.get("https://exchange-tradex.nftarttoken.xyz");
        Thread.sleep(4000);
        login.btnLogin.click();
        Thread.sleep(2000);
        Utils.doScroll(driver);
        Thread.sleep(2000);
        String titleLogin= login.titleLogin.getText();
        Assert.assertEquals(titleLogin,"Login");
        Thread.sleep(1000);
        login.doLogin("tanvirmitul048@mailinator.com","Tanvirmitul0-1997");
        login.btnLogin2.click();
        Thread.sleep(2000);
        String logSuccessPopupmsg= login.logSuccessPopupMsg.getText();
        Assert.assertEquals(logSuccessPopupmsg,"Logged in successfully");
        Thread.sleep(4000);
        Assert.assertEquals(login.dashboardTitle.getText(),"Dashboard");
        Thread.sleep(1000);
        logout.profileIcon.click();
        Thread.sleep(1000);
        logout.logoutOpt.click();
        Thread.sleep(2000);
        Assert.assertEquals(logout.logoutSuccessPopupMsg.getText(),"Logout Successful!");
        Thread.sleep(2000);
    }
}
