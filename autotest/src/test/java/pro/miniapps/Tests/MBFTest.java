package pro.miniapps.Tests;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pro.miniapps.Pages.*;

import java.util.concurrent.TimeUnit;

public class MBFTest {
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
    public void MBFTest() {
        loginPage.inputEmail("eyeline.api.ai@gmail.com");
        loginPage.inputPassword("hL3-5KY-ckC-b5E");
        loginPage.clickLoginBtn();
        botPage.clickActBot();
        botPage.clickMBF();
        botPage.inputMBF_ID();
        botPage.inputMBF_Secret();
        botPage.clickConfBtn2();
        botPage.switchToW();
        String confTxt2 = botPage.getConfTxt2();
        System.out.println(confTxt2);
        Assert.assertEquals("Microsoft Bot Framework успешно подключен", confTxt2);
        botPage.clickDel2();
        botPage.clickDelBtn2();

    }
    @AfterClass
    public static void tearDown() {
        profilePage.entryMenu();
        profilePage.userlogout();
        driver.quit();
    }

}
