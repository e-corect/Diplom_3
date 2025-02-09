package practicum.pages;

import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static practicum.Utils.*;

import static practicum.Constants.*;

public class RegPage extends BasePage{

    public static final String REG_URL = SITE_URL + REG_PATH;

    private String userName;

    private String email;

    public RegPage(WebDriver driver) {
        super(driver);
    }

    private final By regPageHeader = By.xpath(REG_HEADER_TEXT);

    private final By userNameInput = By.xpath(USERNAME_INPUT_XPATH);

    private final By emailInput = By.xpath(EMAIL_INPUT_XPATH);

    private final By pwdInput = By.xpath(PWD_INPUT_XPATH);

    private final By regBtn = By.xpath(REG_BTN_XPATH);

    private final By recoverPwdLink = By.xpath(RECOVER_PWD_LINK_XPATH);

    @Override
    public RegPage open(){
        driver.get(REG_URL);
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return email;
    }

    public String getHeaderTxt(){
        return driver.findElement(regPageHeader).getText();
    }

    public RegPage fillInUserName(String userName){
        this.userName = userName;
        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys(userName);
        return this;
    }

    public RegPage fillInEmail(String email){
        this.email = email;
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public RegPage fillInPwd(String pwd){
        driver.findElement(pwdInput).clear();
        driver.findElement(pwdInput).sendKeys(pwd);
        return this;
    }

    public RegPage clickRegBtn(){
        driver.findElement(regBtn).click();
        return this;
    }

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
}
