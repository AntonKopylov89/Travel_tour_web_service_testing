package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {

    private DataHelper() {}
    static Faker faker = new Faker(new Locale("en"));
    static Random random = new Random();

    @Value
    public static class PaymentInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String cardHolder;
        private String cvv;
    }

    public static String generateMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public String generateWrongMonth(int month) {
        return LocalDate.now().minusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
    }

    public String generateWrongYear(int year) {
        return LocalDate.now().minusYears(year).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static PaymentInfo getValidCardInformation() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getDeclinedCardNumber() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4442", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getWrongCardNumber() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 1111", month, year, faker.name().fullName(), "123");
    }
    
     public static PaymentInfo getInvalidCardNumber() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 111", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getEmptyCardNumber() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getInvalidMonth() {
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", "15", year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getExpiredMonth() {
        String month = generateWrongMonth(2);
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getInvalidMonthWithText() {
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", "AB", year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getEmptyMonth() {
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", "", year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getInvalidYear() {
        String month = generateMonth();
        return new PaymentInfo("4444 4444 4444 4441", month, "AB", faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getExpiredYear() {
        String month = generateMonth();
        String year = generateWrongYear(5);
        return new PaymentInfo("4444 4444 4444 4441", month, year, faker.name().fullName(), "123");
    }
    
    public static PaymentInfo getEmptyYear() {
        String month = generateMonth();
        return new PaymentInfo("4444 4444 4444 4441", month, "", faker.name().fullName(), "123");
    }
    
     public static PaymentInfo getWrongCardHolderLanguage() {
        String month = generateMonth();
        String year = generateYear();
        return new PaymentInfo("4444 4444 4444 4441", month, year, "Иванов Иван", "123");
    }




}
