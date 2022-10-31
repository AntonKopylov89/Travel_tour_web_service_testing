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
    void shouldErrorPayDebetCardWithWrongNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.paymentNotSuccessNotification();
        
    }
    
    @Test
    void shouldErrorPayByCreditWithWrongNumberCard() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.paymentNotSuccessNotification();
        
    }
    
     @Test
     void shouldErrorPayDebetCardWithInvalidNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithInvalidCardNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithEmptyNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithEmptyCardNumber() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardNumber();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithInvalidMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithInvalidMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
     @Test
     void shouldErrorPayDebetCardWithExpiredMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getExpiredMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithExpiredMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getExpiredMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
     @Test
     void shouldErrorPayDebetCardWithTextInMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonthWithText();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithTextInMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidMonthWithText();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithEmptyMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithEmptyMonth() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyMonth();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
     @Test
     void shouldErrorPayDebetCardWithIvalidYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithInvalidYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
     @Test
     void shouldErrorPayDebetCardWithExpiredYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getExpiredYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithExpiredYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getExpiredYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithEmptyYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithEmptyYear() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyYear();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithWrongCardHolderLanguage() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardHolderLanguage();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithWrongCardHolderLanguage() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getWrongCardHolderLanguage();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithInvalidCardHolder() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardHolder();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithInvalidCardHolder() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCardHolder();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
     @Test
     void shouldErrorPayDebetCardWithEmptyCardHolder() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardHolder();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithEmptyCardHolder() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCardHolder();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithInvalidCVV() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCVV();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithInvalidCVV() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getInvalidCVV();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayDebetCardWithEmptyCVV() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCVV();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
    
    @Test
     void shouldErrorPayByCreditWithEmptyCVV() {
        var mainPage = new MainPage();
        var paymentPage = mainPage.payByCreditButtonClick();
        var wrongCardInformation = DataHelper.getEmptyCVV();
        paymentPage.cardInformationForPayment(wrongCardInformation);
        paymentPage.wrongFieldFormatNotification();
    }
        
}
