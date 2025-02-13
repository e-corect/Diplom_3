package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static practicum.Constants.*;

public abstract class BasePage {

    protected static final String URL = SITE_URL;

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By burgersLogo = By.xpath(LOGO_XPATH);

    private final By personalArea = By.xpath(PERSONAL_AREA_BTN_XPATH);

    private final By constructorButton = By.xpath(CONSTRUCTOR_BTN_XPATH);

    @Step("Клик по логотипу Stellar Burger на верхней панели")
    protected BasePage goToMainPage(){
        driver.findElement(burgersLogo).click();
        return this;
    }

    @Step("Клик по кнопке 'Личный Кабинет' на верхней панели")
    protected BasePage goToPersonalArea(){
        driver.findElement(personalArea).click();
        return this;
    }

    @Step("Клик по кнопке 'Конструктор' на верхней панели")
    protected BasePage goToConstructor(){
        driver.findElement(constructorButton).click();
        return this;
    }
}
