package configration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserEnvironment {

    private String browserName = "chrome";
    private boolean headlessBrowser;
    private int webElementTimeOut;
    private int webBrowserImplicitWait;
    private boolean attachScreenShot;
    private String appUrl;
    private String eTitle;
    private String env_name;
    private Logger logger;
    private WebDriver driver;


    public BrowserEnvironment() {
        this.headlessBrowser = false;
        this.webElementTimeOut = 10;
        this.webBrowserImplicitWait = 5;
        this.attachScreenShot = true;
        logger = LoggerFactory.getLogger(BrowserEnvironment.class);
        this.browserName = PropertiesStore.BROWSER.isSpecified() ? PropertiesStore.loadConfigFile().getBrowser() : this.browserName;
        this.initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.webElementTimeOut = PropertiesStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertiesStore.loadConfigFile().getBrowserWebelementTimeout() : this.webElementTimeOut;
        this.webBrowserImplicitWait = PropertiesStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertiesStore.loadConfigFile().getBrowserImplicitTimeout() : this.webBrowserImplicitWait;
        this.attachScreenShot = PropertiesStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertiesStore.loadConfigFile().isBrowserAttachscreenshot() : this.attachScreenShot;
        this.headlessBrowser = PropertiesStore.BROWSER_HEADLESS.isSpecified() ? PropertiesStore.loadConfigFile().isBrowserHeadless() : this.headlessBrowser;
        this.env_name = PropertiesStore.ENV_NAME.isSpecified() ? (String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("env_name") : this.env_name;
        this.appUrl = PropertiesStore.APP_URL.isSpecified() ? (String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("appUrl") : this.appUrl;
        this.eTitle = PropertiesStore.ETITLE.isSpecified() ? (String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("eTitle") : this.eTitle;


    }

    public WebDriver getDriver() {
        WebDriver driver;
        switch (this.browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                driver.get((String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("appUrl"));
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.chromedriver().setup();
                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver(optionsFirefox);
                driver.get((String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("appUrl"));
                break;
            default:

                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.chromedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
                driver.get((String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("appUrl"));

        }
        this.driver = driver;
        return this.driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setHeadlessBrowser(boolean headlessBrowser) {
        this.headlessBrowser = headlessBrowser;
    }

    public void setWebElementTimeOut(int webElementTimeOut) {
        this.webElementTimeOut = webElementTimeOut;
    }

    public void setWebBrowserImplicitWait(int webBrowserImplicitWait) {
        this.webBrowserImplicitWait = webBrowserImplicitWait;
    }

    public void setAttachScreenShot(boolean attachScreenShot) {
        this.attachScreenShot = attachScreenShot;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public void setTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    public void setEnv_name(String env_name) {
        this.env_name = env_name;
    }
}
