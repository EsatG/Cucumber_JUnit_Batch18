package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {

    // 1- Make constructor private
    private Driver(){

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                     WebDriverManager.firefoxdriver().setup();
                     driver = new FirefoxDriver();
                     break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "chrome-remote":
                    try {
                        // Same thing as ChromeOptions, to request Selenium Grid to run tests on Chrome
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);

                        ChromeOptions chromeOptions = new ChromeOptions();
                        URL url = new URL("http://3.81.165.197:4444/grid/console");
                        driver = new RemoteWebDriver(url,chromeOptions);
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;

                case "firefox-remote":
                    try {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        URL url = new URL("http://3.81.165.197:4444/wd/hub");
                        driver = new RemoteWebDriver(url,firefoxOptions);
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }


                default:
                    throw new RuntimeException("Wrong browser name: " + browser );

            }
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }


}


