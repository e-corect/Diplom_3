import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import practicum.pages.*;

import static practicum.Constants.*;
import static practicum.WebDriverFactory.getDriver;

public class PersonalAccountTests {
    WebDriver driver = getDriver();
    MainPage mainPage;
    LoginPage loginPage;
    PersonalAccountPage personalArea;
    RegPage regPage;
    RecoverPwdPage recoverPwdPage;
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
    public void enterViaPersonalAccountBtnTest(){
        mainPage.personalAreaClick();
        Assert.assertTrue(personalArea.backToPersonalAccount().getProfileTabTxt().equals("Профиль"));
        Assert.assertTrue(driver.getCurrentUrl().contains(ACCOUNT_PROFILE_PATH));
    }

    @Test
    public void jumpToConstructorFromPersonalAccountTest(){
        personalArea.constructorBtnClick();
        Assert.assertTrue(mainPage.getAssembleBurgerHeaderTxt().equals("Соберите бургер"));
        Assert.assertEquals(SITE_URL + "/", driver.getCurrentUrl());
    }

    @Test
    public void logoutTest(){
        personalArea.backToPersonalAccount().logout();
        Assert.assertEquals(loginPage.getHeaderTxt(), "Вход");
        Assert.assertTrue(driver.getCurrentUrl().contains(LOGIN_PATH));
    }

    @Test
    public void bunsBtnTest(){
        new WebDriverWait(driver, 2)
            .until(ExpectedConditions.elementToBeClickable(mainPage.getSaucesBtn()));
        mainPage.saucesBtnClick();

        mainPage.fillingsBtnClick();

        System.out.println(mainPage.bunsBtnClick().getActiveTabText());

    }

    @After
    public void clear(){
        driver.close();
        driver.quit();
        userSteps.deleteUser();
    }
}
