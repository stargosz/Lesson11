package configration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public enum PropertiesStore {
    BROWSER("browser"),
    BROWSER_WEBELEMENT_TIMEOUT("browserWebelementTimeout"),
    BROWSER_IMPLICIT_TIMEOUT("browserImplicitTimeout"),
    BROWSER_HEADLESS("browserHeadless"),
    APP_URL("appUrl"),
    ENV_NAME("env_name"),
    ETITLE("eTitle"),
    BROWSER_ATTACH_SCREENSHOT("browserAttachscreenshot");

    private String value;
    private String propertyKey;
    public static final String CONFIG_PROPERTIES = "config.yml";
    private static Environment properties = null;

    private PropertiesStore(String key) {
        this.propertyKey = key;
        this.value = this.retrieveValue(key);
    }

    private String retrieveValue(String key) {
        return System.getProperty(key) != null ? System.getProperty(key) : getValueFromConfigFile(key);
    }

    private String getValueFromConfigFile(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }
        Object objFile = properties.get(key);
        return objFile != null ? Objects.toString(objFile) : null;
    }


    public static Environment loadConfigFile() {
        Environment copy = null;
        try {
            InputStream confFileStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.yml");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                Environment environment = mapper.readValue(confFileStream, Environment.class);
                copy = environment;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    confFileStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copy;
    }

    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.value);
    }

//    public int getIntValue() {
//        return Integer.parseInt(this.retrieveValue(this.propertyKey));
//    }
//
//    public boolean getBoolean() {
//        return this.isSpecified() && Boolean.parseBoolean(this.value);
//    }

    public String getValue() {
        return this.retrieveValue(this.propertyKey);
    }

}
