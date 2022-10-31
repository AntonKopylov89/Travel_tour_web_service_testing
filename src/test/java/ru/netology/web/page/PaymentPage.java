package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {

    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $(byText("Владелец")).parent().$(".input__control");
    private SelenideElement cvcCvvField = $("[placeholder='999']");
    private SelenideElement continueButton = $$(".button").find(exactText("Продолжить"));
    private SelenideElement successNotification = $(".notification_status_ok .notification__content");
    private SelenideElement errorNotification = $(".notification_status_error .notification__content");
    private SelenideElement wrongFormatNotification = $(".input__sub");

    public void cardInformationForPayment(DataHelper.PaymentInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getCardHolder());
        cvcCvvField.setValue(info.getCvv());
        continueButton.click();
    }

    public void continueButtonClick () {
        continueButton.click();
    }


    public void paymentSuccessNotification() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void paymentNotSuccessNotification() {
        errorNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void wrongFieldFormatNotification() {
        wrongFormatNotification.shouldBe(visible);
    }



}
