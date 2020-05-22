package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    // same for everyone
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    // so no one can create object of Driver class
    // everyone should call static getter method instead
    private Driver(){

    }

    /**synchronized makes method thread safe. It ensures that only 1 thread can use it at the time.
     *
     * Thread safety reduces performance but it makes everything safe.
     *
     * @return
     */
    public synchronized static WebDriver getDriver(){
        // if webdriver object doesn't exist
        // create it
        if(driverPool.get() == null){
            // specify browser type in configuration.properties file
            String browser = com.vytrack.utilities.ConfigurationReader.getProperty("browser").toLowerCase();
            if(System.getProperty("browser")!=null){
                browser = System.getProperty("browser");
            }

            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
//                case "remote-chrome":
//                    chromeOptions = new ChromeOptions();
//                    try {
//                        URL url = new URL("http://54.210.195.210:4444/wd/hub");
//                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    }
//                    break;

                case "chromeheadless":
                    // to run chrome without interface (headless model)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "chrome-remote":
                    try {
                        // we create object of URL and specify
                        // selenium grid hub as a parameter
                        // make sure it ends with /wd/hub

                        URL url = new URL("http://54.210.195.210:4444/wd/hub");

                        // desiredCapabilities used to specify what kind of node
                        // is required for testing
                        // such as OS type, browser, versions, etc...
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName(BrowserType.CHROME);
                        desiredCapabilities.setPlatform(Platform.ANY);

                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driverPool.get();
    }
    public static void closeDriver(){
        if(driverPool != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
