
package confProperty;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;
    static {
        try {
            //direct FILEPATH SETTING
            fileInputStream = new FileInputStream("src/main/resources/conf.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            //ecxeption (for example - NO FILE CONF and etc)
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace(); } } }
    /**
     * method for returning a string with a value from a file with settings
     */
    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key); } }