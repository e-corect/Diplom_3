import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import practicum.WebDriverFactory;
import practicum.pages.LoginPage;
import practicum.pages.MainPage;
import practicum.pages.PersonalAccountPage;

import static practicum.Constants.ACCOUNT_PROFILE_PATH;
import static practicum.Constants.USER_PWD;

public class UserLogonTests {

    WebDriver driver = WebDriverFactory.getDriver();
    MainPage mainPage;
    LoginPage loginPage;
    PersonalAccountPage personalArea;
    UserSteps userSteps = new UserSteps();

    @Before
    public void prepare(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        personalArea = new PersonalAccountPage(driver);
        userSteps.createRandomUser().registerUser();
    }

    @Test
    public void loginOnMainPageTest(){
        mainPage.open().enterAccountBtnClick();
        loginPage.fillInEmail(userSteps.getUserEmail()).fillInPwd(USER_PWD).enterBtnClick();
        Assert.assertTrue(driver.findElement(personalArea.backToPersonalAccount().getProfileTab()).getText().equals("Профиль"));
        Assert.assertTrue(driver.getCurrentUrl().contains(ACCOUNT_PROFILE_PATH));
    }

    @Test
    public void loginThroughPersonalAccountBtnTest(){

        mainPage.open().personalAreaClick();
        loginPage.fillInEmail(userSteps.getUserEmail()).fillInPwd(USER_PWD).enterBtnClick();
        Assert.assertTrue(driver.findElement(personalArea.backToPersonalAccount().getProfileTab()).getText().equals("Профиль"));
        Assert.assertTrue(driver.getCurrentUrl().contains(ACCOUNT_PROFILE_PATH));
    }

    @After
    public void clear(){
        driver.close();
        userSteps.deleteUser();
    }
}
