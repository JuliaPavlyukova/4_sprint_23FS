package org.example;


import org.example.pageObject.HomePage;
import org.example.pageObject.OrderPage;
import org.junit.Test;

import static org.example.constants.Constants.*;

public class ButtonOrderTest extends BaseMethodsForTests {

    @Test
    public void HeaderButtonOpenOrderPageTest() {
        HomePage objHomePage = new HomePage(driver);                           // объект класса домашней страницей
        objHomePage.clickButtonHeader();                                        // Клик на кнопку Заказать в хедере
        OrderPage objOrderPage = new OrderPage(driver);                        // объект класса со страницей заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader(), HEADER_ORDER);   // Проверка, что страница заказа открылась
    }

    @Test
    public void MiddleButtonOpenOrderPageTest() {
        HomePage objHomePage = new HomePage(driver);                            // Создать объект класса с домашней страницей
        objHomePage.clickButtonMiddle();                                        //Клик на кнопку Заказать в хедере
        OrderPage objOrderPage = new OrderPage(driver);                         // объект класса со страницей заказа
        objOrderPage.isPageOpen(objOrderPage.getOrderHeader(), HEADER_ORDER);   // Проверка, что страница заказа открылась
    }
}
