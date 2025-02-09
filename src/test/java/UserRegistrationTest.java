import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practicum.WebDriverFactory;
import practicum.pages.LoginPage;
import practicum.pages.PersonalAccountPage;
import practicum.pages.RegPage;

import static java.lang.Thread.sleep;
import static practicum.Constants.INCORRECT_USER_PWD;
import static practicum.Constants.USER_PWD;


public class UserRegistrationTest {

    WebDriver driver = WebDriverFactory.getDriver();
    RegPage regPage = new RegPage(driver);
    UserSteps userSteps = new UserSteps();


    @Test
    public void successfullUserRegistration() throws InterruptedException {
        regPage.registerRandomUser(USER_PWD);
        LoginPage loginPage = new LoginPage(driver);

        loginPage.fillInEmail(regPage.getUserEmail()).fillInPwd(USER_PWD).enterBtnClick();
//        PersonalAccountPage personalArea = new PersonalAccountPage(driver);
        sleep(2000);
//        Assert.assertEquals(regPage.getUserEmail(),personalArea.getEmail());
        userSteps.userLogin(regPage.getUserEmail(), USER_PWD).deleteUser();
    }

    @Test
    public void unsuccessfullUserRegistration(){
        regPage.registerRandomUser(INCORRECT_USER_PWD);
        PersonalAccountPage personalArea = new PersonalAccountPage(driver);
        Assert.assertEquals(regPage.getUserEmail(),personalArea.getEmail());
        userSteps.userLogin(regPage.getUserEmail(), USER_PWD).deleteUser();
    }

    @After
    public void clear(){
        driver.close();
    }

}
