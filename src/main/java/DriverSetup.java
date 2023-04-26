import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSetup {
    private static WebDriver webDriver;

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY,options);
            options.merge(cp);
            webDriver = new ChromeDriver(options);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }
    public static void closeDriver(){
        if(webDriver!=null){
            webDriver.close();
        }
    }
    /*
    TODO: Once you finish your tests you need to close browser using quit()
     */
    public static void quitDriver(){
        if(webDriver!=null){
            webDriver.quit();
        }
    }
}


