package org.example;

import org.example.pageObject.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.example.constants.Constants.*;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class HomePageTest extends BaseMethodsForTests {

    @Parameterized.Parameters(name = "Тестовые данные: question: {0}; answer: {1}; answerConstanta: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {".//div[@class='accordion__item'][1]", "accordion__panel-0", ANSWER_TEXTS[0]},
                {".//div[@class='accordion__item'][2]", "accordion__panel-1", ANSWER_TEXTS[1]},
                {".//div[@class='accordion__item'][3]", "accordion__panel-2", ANSWER_TEXTS[2]},
                {".//div[@class='accordion__item'][4]", "accordion__panel-3", ANSWER_TEXTS[3]},
                {".//div[@class='accordion__item'][5]", "accordion__panel-4", ANSWER_TEXTS[4]},
                {".//div[@class='accordion__item'][6]", "accordion__panel-5", ANSWER_TEXTS[5]},
                {".//div[@class='accordion__item'][7]", "accordion__panel-6", ANSWER_TEXTS[6]},
                {".//div[@class='accordion__item'][8]", "accordion__panel-7", ANSWER_TEXTS[7]}
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public String question;

    @Parameterized.Parameter(1)
    public String answer;

    @Parameterized.Parameter(2)
    public String answerConstanta;

    @Test
    public void homePageTest() {
        // Скролл до таблицы с вопросами
        WebElement importantQuestions = driver.findElement(By.cssSelector(".accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", importantQuestions);

        //создаем объект класса HomePage
        HomePage objHomePage = new HomePage(driver);
        //акцепт кук
        objHomePage.clickAcceptCookieButton();

        //скролл к каждому вопросу, чтоб разрешение экрана не влияло на открытие ответа
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", importantQuestions);
        objHomePage.checkAnswer(question, answer, answerConstanta);
    }
}



