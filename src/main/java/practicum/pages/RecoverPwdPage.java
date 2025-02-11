package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static practicum.Constants.*;

public class RecoverPwdPage {

    public static final String RECOVER_URL = SITE_URL + RECOVER_PWD_PATH;

    WebDriver driver;

    private final By loginLink = By.xpath(LOGIN_LINK_XPATH);

    public RecoverPwdPage(WebDriver driver) {
        this.driver = driver;
    }

    public RecoverPwdPage open(){
        driver.get(RECOVER_URL);
        return this;
    }

    public RecoverPwdPage clickLoginLink(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
        return this;
    }

}
