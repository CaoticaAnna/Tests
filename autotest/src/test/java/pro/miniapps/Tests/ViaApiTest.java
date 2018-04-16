package pro.miniapps.Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.LoginPage;
import pro.miniapps.Pages.ProfilePage;
import pro.miniapps.Pages.ViaApiPage;

import java.util.concurrent.TimeUnit;

public class ViaApiTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static ViaApiPage viaApiPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/aguseva/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        viaApiPage = new ViaApiPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://gussd-lk-test.eyeline.mobi/");
    }

    @Test
    public void ViaApiTest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        profilePage.toCreate();
        profilePage.botViaApi();
        viaApiPage.inputName();
        viaApiPage.inputUrl();
        viaApiPage.inputWebName();
        viaApiPage.inputWebHead();
        viaApiPage.inputWebTxt();
        viaApiPage.createClick();
        String botConfirmation = viaApiPage.createConfirm();
        Assert.assertEquals("Редактировать", botConfirmation);
        viaApiPage.delete();
        profilePage.deleteConf();
    }

    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }
}
