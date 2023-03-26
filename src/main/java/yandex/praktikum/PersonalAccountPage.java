package yandex.praktikum;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.containsString;

public class PersonalAccountPage {
    private final SelenideElement profileNavButton = $(byXpath(".//a[text()='Профиль']"));
    private final SelenideElement constructorNavButton = $(byXpath(".//p[text()='Конструктор']"));
    private final SelenideElement exitNavButton = $(byXpath(".//button[text()='Выход']"));
    private final SelenideElement createBurgerCheck = $(byXpath(".//h1[@class = 'text text_type_main-large mb-5 mt-10']"));
    private final SelenideElement logoButton = $(byXpath("//div[@class='AppHeader_header__logo__2D0X2']/a"));
    private final SelenideElement enterText = $(byXpath(".//h2[text() = 'Вход']"));

    @Step("нажать на кнопку профиля")
    public PersonalAccountPage clickProfileButton() {
        profileNavButton.click();
        return this;
    }
    @Step("нажать на кнопку конструктора")
    public PersonalAccountPage clickConstructorButton() {
        constructorNavButton.click();
        return this;
    }
    @Step("нажать кнопку выхода")
    public PersonalAccountPage clickExitButton() {
        exitNavButton.click();
        return this;
    }
    @Step("нажать на логотип")
    public PersonalAccountPage clickLogoButton() {
        logoButton.click();
        return this;
    }

    @Step("проверка аутентифицированного пользователя")
    public PersonalAccountPage checkSuccessfulAccountLogin() {
        Assert.assertThat(profileNavButton.getText(),containsString("Профиль"));
        return this;
    }
    @Step("Проверка перехода на главную страницу")
    public void checkTransitionMainPage() {
        Assert.assertThat(createBurgerCheck.getText(),containsString("Соберите бургер"));
    }
    @Step("проверка выхода из личного кабинета")
    public void checkExitPersonalAccount() {
        Assert.assertThat(enterText.getText(),containsString("Вход") );
    }
}
