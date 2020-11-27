package ru.netology.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

 class CardPurchaseTest {

  @Test
  void ShouldPurchaseCard(){
   open("http://localhost:9999");
   SelenideElement form = $ ("[action]");
   form.$("[data-test-id = name] input" ).setValue("Иван");
   form.$("[data-test-id= phone] input").setValue("+89284322222");
   form.$("[data-test-id = agreement]").click();
   form.$("[type= button").click();
   $("[data-test-id = order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
  }
 }
