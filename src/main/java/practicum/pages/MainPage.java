package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private final By activeTab = By.xpath(ACTIVE_TAB_XPATH);
    private final By bunsHeaderAtIngredientsList = By.xpath(INGREDIENTS_LIST_BUNS_HEADER_XPATH);
    private final By ingredientsMenu = By.className(INGREDIENTS_MENU_CLASSNAME);

    public MainPage open(){
        driver.get(SITE_URL);
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.textToBe(assembleBurger, "Соберите бургер"));
        return this;
    }

    public MainPage enterAccountBtnClick(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));
        driver.findElement(loginBtn).click();
        return this;
    }

    public MainPage bunsBtnClick(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(bunsBtn));
        driver.findElement(bunsBtn).click();
        return this;
    }

    public boolean isHeaderVisible(){
        return driver.findElement(bunsHeaderAtIngredientsList).isDisplayed();
    }

    public MainPage scrollIngredientsMenu(){
        driver.findElement(ingredientsMenu).sendKeys(Keys.ARROW_UP, Keys.ARROW_UP);
        return this;
    }

    public MainPage saucesBtnClick(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(saucesBtn));
        driver.findElement(saucesBtn).click();
        return this;
    }

    public boolean isSaucesBtnPushed(){
        return driver.findElement(saucesBtn).getText().equals(getPushedBtnName());
    }

    public MainPage fillingsBtnClick(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(fillingsBtn));
        driver.findElement(fillingsBtn).click();
        return this;
    }

    public boolean isFillingsBtnPushed(){
        return driver.findElement(fillingsBtn).getText().equals(getPushedBtnName());
    }

    public MainPage personalAreaClick(){
        goToPersonalArea();
        return this;
    }

    public String getAssembleBurgerHeaderTxt(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.textToBe(assembleBurger, "Соберите бургер"));
        return driver.findElement(assembleBurger).getText();
    }

    public String getPushedBtnName() {
        return driver.findElement(activeTab).getText();
    }
}
