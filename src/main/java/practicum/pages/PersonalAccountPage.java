package practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static practicum.Constants.*;

public class PersonalAccountPage extends BasePage{

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By logoutButton = By.xpath(LOGOUT_BTN_XPATH);
    private final By profileTab = By.xpath(PROFILE_TAB_XPATH);

    @Step("Клик по кнопке Выход на странице Личного Кабинета")
    public PersonalAccountPage logout(){
        driver.findElement(logoutButton).click();
        return this;
    }

    @Step("Клик по кнопке 'Личный Кабинет' на верхней панели")
    public PersonalAccountPage backToPersonalAccount(){
        goToPersonalArea();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(profileTab));
        return this;
    }

    @Step("Получение наименования кнопки 'Профиль' на странице Личного Кабинета")
    public String getProfileTabTxt(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(profileTab));
        return driver.findElement(profileTab).getText();
    }

    @Step("Клик по кнопке 'Конструктор' на верхней панели")
    public PersonalAccountPage constructorBtnClick(){
        goToConstructor();
        return this;
    }

    @Step("Клик по логотипу Stellar Burger на верхней панели")
    public PersonalAccountPage burgerLogoClick(){
        goToMainPage();
        return this;
    }
}
