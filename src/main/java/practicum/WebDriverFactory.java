package practicum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static practicum.Constants.*;

public class WebDriverFactory {

    public static WebDriver getDriver() {
        String driverPath = CHROME_DRIVER_PATH;
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        if (browser.equals("yandex")){
            driverPath = YANDEX_DRIVER_PATH;}
        System.setProperty(CHROME_DRIVER_PROPERTY_NAME, driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        return new ChromeDriver(options);
    }
}

