import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.praktikum.Constructor.User;
import yandex.praktikum.LoginPage;
import yandex.praktikum.MainPage;
import yandex.praktikum.RegistrationPage;
import yandex.praktikum.RestorePasswordPage;
import yandex.praktikum.helper.DeleteUser;
import yandex.praktikum.helper.RegistrationUser;

import static yandex.praktikum.helper.UserData.defaultUserData;

@DisplayName("Проверка антуфикации пользователя")
public class LoginTest extends TestBase {
    private static User user;
    private static final DeleteUser deleteUser = new DeleteUser();
    private static final RegistrationUser registrationUser = new RegistrationUser();

    @Before
    public void setUp() {
        Configuration.headless = true;
        optionBrowser("chrome");
        user = defaultUserData();
        registrationUser.registrationUser();
    }

    @Test
    @DisplayName("Аутентификация по кнопке Войти в аккаунт» на главной")
    public void authUserLoginPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/login");
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void authUserMainPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/");
        new MainPage().clickPersonalAccountButton().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void authUserRegistrationPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/register");
        new RegistrationPage().clickEnterButton().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void authUserPasswordRecoveryPage() {
        Selenide.open("https://stellarburgers.nomoreparties.site/forgot-password");
        new RestorePasswordPage().clickEnter().checkLoginPage();
        new LoginPage()
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .clickEnter()
                .checkSuccessfulLogin();
    }

    @After
    public void teardown() {
        Selenide.closeWebDriver();
        deleteUser.deleteDefaultUser();
    }
 }

