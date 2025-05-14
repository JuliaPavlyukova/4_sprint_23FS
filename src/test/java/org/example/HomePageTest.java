package org.example;

import org.example.pageobject.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.example.constants.Constants.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HomePageTest extends BaseMethodsForTests {
    @Parameterized.Parameters(name = "Тест {0}")
    public static Object[] data() {
        return new Object[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    @Parameterized.Parameter // first data value (0) is default
    public int testNum;

    @Test
    public void homePageTest() {

        //создаем объект класса HomePage
        HomePage objHomePage = new HomePage(driver);
        //скролл к блоку вопросов
        objHomePage.scrollToImportantQuestions();
        //акцепт кук
        objHomePage.clickAcceptCookieButton();
        //проверка ответов
        String answerConstanta = objHomePage.checkAnswer(testNum);
        // Сравнение результата
        assertEquals(answerConstanta, ANSWER_TEXTS[testNum]);
    }
}



