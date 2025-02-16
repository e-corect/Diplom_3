import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import practicum.pages.LoginPage;
import practicum.pages.MainPage;
import practicum.pages.PersonalAccountPage;

import static practicum.Constants.USER_PWD;
import static practicum.WebDriverFactory.getDriver;

public class MainPageTests {
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
    public void bunsBtnClick(){
        mainPage.saucesBtnClick();
        mainPage.bunsBtnClick().scrollIngredientsMenu();
        Assert.assertTrue(mainPage.isHeaderVisible());
    }

    @Test
    public void saucesBtnTest() {
        mainPage.saucesBtnClick();
        Assert.assertTrue(mainPage.isSaucesBtnPushed());
    }

    @Test
    public void fillingsBtnClick(){
        mainPage.fillingsBtnClick();
        Assert.assertTrue(mainPage.isFillingsBtnPushed());
    }

    @After
    public void clear(){
        driver.close();
        driver.quit();
        userSteps.deleteUser();
    }
}
