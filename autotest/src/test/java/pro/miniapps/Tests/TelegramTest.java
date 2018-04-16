package pro.miniapps.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.*;

import java.util.concurrent.TimeUnit;

public class TelegramTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static BotPage botPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/aguseva/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        botPage = new BotPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://gussd-lk-test.eyeline.mobi/");

    }

    @Test
    public void TelegramTest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        botPage.clickActBot();
        botPage.clickTG();
        botPage.inputToken();
        botPage.clickConfBtn();
        botPage.switchToW();
        String confTxt = botPage.getConfTxt();
        System.out.println(confTxt);
        Assert.assertEquals("Telegram успешно подключен", confTxt);
        botPage.clickDel();
        botPage.clickDelBtn();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }
}
