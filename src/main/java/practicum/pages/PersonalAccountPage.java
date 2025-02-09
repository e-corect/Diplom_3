package practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static practicum.Constants.*;

public class PersonalAccountPage extends BasePage{

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    private final By logoutButton = By.xpath(LOGOUT_BTN_XPATH);
    private final By nameField = By.xpath(LOGIN_FIELD_XPATH);

    @Override
    public PersonalAccountPage open(){
        driver.get(ACCOUNT_PROFILE_PATH);
        return this;
    }

    public String getEmail(){
        return driver.findElement(nameField).getAttribute("value");
    }

    public PersonalAccountPage logout(){
        driver.findElement(logoutButton).click();
        return this;
    }

    
}
