package pro.miniapps.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[1]/li[2]/a/span[2]")
    private WebElement create;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[1]/li[2]/ul/li/ul/li[1]/a")
    private WebElement viaApi;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[1]/li[2]/ul/li/ul/li[2]/a")
    private WebElement viaBuilder;

    @FindBy(xpath = "//*[@id=\"account_btn\"]/span[2]")
    private WebElement Profile;

    @FindBy(id = "account_btn")
    private WebElement userMenu;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[2]/li/ul/li/ul/li[5]/a")
    private WebElement billing;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[2]/li/ul/li/ul/li[6]/a")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"delete_confirm_dialog:delete_confirm_dialog:okBtn\"]")
    private WebElement delConfirm;

    @FindBy(xpath = "//*[@id=\"header\"]/nav/div/div[2]/ul[1]/li[1]/a")
    private WebElement bots;

    public String getUserProfile() {
        String userProfile = Profile.getText();
        System.out.println(userProfile);
        return userProfile;
        }

    public void toCreate(){
        WebElement createBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(create));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", createBot);
    }

    public void botViaApi() {
        WebElement apiBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(viaApi));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", apiBot);

    }

    public void botViaBuilder(){
        WebElement builderBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(viaBuilder));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", builderBot);
    }

        public void entryMenu () {
            WebElement accountMenu = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(userMenu));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", accountMenu);

        }

        public void userlogout(){
            WebElement accountLogout = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(logoutBtn));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", accountLogout);
        }

    public void deleteConf() {
        WebElement delConf = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(delConfirm));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", delConf);
    }

    public void toBilling(){
        WebElement tarif = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(billing));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tarif);
    }

    public void toBots(){
        WebElement toBots = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(bots));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", toBots);
    }
    }
