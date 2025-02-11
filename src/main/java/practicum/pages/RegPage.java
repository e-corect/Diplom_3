package practicum.pages;

import io.qameta.allure.Step;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static practicum.Utils.*;

import static practicum.Constants.*;

public class RegPage extends BasePage{

    public static final String REG_URL = SITE_URL + REG_PATH;

    private String userName;

    private String email;

    public RegPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameInput = By.xpath(USERNAME_INPUT_XPATH);

    private final By emailInput = By.xpath(EMAIL_INPUT_XPATH);

    private final By pwdInput = By.xpath(PWD_INPUT_XPATH);

    private final By regBtn = By.xpath(REG_BTN_XPATH);

    private final By loginLink = By.xpath(LOGIN_LINK_XPATH);

    private final By wrongPwdMsg = By.xpath(WRONG_PWD_MSG_XPATH);

    @Step("Открываем форму регистрации")
    public RegPage open(){
        driver.get(REG_URL);
        return this;
    }

    public String getUserEmail() {
        return email;
    }

    @Step("Заполняем поле Имя")
    public RegPage fillInUserName(String userName){
        this.userName = userName;
        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    @Step("Заполняем поле Email")
    public RegPage fillInEmail(String email){
        this.email = email;
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    @Step("Заполняем поле Пароль")
    public RegPage fillInPwd(String pwd){
        driver.findElement(pwdInput).clear();
        driver.findElement(pwdInput).sendKeys(pwd);
        return this;
    }

    @Step("Нажимем кнопку Зарегистрироваться")
    public RegPage clickRegBtn(){
        driver.findElement(regBtn).click();
        return this;
    }

    @Step("Нажимем ссылку Войти")
    public RegPage clickLoginLink(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
        return this;
    }

    @Step("Генерируем и регистрируем пользователя со случайными параметрами")
    public RegPage registerRandomUser(@Nullable String pwd){
        if (pwd.equals(null)){
            pwd = USER_PWD;
        }
        String userName = generateFirstName();
        open().fillInUserName(userName)
                .fillInEmail(generateEmail(userName))
                .fillInPwd(pwd).clickRegBtn();
        return this;
    }

    @Step("Получаем сообщение об ошибке с формы регистрации")
    public String getErrorMsg() {
        return driver.findElement(wrongPwdMsg).getText();
    }
}
