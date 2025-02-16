import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import practicum.pages.LoginPage;
import practicum.pages.MainPage;
import practicum.pages.PersonalAccountPage;

import static practicum.Constants.*;
import static practicum.WebDriverFactory.getDriver;

public class PersonalAccountTests {
    WebDriver driver = getDriver();
    MainPage mainPage;
    LoginPage loginPage;
    PersonalAccountPage personalArea;
    UserSteps userSteps = new UserSteps();

    @Before
    public void prepare(){
        userSteps.createRandomUser().registerUser();
        loginPage = new LoginPage(driver);
        loginPage.open().fillInEmail(userSteps.getUserEmail()).fillInPwd(USER_PWD).enterBtnClick();
        mainPage = new MainPage(driver);
        personalArea = new PersonalAccountPage(driver);
    }

    @Test
    public void loginViaPersonalAccountBtnTest(){
        mainPage.personalAreaClick();
        Assert.assertEquals("Профиль", personalArea.backToPersonalAccount().getProfileTabTxt());
        Assert.assertTrue(driver.getCurrentUrl().contains(ACCOUNT_PROFILE_PATH));
    }

    @Test
    public void jumpToMainFromPersAccountViaConstructorTest(){
        personalArea.constructorBtnClick();
        Assert.assertEquals("Соберите бургер", mainPage.getAssembleBurgerHeaderTxt());
        Assert.assertEquals(SITE_URL + "/", driver.getCurrentUrl());
    }

    @Test
    public void jumpToMainFromPersAccountViaLogoTest(){
        personalArea.burgerLogoClick();
        Assert.assertEquals("Соберите бургер", mainPage.getAssembleBurgerHeaderTxt());
        Assert.assertEquals(SITE_URL + "/", driver.getCurrentUrl());
    }

    @Test
    public void logoutTest(){
        personalArea.backToPersonalAccount().logout();
        Assert.assertEquals("Вход", loginPage.getHeaderTxt());
        Assert.assertTrue(driver.getCurrentUrl().contains(LOGIN_PATH));
    }

    @After
    public void clear(){
        driver.close();
        driver.quit();
        userSteps.deleteUser();
    }
}
