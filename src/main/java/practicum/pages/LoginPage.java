package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static practicum.Constants.*;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By inputEmail = By.xpath(INPUT_EMAIL_XPATH);
    private final By inputPwd = By.xpath(INPUT_PWD_XPATH);
    private final By enterButton = By.xpath(ENTER_BTN_XPATH);
    private final By registerLink = By.linkText(REGISTER_LINK_TEXT);
    private final By recoverPwdLink = By.linkText(RECOVER_PWD_TEXT);
    private final By wrongPwdMsg = By.xpath(WRONG_PWD_MSG_XPATH);
}
