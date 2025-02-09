package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static practicum.Constants.*;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By loginBtn = By.className(ENTER_ACCOUNT_BTN_XPATH);
    private final By assembleBurger = By.xpath(ASSEMBLE_BURGER_HEADER_XPATH);
    private final By bunsBtn = By.xpath(BUNS_BTN_XPATH);
    private final By saucesBtn = By.xpath(SAUCES_BTN_XPATH);
    private final By fillingsBtn = By.xpath(FILLINGS_BTN_XPATH);
    private final By cratorBread = By.xpath(CRATOR_BUN_XPATH);
    private final By galaxySauce = By.xpath(GALAXY_SAUCE_XPATH);
    private final By luminFilling = By.xpath(LUMIN_FILLING_XPATH);

    public MainPage enterAccountBtnClick(){
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
}
