package com.example.Selenium_Politrip;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SignupPage {

    public SelenideElement signUpButton = $("button[type=\"submit\"]");
    public SelenideElement acceptCookiesButton = $x("//div[@id='cookiescript_accept']");
    public SelenideElement facebookButton = $x("//span[contains(@class, 'social-label') and text() = 'Facebook']");
    public SelenideElement participantButton =  $("#qa_signup-participant");
    public SelenideElement dataAgreementButton = $x("//span[contains(@class, 'square')]");
    public SelenideElement organizerButton =  $("#qa_signup-organizer");
    public SelenideElement instragramButton = $x("//span[contains(@class, 'social-label') and text() = 'Facebook']");
    public SelenideElement heardDropdown =  $("#sign-up-heard-input");




}
