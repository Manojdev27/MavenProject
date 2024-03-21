package properties;

import org.aeonbits.owner.ConfigFactory;

public class PropertyReaderWithOwner {
    public static void main(String[] args) {

        FrameworkConfig frameworkConfig = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(frameworkConfig.username());
        System.out.println(frameworkConfig.password());
        System.out.println(frameworkConfig.url());
        System.out.println(frameworkConfig.tools());
    }

}
