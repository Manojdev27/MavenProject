package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    public static void main(String[] args) throws IOException {

        File file = new File(System.getProperty("user.dir") + "/config.properties");
        FileInputStream inputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(inputStream);

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println(properties.getProperty("url"));

        String timeout = properties.getProperty("timeout");
        int i1 = Integer.parseInt(timeout);

        String tools = properties.getProperty("tools");
        String[] split = tools.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
