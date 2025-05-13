package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


public class HomePage {

    private WebDriver driver;

    //             *** ЛОКАТОРЫ КНОПОК ***
//  кнопка «Заказать» Button_Button__ra12g в Header
    private By buttonHeader = By.cssSelector(".Button_Button__ra12g");
    //  кнопка «Заказать» Button_Button__ra12g Button_Middle__1CSJM в центре
    private By buttonMiddle = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
//Заполнить форму заказа

    //             *** ЛОКАТОР КУКИ ***
    private By acceptCookieButton = By.cssSelector(".App_CookieButton__3cvqF");

    //конструктор
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //_________________МЕТОДЫ_______________________
    //клик по кнопке "Заказать" в Header
    public void clickButtonHeader() {
        driver.findElement(buttonHeader).click();
    }

    // клик и скролл для кнопки Заказать, в Middle под блоком Как это работает
    public void clickButtonMiddle() {
        WebElement buttonMiddleWe = driver.findElement(buttonMiddle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", buttonMiddleWe);
        driver.findElement(buttonMiddle).click();
    }

    //клик по кнопке Куки "да все привыкли"
    public void clickAcceptCookieButton() {
        driver.findElement(acceptCookieButton).click();
    }

    //метод клик по вопросу
    public void clickQestion(String question) {
        By questionBy = By.xpath(question);
        driver.findElement(questionBy).click();
    }

    //Метод получения текста: ждем отображение элемента, возвращаем текст
    public String getTextAnswer(String answer) {
        By answerBy = By.id(answer);
        //ждем элемент
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(answerBy));
        //получаем текст
        String answerText = driver.findElement(answerBy).getText();
        return answerText;
    }

    // ИТОГОВЫЙ ШАГ
    //клик по вопросу, получение текста вопроса, сравнение с константой
    public void checkAnswer(String question, String answer, String answerConstanta) {
        //Кликаем по кнопке
        clickQestion(question);
        // Получаем ответ
        String answerText = getTextAnswer(answer);
        // Ожидание загрузки элемента
        System.out.println("answerConstanta   answerText " + answerConstanta + " " + answerText);
        // Сравнение результата
        assertEquals(answerConstanta, answerText);
    }
}

