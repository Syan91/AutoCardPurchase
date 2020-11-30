package ru.netology.selenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


 class CardPurchaseTestNegative {

     @Test
     void ShouldNotPurchaseIfOnlyName() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("иван");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = name].input_invalid.input_sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
     }
     @Test
     void ShouldNotPurchaseIfOnlySurname() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("иванов");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = name].input_invalid.input_sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
     }
     @Test
     void ShouldNotPurchaseIfPhoneFormatWrong() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("89284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
     }
     @Test
     void ShouldNotPurchaseWithoutAgreement() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[type= button").click();
         $("[data-test-id=agreement].input_invalid .checkbox__text").shouldHave(Condition.text("Я соглашаюсь с условиями обработки"));
     }
     @Test
     void ShouldNotPurchaseWithEmptyForm() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[type= button").click();
         $(".input_invalid .input__sub").shouldHave(Condition.text("Поле обязательно для заполнения"));
     }
     @Test
     void ShouldNotPurchaseWithoutPhone() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
     }
     @Test
     void ShouldNotPurchaseWithoutNameAndSurname() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id=name].input_invalid .input__sub").shouldHave(Condition.text("Поле обязательно для заполнения"));
     }
     @Test
     void ShouldNotPurchaseWithProhibitedSymbolsInNameAndSurname() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Ivanov Ivan 21");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id=name].input_invalid .input__sub").shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
     }
     @Test
     void ShouldNotPurchaseWithPhoneNumberOfTen() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("+7928432222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
     }
     @Test
     void ShouldNotPurchaseWithPhoneOnlyOneNumber() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("+7");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
     }
     @Test
     void ShouldNotPurchaseIfPhoneWithLetters() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("Иванов Иван");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
     }
     @Test
     void ShouldNotPurchaseWithPhoneNumberOfEleven() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Иванов Иван");
         form.$("[data-test-id= phone] input").setValue("+792843222222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id = phone].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
     }
     @Test
     void ShouldNotPurchaseIfNameOfEightyLetters() {
         open("http://localhost:9999");
         SelenideElement form = $("[action]");
         form.$("[data-test-id = name] input").setValue("Ивааааааааааааааааааааааааааааааааааааааан Иванооооооооооооооооооооооооооооооооов");
         form.$("[data-test-id= phone] input").setValue("+79284322222");
         form.$("[data-test-id = agreement]").click();
         form.$("[type= button").click();
         $("[data-test-id=name].input_invalid .input__sub").shouldHave(Condition.text("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
     }
 }