package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

public class WebDriverConfig {
    private static Class<? extends PropInterface> getPropertySource() {
        String env = System.getProperty("env");
        if (env == null || env.equals("null")) {
            return PropInterfaceTest.class;
        } else if (env.equals("test")) {
            return PropInterfaceTest.class;
        } else {
            throw new RuntimeException("Invalid value for system property 'env'! Expected one of:[null, 'test']");
        }
    }

    public static final PropInterface PROP = ConfigFactory.create(getPropertySource());

    @Config.LoadPolicy(Config.LoadType.MERGE)
    @Config.Sources({"system:properties", "classpath:test.properties"})
    interface PropInterfaceTest extends PropInterface {
    }

    public interface PropInterface extends Config {

        // Web tests properties
        @Key("webBrowserName")
        String getBrowserName();

        @Key("webBrowserVersion")
        String getBrowserVersion();

        @Key("webBaseUrl")
        String getBaseUrl();

        @Key("webBrowserSize")
        String getBrowserSize();

        @Key("webIsRemote")
        Boolean isRemote();

        @Key("webRemoteUrl")
        String getRemoteUrl();

        @Key("webPageLoadTimeout")
        Long getPageLoadTimeout();

        @Key("webTimeout")
        Long getTimeout();

        @Key("webIsHeadless")
        Boolean isHeadless();
    }
}
