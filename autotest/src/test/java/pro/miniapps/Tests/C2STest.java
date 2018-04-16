package pro.miniapps.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.*;

import java.util.concurrent.TimeUnit;

public class C2STest {
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
        paymentDetailsPage = new PaymentDetailsPage(driver);
        botPage = new BotPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://gussd-lk-test.eyeline.mobi/");
    }

    @Test
    public void C2STest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        botPage.clickActBot();
        botPage.clickC2S();
        botPage.clickC2S_actBtn();
        botPage.switchToW();
        String confTxt3 = botPage.getConfTxt3();
        System.out.println(confTxt3);
        Assert.assertEquals("Call2Service номер успешно подключен", confTxt3);
        botPage.clickDel3();
        botPage.clickDelBtn3();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }
}
