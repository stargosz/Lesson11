package Tests;

import TestBase.TestBase;
import configration.PropertiesStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@Tag("REGRESSION")
public class HeadersTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("HeadersTest.class");

    @Test
    @DisplayName("Test verifies if page title matches with expected - Siiportal ")
    @Tag("Siiportal")
    public void shouldCheckPageTitle_1() {
        logger.debug(">>>> Start test <<<<");
        String ActualTitle = driver.getTitle();
        String expectedTitle = (String) PropertiesStore.loadConfigFile().getEnvironments().get(0).get("eTitle");
        assertThat(expectedTitle, is(ActualTitle));

    }

}