package practicum;

public class Constants {
    public static final String CHROME_DRIVER_PATH = "C:\\Webdriver\\bin\\chromedriver.exe";
    public static final String YANDEX_DRIVER_PATH = "C:\\Webdriver\\bin\\yandexdriver.exe";

    public static final String CHROME_DRIVER_PROPERTY_NAME = "webdriver.chrome.driver";
    public static final String YANDEX_DRIVER_PROPERTY_NAME = "webdriver.yandex.driver";


    public static final String SITE_URL = "https://stellarburgers.nomoreparties.site/";

    //// Элементы общей верхней панели
    public static final String CONSTRUCTOR_BTN_XPATH = ".//p[text()='Конструктор']";
    public static final String ORDERS_FEED_BTN_XPATH = ".//*[text()='Лента Заказов']";
    public static final String LOGO_XPATH = ".//div[@class = 'AppHeader_header__logo__2D0X2']/a";
    public static final String PERSONAL_AREA_BTN_XPATH = ".//p[text()='Личный Кабинет']";

    //// Элементы главной страницы
    public static final String ENTER_ACCOUNT_BTN_XPATH = ".//button[text()='Войти в аккаунт']";
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

    //// Элементы страницы login
    public static final String REGISTER_LINK_TEXT = "/register";
    public static final String RECOVER_PWD_TEXT = "/forgot-password";
    public static final String INPUT_EMAIL_XPATH = ".//div/input[@name='name']";
    public static final String INPUT_PWD_XPATH = ".//div/input[@name='Пароль']";
    public static final String ENTER_BTN_XPATH = ".//button[text()='Войти']";
    public static final String WRONG_PWD_MSG_XPATH = ".//p[text()='Некорректный пароль']";
}
