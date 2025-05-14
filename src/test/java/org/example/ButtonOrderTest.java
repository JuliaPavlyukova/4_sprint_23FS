package org.example;

import org.example.pageobject.HomePage;
import org.example.pageobject.OrderPage;
import org.junit.Assert;
import org.junit.Test;

import static org.example.constants.Constants.*;

public class ButtonOrderTest extends BaseMethodsForTests {

    @Test
    public void HeaderButtonOpenOrderPageTest() {
        HomePage objHomePage = new HomePage(driver);                           // объект класса домашней страницей
        objHomePage.clickButtonHeader();                                       // Клик на кнопку Заказать в хедере
        OrderPage objOrderPage = new OrderPage(driver);                        // объект класса со страницей заказа
        String headerButton = objOrderPage.getOrderHeader();                    //получение текста со страницы формы заказа
        Assert.assertEquals(HEADER_ORDER, headerButton);                        // Проверка, что страница заказа открылась

    }

    @Test
    public void MiddleButtonOpenOrderPageTest()  {
        HomePage objHomePage = new HomePage(driver);                            // Создать объект класса с домашней страницей
        objHomePage.clickButtonMiddle();                                        //Клик на кнопку Заказать в хедере
        OrderPage objOrderPage = new OrderPage(driver);                         // объект класса со страницей заказа
        String middleButton = objOrderPage.getOrderHeader();                    //получение текста со страницы формы заказа
        Assert.assertEquals(HEADER_ORDER, middleButton);                        // Проверка, что страница заказа открылась
    }
}
