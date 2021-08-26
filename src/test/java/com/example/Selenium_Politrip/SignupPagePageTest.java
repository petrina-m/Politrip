package com.example.Selenium_Politrip;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.*;

import static com.codeborne.selenide.Selenide.*;

public class SignupPagePageTest {
    //MainPage mainPage = new MainPage();
    SignupPage signupPage=new SignupPage();


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://politrip.com/account/sign-up");
    }




    @Test
    public void signUpParticipant() throws InterruptedException {

        $("#first-name").sendKeys("R");
        $("#last-name").sendKeys("M");
        $("#email").sendKeys("asf@a.a");
        $("#sign-up-password-input").sendKeys("123456aA");
        $("#sign-up-confirm-password-input").sendKeys("123456aA");

        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.click();
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signupPage. dataAgreementButton.scrollIntoView(true);
        signupPage.participantButton.click();


    }

    @Test
    public void signUpOrganizer() throws InterruptedException {

        $("#first-name").sendKeys("R");
        $("#last-name").sendKeys("M");
        $("#email").sendKeys("asf@a.c");
        $("#sign-up-password-input").sendKeys("123456aA");
        $("#sign-up-confirm-password-input").sendKeys("123456aA");
        $("#sign-up-heard-input").selectOption(1);

        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.click();
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signupPage. participantButton.scrollIntoView(true);
        signupPage.organizerButton.click();

    }
    @Test
    public void signUpPersonalDataDisagreement() throws InterruptedException {

        $("#first-name").sendKeys("R");
        $("#last-name").sendKeys("M");
        $("#email").sendKeys("asf@a.d");
        $("#sign-up-password-input").sendKeys("123456aA");
        $("#sign-up-confirm-password-input").sendKeys("123456aA");

        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.click();
        getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signupPage.dataAgreementButton.click();
        signupPage. organizerButton.scrollIntoView(true);
        signupPage. participantButton.scrollIntoView(true);
        signupPage.organizerButton.shouldHave(attribute("box-shadow", ""));

    }
    @Test
    public void signUpUserAlreadyExistsError()  {
        $("#first-name").sendKeys("R");
        $("#last-name").sendKeys("M");
        $("#email").sendKeys("petrinamaz@yahoo.com");
        $("#sign-up-password-input").sendKeys("123456aA");
        $("#sign-up-confirm-password-input").sendKeys("123456aA");

        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.click();
        $("#sign-up-error-div").shouldBe(visible);
    }

    @Test
    public void fbLogo_Redirects()  {
        String urlPolitrip=getWebDriver().getCurrentUrl();
        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.scrollIntoView(true);

        signupPage. facebookButton.click();
        //getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      //  String urlFacebook=getWebDriver().getCurrentUrl();
      //  Assert.assertNotEquals(urlFacebook, urlPolitrip);


    }


    @Test
    public void instaLogo_Redirect()  {

        signupPage. acceptCookiesButton.click();
        signupPage. signUpButton.scrollIntoView(true);

        signupPage. instragramButton.click();


    }


    @Test
    public void emailInvalidEnd()  {
        $("#email").sendKeys("aaa@s.");
        $("#sign-up-password-input").sendKeys("aaa@s.");

        $x("//span[text() = ' Please enter a valid email address ']").shouldBe(visible);
    }
    @Test
    public void emailInvalid()  {

        $("#email").sendKeys("aaa.ae");
        $("#sign-up-password-input").sendKeys("aaa@s.");

        $x("//span[text() = ' Please enter a valid email address ']").shouldBe(visible);

    }


    @Test
    public void passwordInvalidLessThan8()  {
        $("#sign-up-password-input").sendKeys("Alad1");
        $("#sign-up-confirm-password-input").sendKeys("a");

        $x("//span[text() = ' Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit ']").shouldBe(visible);
    }

    @Test
    public void passwordInvalidNoUpperLetter()  {
        $("#sign-up-password-input").sendKeys("aladin12");
        $("#sign-up-confirm-password-input").sendKeys("a");

        $x("//span[text() = ' Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit ']").shouldBe(visible);
    }

    @Test
    public void passwordInvalidNoLowercaseLetter()  {
        $("#sign-up-password-input").sendKeys("ALADIN12");
        $("#sign-up-confirm-password-input").sendKeys("a");

        $x("//span[text() = ' Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit ']").shouldBe(visible);
    }

    @Test
    public void passwordInvalidNoDigit()  {
        $("#sign-up-password-input").sendKeys("ALADINnn");
        $("#sign-up-confirm-password-input").sendKeys("a");

        $x("//span[text() = ' Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit ']").shouldBe(visible);
    }

    @Test
    public void passwordValid()  {
        $("#sign-up-password-input").sendKeys("Aladin12");
        $("#sign-up-confirm-password-input").sendKeys("a");

        $x("//span[text() = ' Password must contain at least 8 characters, 1 uppercase letter, 1 lowercase letter and 1 digit ']").shouldBe(hidden);
    }



    @Test
    public void passwordsUnmatch()  {

            $("#sign-up-password-input").sendKeys("ALadin12");
            $("#sign-up-confirm-password-input").sendKeys("Aladin12");
            $("#sign-up-heard-input").selectOption(1);

            $x("//span[text() = ' Passwords must match ']").shouldBe(visible);
        }








}
