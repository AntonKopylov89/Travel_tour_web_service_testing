package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import lombok.val;
import org.junit.jupiter.api.*;
import io.qameta.allure.selenide.AllureSelenide;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.MainPage;
import ru.netology.web.page.PaymentPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
public class TravelTourWebServiceTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        String appUrl = System.getProperty("app.url");
        open(appUrl);
    }

    @AfterEach
    void closeWebBrowser() {
        closeWebDriver();
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessPayDebetCard () {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var validCardInformation = DataHelper.getValidCardInformation();
        paymentPage.cardInformationForPayment(validCardInformation);
        paymentPage.paymentSuccessNotification();


    }
}
