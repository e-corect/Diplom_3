package practicum.pages;

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

    public By getProfileTab() {
        return profileTab;
    }

    public PersonalAccountPage open(){
        driver.get(ACCOUNT_PROFILE_PATH);
        return this;
    }

    public PersonalAccountPage logout(){
        driver.findElement(logoutButton).click();
        return this;
    }

    public PersonalAccountPage backToPersonalAccount(){
        goToPersonalArea();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(profileTab));
        return this;
    }

    public String getProfileTabTxt(){
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.elementToBeClickable(profileTab));
        return driver.findElement(profileTab).getText();
    }

    public PersonalAccountPage constructorBtnClick(){
        goToConstructor();
        return this;
    }
    
}
