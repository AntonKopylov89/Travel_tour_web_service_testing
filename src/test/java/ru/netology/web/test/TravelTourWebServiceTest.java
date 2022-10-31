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
    void shouldHighlightPayButton() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
   }
    
    @Test
    void shouldHighlightCreditPayButton() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
   }

    @Test
    void shouldSuccessPayDebetCard() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var validCardInformation = DataHelper.getValidCardInformation();
        paymentPage.cardInformationForPayment(validCardInformation);
        paymentPage.paymentSuccessNotification();

    }
    
    @Test
    void shouldSuccessPayByCredit() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var validCardInformation = DataHelper.getValidCardInformation();
        paymentPage.cardInformationForPayment(validCardInformation);
        paymentPage.paymentSuccessNotification();


    }
    
    @Test
    void shouldDeclinePayDebetCard() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var declinedCardInformation = DataHelper.getDeclinedCardNumber();
        paymentPage.cardInformationForPayment(declinedCardInformation);
        paymentPage.paymentNotSuccessNotification();

    }
    
     @Test
     void shouldDeclinePayByCredit() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var declinedCardInformation = DataHelper.getDeclinedCardNumber();
        paymentPage.cardInformationForPayment(declinedCardInformation);
        paymentPage.paymentNotSuccessNotification();

    }
    
    @Test
    void shouldErrorPayDebetCardWithEmptyFields() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        paymentPage.continueButton.click();
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
    void shouldErrorPayByCreditWithEmptyFields() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        paymentPage.continueButton.click();
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
    void shouldPayDebetCardWithWrongNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.paymentNotSuccessNotification();

    }
    
    @Test
    void shouldPayByCreditWithWrongNumberCard() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.paymentNotSuccessNotification();

    }
    
     @Test
     void shouldPayDebetCardWithInvalidNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
     void shouldPayByCreditWithInvalidCardNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
     void shouldPayDebetCardWithEmptyNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
     void shouldPayByCreditWithEmptyCardNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
     void shouldPayDebetCardWithInvalidMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    @Test
     void shouldPayByCreditWithEmptyCardNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();

    }
    
    
}
