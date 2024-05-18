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
    public static String getApiUrl(){return  properties.getProperty("urlApi");}

    public static String getToken(){return  properties.getProperty("token");}
    public static String getTokenFalse(){return  properties.getProperty("tokenFalse");}

    public static String account() {
        return properties.getProperty("account");
    }
    public static String login() {
        return properties.getProperty("login");
    }

    public static String password() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static int timeout()  {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    public static int pageLoadTimeout()  {
        return Integer.parseInt(properties.getProperty("pageLoadTimeout"));
    }
}