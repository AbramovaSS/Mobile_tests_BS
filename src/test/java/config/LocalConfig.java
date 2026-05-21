package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:local.properties"})

public interface LocalConfig extends Config {
    @Key("os_version")
    String getPlatformVersion();

    @Key("platformName")
    String getPlatformName();

    @Key("deviceName")
    String getDeviceName();

}
