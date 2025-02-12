package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static practicum.Constants.*;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By loginBtn = By.xpath(ENTER_ACCOUNT_BTN_XPATH);
    private final By assembleBurger = By.xpath(ASSEMBLE_BURGER_HEADER_XPATH);
    private final By bunsBtn = By.xpath(BUNS_BTN_XPATH);
    private final By saucesBtn = By.xpath(SAUCES_BTN_XPATH);
    private final By fillingsBtn = By.xpath(FILLINGS_BTN_XPATH);
    private final By cratorBread = By.xpath(CRATOR_BUN_XPATH);
    private final By galaxySauce = By.xpath(GALAXY_SAUCE_XPATH);
    private final By luminFilling = By.xpath(LUMIN_FILLING_XPATH);
    private final By activeTab = By.xpath(".//div[contains(@class, 'current')]");

    public MainPage open(){
        driver.get(SITE_URL);
        return this;
    }

    public MainPage enterAccountBtnClick(){
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        return this;
    }

    public MainPage bunsBtnClick(){
        driver.findElement(bunsBtn).click();
        return this;
    }

    public MainPage saucesBtnClick(){
        driver.findElement(saucesBtn).click();
        return this;
    }

    public MainPage fillingsBtnClick(){
        driver.findElement(fillingsBtn).click();
        return this;
    }

    public MainPage personalAreaClick(){
        goToPersonalArea();
        return this;
    }

    public String getAssembleBurgerHeaderTxt(){
        new WebDriverWait(driver, 2).until(ExpectedConditions.textToBe(assembleBurger, "Соберите бургер"));
        return driver.findElement(assembleBurger).getText();
    }

    public By getCratorBread(){
        return cratorBread;
    }

    public By getBunsBtn() {
        return bunsBtn;
    }

    public By getSaucesBtn() {
        return saucesBtn;
    }

    public By getFillingsBtn() {
        return fillingsBtn;
    }

    public String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }
}
