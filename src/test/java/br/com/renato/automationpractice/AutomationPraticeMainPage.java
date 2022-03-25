package br.com.renato.automationpractice;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class AutomationPraticeMainPage {
    public SelenideElement homeLink = $("#header_logo > a");
    public SelenideElement searchField = $(".search_query.form-control.ac_input");
    public SelenideElement searchButton = $(".btn.btn-default.button-search");

}
