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
        return properties.getProperty("urlApi");
    }
    public static String getToken() {
        return properties.getProperty("token");
    }
    public static String getTokenFalse() {
        return properties.getProperty("tokenFalse");
    }
    public static String getTestmoAccount() {
        return properties.getProperty("account");
    }
    public static String getTestmoLogin() {
        return properties.getProperty("login");
    }
    public static String getTestmoPassword() {
        return properties.getProperty("password");
    }
}
>>>>>>> origin/develop
