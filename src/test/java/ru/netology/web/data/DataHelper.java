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
        private String owner;
        private String cvv;
    }

    public static String generateMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public String generateWrongMonth(int month) {
        return LocalDate.now().minusMonths(month).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public String generateWrongYear(int year) {
        return LocalDate.now().minusYears(year).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
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
        return new PaymentInfo("4444 4444 4444 1111", "15", year, faker.name().fullName(), "123");
    }




}
