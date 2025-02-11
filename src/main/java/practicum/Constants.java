package practicum;

import java.util.Random;

public class Constants {
    /// Web Driver Properties
    public static final String CHROME_DRIVER_PATH = "C:\\Webdriver\\bin\\chromedriver.exe";
    public static final String YANDEX_DRIVER_PATH = "C:\\Webdriver\\bin\\yandexdriver.exe";
    public static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String YANDEX_DRIVER_PROPERTY_NAME = "webdriver.yandex.driver";
    /// URL & paths
    public static final String SITE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PATH = "/login";
    public static final String REG_PATH = "/register";
    public static final String ORDERS_FEED_PATH = "/feed";
    public static final String RECOVER_PWD_PATH = "/forgot-password";
    public static final String ACCOUNT_PROFILE_PATH = "account/profile";
    /// API
    public static final String AUTH_USER_PATH = "api/auth/user";
    public static final String USER_LOGIN_PATH = "api/auth/login";
    public static final String USER_REGISTER_PATH = "api/auth/register";
    /// Headers
    public static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    public static final String JSON_HEADER_VALUE = "application/json";

    /// Элементы общей верхней панели
    public static final String CONSTRUCTOR_BTN_XPATH = ".//p[text()='Конструктор']";
    public static final String ORDERS_FEED_BTN_XPATH = ".//*[text()='Лента Заказов']";
    public static final String LOGO_XPATH = ".//div[@class = 'AppHeader_header__logo__2D0X2']/a";
    public static final String PERSONAL_AREA_BTN_XPATH = ".//p[text()='Личный Кабинет']";

    /// Элементы главной страницы
    public static final String ENTER_ACCOUNT_BTN_XPATH = ".//div/button[text()='Войти в аккаунт']";
    // Заголовок Соберите бургер на главной
    public static final String ASSEMBLE_BURGER_HEADER_XPATH = ".//h1[text()='Соберите бургер']";
    public static final String BUNS_BTN_XPATH = ".//div/span[text()='Булки']";
    public static final String SAUCES_BTN_XPATH = ".//div/span[text()='Соусы']";
    public static final String FILLINGS_BTN_XPATH = ".//div/span[text()='Начинки']";
    // Краторная булка
    public static final String CRATOR_BUN_XPATH = ".//p[text()='Краторная булка N-200i']";
    // Соус Традиционный галактический
    public static final String GALAXY_SAUCE_XPATH = ".//p[text()='Соус традиционный галактический']";
    // Филе Люминесцентного тетраодонтимформа
    public static final String LUMIN_FILLING_XPATH = ".//p[text()='Филе Люминесцентного тетраодонтимформа']";
    /// Элементы страницы login
    public static final String LOGIN_HEADER_TEXT = ".//h2[text()='Вход']";
    public static final String REGISTER_LINK_TEXT = REG_PATH;

    public static final String INPUT_EMAIL_XPATH = ".//div/input[@name='name']";
    public static final String INPUT_PWD_XPATH = ".//div/input[@name='Пароль']";
    public static final String ENTER_BTN_XPATH = ".//button[text()='Войти']";
    public static final String RECOVER_PWD_LINK_XPATH = ".//a[text()='Восстановить пароль']";
    public static final String REG_BTN_XPATH = ".//button[text()='Зарегистрироваться']";
    /// Элементы страницы регистрации
    public static final String REG_HEADER_TEXT = ".//h2[text()='Регистрация']";
    public static final String USERNAME_INPUT_XPATH = ".//label[text() = 'Имя']//following-sibling::input";
    public static final String EMAIL_INPUT_XPATH = ".//label[text() = 'Email']//following-sibling::input";
    public static final String PWD_INPUT_XPATH = ".//div/input[@name='Пароль']";
    public static final String LOGIN_LINK_XPATH = ".//p/a[@href='/login' and text()='Войти']";
    public static final String WRONG_PWD_MSG_XPATH = ".//p[text()='Некорректный пароль']";
    public static final String WRONG_PWD_MSG = "Некорректный пароль";
    /// Элементы страницы личного кабинета
    public static final String LOGOUT_BTN_XPATH = ".//button[text()='Выход']";
    public static final String PROFILE_TAB_XPATH = ".//*[text() = 'Профиль']";


    public static final String USER_PWD = "Qwertys1234567";
    public static final String INCORRECT_USER_PWD = "123";
    public static final String[] FIRST_LVL_DOMAINS = {"example", "track", "template", "etc", "exe", "jpg", "ico", "rar"};



    public static String getDomain(){
        Random random = new Random();
        return FIRST_LVL_DOMAINS[random.nextInt(FIRST_LVL_DOMAINS.length)];
    }
}
