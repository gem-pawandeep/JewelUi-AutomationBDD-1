package StepDefination;

import com.gemini.generic.exception.GemException;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.GemJarConstants;
import com.gemini.generic.utils.GemJarGlobalVar;
import com.gemini.generic.utils.GemJarUtils;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Jewel {
    @Before
    public void start() throws GemException, MalformedURLException {
        if (GemJarGlobalVar.browserInTest.equals("grid")) {
            String remoteURL = GemJarUtils.getGemJarKeyValue("remoteDriverUrl");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.setAcceptInsecureCerts(true);
//            options.setCapability("resolution", "1296x696");
            WebDriver driver = new RemoteWebDriver(new URL(remoteURL), options);
            DriverManager.setWebDriver(driver);
            DriverAction.launchUrl(GemJarUtils.getGemJarConfigData(GemJarConstants.LAUNCH_URL));
//        DriverAction.launchUrl("https://www.amazon.com/");
            DriverAction.refresh();
            DriverAction.maximizeBrowser();
            DriverAction.setBrowserSize(1296,696);
            DriverAction.setImplicitTimeOut(Long.parseLong(GemJarGlobalVar.implicitTime));
            DriverAction.setPageLoadTimeOut(Long.parseLong(GemJarGlobalVar.pageTimeout));
            DriverAction.setScriptTimeOut(Long.parseLong(GemJarGlobalVar.scriptTimeout));
        } else {
            DriverManager.setUpBrowser();
            DriverAction.setBrowserSize(1296,696);
        }
    }
}
