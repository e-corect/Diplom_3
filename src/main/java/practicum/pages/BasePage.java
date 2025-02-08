package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static practicum.Constants.*;

public abstract class BasePage {

    private static final String URL = SITE_URL;

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By burgersLogo = By.xpath(LOGO_XPATH);
    private final By ordersFeed = By.xpath(ORDERS_FEED_BTN_XPATH);
    private final By personalArea = By.xpath(PERSONAL_AREA_BTN_XPATH);
    private final By constructorButton = By.xpath(CONSTRUCTOR_BTN_XPATH);

    BasePage open() {
        driver.get(URL);
        return this;
    }

    protected BasePage goToMainPage(){
        driver.findElement(burgersLogo).click();
        return this;
    }

    protected BasePage goToOrdersFeed(){
        driver.findElement(ordersFeed).click();
        return this;
    }

    protected BasePage goToLogin(){
        driver.findElement(personalArea).click();
        return this;
    }

    protected BasePage goToConstructor(){
        driver.findElement(constructorButton).click();
        return this;
    }

    protected void quit(){
        driver.quit();
    }
}
