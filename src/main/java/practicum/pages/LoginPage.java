package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static practicum.Constants.*;

public class LoginPage extends BasePage{

    private static final String LOGIN_URL = SITE_URL + LOGIN_PATH;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginHeader = By.xpath(LOGIN_HEADER_TEXT);
    private final By emailInput = By.xpath(INPUT_EMAIL_XPATH);
    private final By pwdInput = By.xpath(INPUT_PWD_XPATH);
    private final By enterBtn = By.xpath(ENTER_BTN_XPATH);
    private final By registerLink = By.linkText(REGISTER_LINK_TEXT);
    private final By recoverPwdLink = By.linkText(RECOVER_PWD_TEXT);
    private final By wrongPwdMsg = By.xpath(WRONG_PWD_MSG_XPATH);

    public LoginPage open(){
        driver.get(LOGIN_URL);
        return this;
    }

    public String getHeaderTxt(){
        return driver.findElement(loginHeader).getText();
    }

    public LoginPage goToRegistration(){
        driver.findElement(registerLink).click();
        return this;
    }

    public LoginPage goToRecoverPwd(){
        driver.findElement(recoverPwdLink).click();
        return this;
    }

    public LoginPage fillInEmail(String email){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(emailInput)).clear();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public LoginPage fillInPwd(String pwd){
        driver.findElement(pwdInput).clear();
        driver.findElement(pwdInput).sendKeys(pwd);
        return this;
    }

    public LoginPage enterBtnClick(){
        driver.findElement(enterBtn).click();
        return this;
    }

    public String getErrorMsg() {
        return driver.findElement(wrongPwdMsg).getText();
    }
}
