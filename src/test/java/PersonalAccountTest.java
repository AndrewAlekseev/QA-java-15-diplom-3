import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.praktikum.Constructor.User;
import yandex.praktikum.LoginPage;
import yandex.praktikum.MainPage;
import yandex.praktikum.PersonalAccountPage;
import yandex.praktikum.helper.DeleteUser;
import yandex.praktikum.helper.RegistrationUser;

import static yandex.praktikum.helper.UserData.defaultUserData;

@DisplayName("Проверка личного кабинета")
public class PersonalAccountTest extends TestBase{
    private static User user;
    private final DeleteUser deleteUser = new DeleteUser();
    private final RegistrationUser registrationUser = new RegistrationUser();

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        user = defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Переход по клику на Личный кабинет")
    public void loginPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new PersonalAccountPage().checkSuccessfulAccountLogin();
    }

    @Test
    @DisplayName("Переход по клику на Конструктор")
    public void transitionToConstructor() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new PersonalAccountPage().checkSuccessfulAccountLogin()
                .clickConstructorButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Переход по клику на Stellar Burgers")
    public void transitionToLogo() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new PersonalAccountPage().checkSuccessfulAccountLogin()
                .clickLogoButton().checkTransitionMainPage();
    }

    @Test
    @DisplayName("Выход по кнопке Выйти в личном кабинете")
    public void exitFromPersonalAccount() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
        new MainPage().clickPersonalAccountButton();
        new PersonalAccountPage().checkSuccessfulAccountLogin()
                .clickExitButton().checkExitPersonalAccount();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        deleteUser.deleteDefaultUser();
    }
}