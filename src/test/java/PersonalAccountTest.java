import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import yandex.praktikum.BaseTest;
import yandex.praktikum.LoginPage;
import yandex.praktikum.MainPage;
import yandex.praktikum.PersonalAccountPage;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest extends BaseTest {
    MainPage mainPage = new MainPage(getDriver());
    LoginPage loginPage = new LoginPage(getDriver());
    PersonalAccountPage personalAccountPage = new PersonalAccountPage(getDriver());

    @Before
    public void openPage() {
        openUrl();
        clickEnterOnMainPage();
        login();
    }

    @Test
    @DisplayName("Проверка возможности перехода в личный кабинет")
    public void clickOnPersonalAccount() {
        clickPersonalAccount();
        assertEquals("Выход", personalAccountPage.logoutButtonText());
    }

    @Test
    @DisplayName("Проверка нажатия на логотип из личного кабинета")
    public void clickOnLogo() {
        clickPersonalAccount();
        personalAccountPage.clickLogo();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Проверка возможности перехода в конструктор из личного кабинета")
    public void clickOnConstructorButton() {
        clickPersonalAccount();
        personalAccountPage.clickConstructorButton();
        assertEquals("Соберите бургер", mainPage.textOfChooseBurger());
    }

    @Test
    @DisplayName("Проверка возможности выхода из аккаунта")
    public void successfulLogout() {
        clickPersonalAccount();
        personalAccountPage.clickLogoutButton();
        assertEquals("Войти", loginPage.buttonEnterText());
    }

    @After
    public void quitDriver() {
        baseAfter(getDriver());
    }
}