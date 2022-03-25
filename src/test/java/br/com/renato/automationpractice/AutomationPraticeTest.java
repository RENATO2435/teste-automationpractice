package br.com.renato.automationpractice;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Select;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomationPraticeTest {
    AutomationPraticeMainPage page = new AutomationPraticeMainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://automationpractice.com/");
    }

    @Test
    public void adItems() {
        addPrintedChiffonDressToCart();
        addFadedShortSleeveTShirtToCart();
        addBlouseToCart();
        addPrintedDressToCart();

    }

    private void fillAndSearch(String term) {
        page.searchField.clear();
        page.searchField.sendKeys(term);
        page.searchButton.click();
    }

    private void choiceColor(String color) {
        $x("//a[@class = 'color_pick' and @title = '"+color+"']").click();
    }

    private void addToCart() {
        $("div.box-cart-bottom").find("button").click();
    }

    private void choiceItem(String item) {
        $x("//a[@title = '"+item+"']").click();
    }

    private void setQuantity(String quantity) {
        SelenideElement input = $("#quantity_wanted");
        input.clear();
        input.sendKeys(quantity);
    }

    private void setSize(String size) {
        Select selectSize = new Select($("#group_1"));
        selectSize.selectByVisibleText(size);
    }


    private void addPrintedChiffonDressToCart() {
        String item = "Printed Chiffon Dress";
        fillAndSearch(item);
        choiceItem(item);
        setSize("M");
        choiceColor("Green");
        addToCart();

    }

    private void addFadedShortSleeveTShirtToCart() {
        String item = "Faded Short Sleeve T-shirts";
        fillAndSearch(item);
        choiceItem(item);
        choiceColor("Blue");
        addToCart();
    }

    private void addBlouseToCart() {
        String item = "Blouse";
        fillAndSearch(item);
        choiceItem(item);
        setQuantity("2");
        addToCart();
    }

    private void addPrintedDressToCart() {
        String item = "Printed Dress";
        fillAndSearch(item);
        choiceItem(item);
        addToCart();
    }




}
