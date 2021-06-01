package configration;

import java.util.List;
import java.util.Map;

public class Environment {


    public Environment(String browser, boolean browserAttachscreenshot, boolean browserHeadless, int browserImplicitTimeout, int browserWebelementTimeout, List<Map<String, Object>> environments) {
        this.browser = browser;
        this.browserAttachscreenshot = browserAttachscreenshot;
        this.browserHeadless = browserHeadless;
        this.browserImplicitTimeout = browserImplicitTimeout;
        this.browserWebelementTimeout = browserWebelementTimeout;
        this.environments = environments;

    }

    public Environment() {
    }

    private String browser;
    private boolean browserAttachscreenshot;
    private boolean browserHeadless;
    private int browserImplicitTimeout;
    private int browserWebelementTimeout;
    private List<Map<String, Object>> environments;


    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public boolean isBrowserAttachscreenshot() {
        return browserAttachscreenshot;
    }

    public void setBrowserAttachscreenshot(boolean browserAttachscreenshot) {
        this.browserAttachscreenshot = browserAttachscreenshot;
    }

    public boolean isBrowserHeadless() {
        return browserHeadless;
    }

    public void setBrowserHeadless(boolean browserHeadless) {
        this.browserHeadless = browserHeadless;
    }

    public int getBrowserImplicitTimeout() {
        return browserImplicitTimeout;
    }

    public void setBrowserImplicitTimeout(int browserImplicitTimeout) {
        this.browserImplicitTimeout = browserImplicitTimeout;
    }

    public int getBrowserWebelementTimeout() {
        return browserWebelementTimeout;
    }

    public void setBrowserWebelementTimeout(int browserWebelementTimeout) {
        this.browserWebelementTimeout = browserWebelementTimeout;
    }

    public List<Map<String, Object>> getEnvironments() {
        return environments;
    }

    public void setEnvironments(List<Map<String, Object>> environments) {
        this.environments = environments;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "browser='" + browser + '\'' +
                ", browserAttachscreenshot=" + browserAttachscreenshot +
                ", browserHeadless=" + browserHeadless +
                ", browserImplicitTimeout=" + browserImplicitTimeout +
                ", browserWebelementTimeout=" + browserWebelementTimeout +
                ", environments=" + environments +
                '}';
    }


    public Object get(String key) {
        return key;
    }
}