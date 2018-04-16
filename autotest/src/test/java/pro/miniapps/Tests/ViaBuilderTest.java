package pro.miniapps.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.LoginPage;
import pro.miniapps.Pages.ProfilePage;
import pro.miniapps.Pages.ViaBuilderPage;

import java.util.concurrent.TimeUnit;

public class ViaBuilderTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ViaBuilderPage viaBuilderPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/aguseva/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        viaBuilderPage = new ViaBuilderPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://gussd-lk-test.eyeline.mobi/");
    }
    @Test
    public void ViaBuilderTest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        profilePage.toCreate();
        profilePage.botViaBuilder();
        viaBuilderPage.inputName2();
        viaBuilderPage.inputWebName2();
        viaBuilderPage.inputWebHead2();
        viaBuilderPage.inputWebTxt2();
        viaBuilderPage.createClick2();
        viaBuilderPage.saveClose();
        String botConfirmation2 = viaBuilderPage.createConfirm2();
        Assert.assertEquals("Схема чат-бота сохранена", botConfirmation2);
        viaBuilderPage.delete2();
        profilePage.deleteConf();

    }
    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }
}
