package yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private final WebDriver driver;
    private final By enterButton = By.xpath(".//a[text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
}
