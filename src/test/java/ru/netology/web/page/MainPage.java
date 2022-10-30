package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement buyButton = $$(".button").find(exactText("Купить"));
    private SelenideElement creditBuyButton = $$(".button").find(exactText("Купить в кредит"));
    private SelenideElement paymentHeading = $$(".heading").get(2);

    public PaymentPage payButtonClick() {
        buyButton.click();
        paymentHeading.shouldHave(exactText("Оплата по карте"));
        return new PaymentPage();
    }

    public PaymentPage payByCreditCard() {
        creditBuyButton.click();
        paymentHeading.shouldHave(exactText("Кредит по данным карты"));
        return new PaymentPage();
    }
}
