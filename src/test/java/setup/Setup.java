package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;
@BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co= new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(co);
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils();
                util.takeScreenShot(driver);
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }

        }

    }
    @AfterTest
    public void quitBrowser(){
        try{
            driver.close();
        }
        catch (Exception e){
            driver.quit();
        }

    }
}
