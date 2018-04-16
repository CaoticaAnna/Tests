package pro.miniapps.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class BotPage {
    public BotPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"services_table\"]/tbody/tr/td[1]/a")
    private WebElement actBot;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_telegram:open_connection_dialog_btn\"]")
    private WebElement TG;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_telegram:int_service_connections_connection_telegram_dialog_telegram_connect:telegram_token\"]")
    private WebElement tgToken;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_telegram:int_service_connections_connection_telegram_dialog_telegram_connect:assign_telegram_token_btn\"]")
    private WebElement tgConfBtn;

    @FindBy(css = "body > div.ui-pnotify.ui-pnotify-top > div > div.ui-pnotify-text")
    private WebElement tgConfirm;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_telegram:open_connection_dialog_btn\"]")
    private WebElement tgDel;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_telegram:int_service_connections_connection_telegram_dialog_telegram_disconnect:unassign_telegram_token_btn\"]")
    private WebElement tgDelBtn;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:open_connection_dialog_btn\"]")
    private WebElement MBF;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:int_service_connections_connection_ms_bot_framework_dialog_ms_bot_framework_connect:mbf_bot_app_id\"]")
    private WebElement MBF_ID;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:int_service_connections_connection_ms_bot_framework_dialog_ms_bot_framework_connect:mbf_bot_app_secret\"]")
    private WebElement MBF_Secret;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:int_service_connections_connection_ms_bot_framework_dialog_ms_bot_framework_connect:assign_ms_bot_framework_token_btn\"]")
    private WebElement MBF_ConfBtn;

    @FindBy (css = "body > div.ui-pnotify.ui-pnotify-top > div > div.ui-pnotify-text")
    private WebElement MBF_Confirm;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:open_connection_dialog_btn\"]")
    private WebElement MBF_Del;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ms_bot_framework:int_service_connections_connection_ms_bot_framework_dialog_ms_bot_framework_disconnect:unassign_ms_bot_framework_token_btn\"]")
    private WebElement MBF_DelBtn;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ussd:open_connection_dialog_btn\"]")
    private WebElement C2S;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ussd_free_rented_c2s_numbers_table\"]/tbody/tr/td[2]/button")
    private WebElement C2S_actBtn;

    @FindBy(css = "body > div.ui-pnotify.ui-pnotify-top > div > div.ui-pnotify-text")
    private WebElement C2S_Confirm;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ussd:open_connection_dialog_btn\"]")
    private WebElement C2S_Del;

    @FindBy(xpath = "//*[@id=\"int_service_connections_connection_ussd:int_service_connections_connection_ussd_dialog_ussd_disconnect:unassign_c2s_number_btn\"]")
    private WebElement C2S_DelBtn;


    public void switchToW(){
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

    public void clickActBot(){
        WebElement tgActBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(actBot));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tgActBot);
    }

    public void clickTG(){
        WebElement tgAct = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(TG));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tgAct);
    }


    public void inputToken(){
        WebElement tgWindow = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(tgToken));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tgWindow);
        tgWindow.sendKeys("529094454:AAHNSE7wJ9_qCZphqIQ1WJyRlXzWgaBSiSs");
    }

    public void clickConfBtn(){
        tgConfBtn.click();

    }

    public String getConfTxt() {
        String getConfTxt = tgConfirm.getText();
        return getConfTxt;
    }

    public void clickDel(){

        WebElement clickDel = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(tgDel));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", clickDel);
    }

    public void clickDelBtn(){
        WebElement tgCancel = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(tgDelBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", tgCancel);
    }

    public void clickMBF(){
        WebElement MBFAct = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(MBF));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", MBFAct);
    }

    public void inputMBF_ID(){
        WebElement MBFWindow_1 = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(MBF_ID));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", MBFWindow_1);
        MBFWindow_1.sendKeys("276f514b-0567-4b52-b393-fdbfed45e0fe");
    }

    public void inputMBF_Secret(){
        WebElement MBFWindow_2 = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(MBF_Secret));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", MBFWindow_2);
        MBFWindow_2.sendKeys("mwzhCCRE7@diqWTI1243$%=");
    }

    public void clickConfBtn2(){
        MBF_ConfBtn.click();

    }

    public String getConfTxt2(){
        String getConfTxt2 = MBF_Confirm.getText();
        return getConfTxt2;
    }

    public void clickDel2(){
        MBF_Del.click();
    }

    public void clickDelBtn2(){
        WebElement MBF_Cancel = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(MBF_DelBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", MBF_Cancel);
    }

    public void clickC2S(){
        WebElement C2S_connect = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(C2S));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", C2S_connect);
    }

    public void clickC2S_actBtn(){
        C2S_actBtn.click();
    }

    public String getConfTxt3(){
        String getConfTxt3 = C2S_Confirm.getText();
        return getConfTxt3;
    }

    public void clickDel3(){
        C2S_Del.click();
    }

    public void clickDelBtn3(){
        WebElement C2S_Cancel = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(C2S_DelBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", C2S_Cancel);
    }

}
