package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityFactory {

    public static DesiredCapabilities getCapabilities(String browser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.getCurrent());
        caps.setBrowserName(browser);
        return caps;
    }
}
