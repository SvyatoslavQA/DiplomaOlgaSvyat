package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;
    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getUrl() {
        return properties.getProperty("url");
    }
    public static String getUrlApi() {
        return properties.getProperty("url_api");
    }
    public static String getTestmoLogin() {
        return properties.getProperty("testmo_login");
    }
    public static String getTestmoPassword() {
        return properties.getProperty("testmo_password");
    }
}