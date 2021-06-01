package TestBase;

import configration.BrowserEnvironment;
//import configration.EnvironmentProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger("TestBase.class");

    protected static WebDriver driver;
    private static BrowserEnvironment browserEnvironment;
//    public static EnvironmentProperty environmentProperty;


    @BeforeAll
    static void setUp() {
//        environmentProperty = EnvironmentProperty.getInstance();
        browserEnvironment = new BrowserEnvironment();
        driver = browserEnvironment.getDriver();
        logger.info("Driver initialized");
    }

    @BeforeEach
    void beforeEach() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logger.info("Implicit wait set for 15 seconds");

    }

    @AfterEach
    void afterEach() {
        logger.info(">>>> Test finished <<<<");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        logger.info("Driver has been closed properly");
    }
}