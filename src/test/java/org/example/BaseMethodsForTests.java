package org.example;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.example.constants.Constants.testURL;

public class BaseMethodsForTests {
    WebDriver driver;

    @Before
    public void startUp() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
        driver.get(testURL);                                                  //получение ссылки на страницу входа из файла настроек
//
        driver.manage().window().maximize();                                //окно разворачивается на полный экран
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);    //задержка на выполнение теста = 5 сек.
    }

    //Завершение теста
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
