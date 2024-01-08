package com.ea.framework.base;

import com.ea.framework.config.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FrameworkInitialize extends Base {


    public static void InitializeBrowser(BrowserType browserType) throws MalformedURLException {

        RemoteWebDriver driver = null;
        switch (browserType)
        {
            case Chrome:
            {
                System.setProperty("webdriver.chrome.driver", "/Users/testpc/ChromeDriver/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();

                //Zelenium Configuration
//                capabilities.setCapability("recordVideo", false);
//                capabilities.setCapability("build", "1.4.1");
//                capabilities.setCapability("idleTimeout", 150);

                driver= new RemoteWebDriver(new URL(Settings.SeleniumGridHub),chromeOptions);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case Firefox:
            {
                //Open the browser
                System.setProperty("webdriver.gecko.driver", "C:\\chromedriver\\geckodriver.exe");
               FirefoxOptions firefoxOptions = new FirefoxOptions();

                driver= new RemoteWebDriver(new URL(Settings.SeleniumGridHub),firefoxOptions);
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case IE:
            {
                break;
            }
        }
    }


}
