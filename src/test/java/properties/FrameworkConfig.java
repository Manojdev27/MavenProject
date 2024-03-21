package properties;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/config.properties")
public interface FrameworkConfig extends Config {

    String username();
    String password();
    String url();
    int timeout();
    String[] tools();

}
