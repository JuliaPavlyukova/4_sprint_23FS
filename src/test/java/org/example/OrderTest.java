package org.example;

import org.example.pageObject.HomePage;
import org.example.pageObject.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.example.constants.Constants.*;


@RunWith(Parameterized.class)
public class OrderTest extends BaseMethodsForTests {

    @Parameterized.Parameters(name = "Тестовые данные: name - {0}; surname - {1}; address - {2}; metro - {3};  phoneNumber - {4}; date- {5};  rentaPeriod - {6}; color - {7}; comment - {8} ")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Света", "Петрова", "Москва, ул. Осташковская 44", "Медведково", "89876543210", "15.05.2025", "сутки", COLOR_BLACK, "Сообщить о доставке"},
                {"Денис", "Арбузов", "Москва, ул. Люсиновская 10", "Октябрьская", "89638527410", "20.06.2025", "семеро суток", COLOR_GREY, "позвоните за пол часа"},
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public String name;

    @Parameterized.Parameter(1)
    public String surname;

    @Parameterized.Parameter(2)
    public String address;

    @Parameterized.Parameter(3)
    public String metro;

    @Parameterized.Parameter(4)
    public String phoneNumber;

    @Parameterized.Parameter(5)
    public String date;

    @Parameterized.Parameter(6)
    public String rentaPeriod;

    @Parameterized.Parameter(7)
    public String color;

    @Parameterized.Parameter(8)
    public String comment;

    @Test
    public void OrderPositiveTest() {

        // Создать объект класса с домашней страницей
        HomePage objHomePage = new HomePage(driver);
        // Принять куки
        objHomePage.clickAcceptCookieButton();
        // Нажать на кнопку Заказать в Header
        objHomePage.clickButtonHeader();
        // Создать объект класса со страницей заказа
        OrderPage objOrderPage = new OrderPage(driver);

        // Позитивный сценарий оформления заказа

        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setMetro(metro);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentaPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();
        objOrderPage.getConfirmHeader();
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), VIEW_STATUS);
    }
}

