package util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static String getProperty(String name) {
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty(name);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
