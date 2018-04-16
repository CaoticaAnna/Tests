package pro.miniapps.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.*;

import java.util.concurrent.TimeUnit;

public class TopUpTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static BillingPage billingPage;
    public static PaymentDetailsPage paymentDetailsPage;
    public static BotPage botPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/aguseva/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        billingPage = new BillingPage(driver);
        botPage = new BotPage(driver);
        paymentDetailsPage = new PaymentDetailsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://gussd-lk-test.eyeline.mobi/");
    }

    @Test
    public void TopUpTest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        profilePage.entryMenu();
        profilePage.toBilling();
        billingPage.topUpBalance();
        billingPage.sum();
        billingPage.clickTopUpBtn();
        driver.switchTo().frame("add_payment_profile_form:iframe");
        paymentDetailsPage.inputCardNum();
        paymentDetailsPage.inputCardInfo();
        paymentDetailsPage.saveClick();
        botPage.switchToW();
        String successTxt = paymentDetailsPage.confirmation();
        System.out.println(successTxt);
        Assert.assertEquals("Кошелёк успешно пополнен", successTxt);

    }
    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }
}
