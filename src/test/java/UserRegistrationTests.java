import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import practicum.WebDriverFactory;
import practicum.pages.LoginPage;
import practicum.pages.PersonalAccountPage;
import practicum.pages.RegPage;

import static practicum.Constants.*;


public class UserRegistrationTests {

    WebDriver driver = WebDriverFactory.getDriver();
    RegPage regPage = new RegPage(driver);
    UserSteps userSteps = new UserSteps();


    @Test
    public void successfullUserRegistration() throws InterruptedException {
        regPage.registerRandomUser(USER_PWD);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillInEmail(regPage.getUserEmail()).fillInPwd(USER_PWD).enterBtnClick();
        PersonalAccountPage personalArea = new PersonalAccountPage(driver);
        personalArea.backToPersonalAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("account/profile"));
        Assert.assertEquals(driver.findElement(personalArea.getProfileTab()).getText(), "Профиль");
        userSteps.userLogin(regPage.getUserEmail(), USER_PWD).deleteUser();
    }


    @Test
    public void unsuccessfullUserRegistration(){
        regPage.registerRandomUser(INCORRECT_USER_PWD);
        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
        Assert.assertTrue(driver.findElement(By.xpath(WRONG_PWD_MSG_XPATH)).getText().equals(WRONG_PWD_MSG) );
    }

    @After
    public void clear(){
        driver.close();
    }

}
