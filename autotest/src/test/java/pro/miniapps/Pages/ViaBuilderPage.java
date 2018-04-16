package pro.miniapps.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class ViaBuilderPage {

    public ViaBuilderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"service_int_new:form:name\"]")
    private WebElement botName2;

    @FindBy(xpath = "//*[@id=\"service_int_new:service_int_new_landing_page_new:form:pageId\"]")
    private WebElement botWebName2;

    @FindBy(xpath = "//*[@id=\"service_int_new:service_int_new_landing_page_new:form:title\"]")
    private WebElement botWebHead2;

    @FindBy(xpath = "//*[@id=\"service_int_new:service_int_new_landing_page_new:form:defaultDescription\"]")
    private WebElement botWebTxt2;

    @FindBy(xpath = "//*[@id=\"service_int_new:saveBtn\"]")
    private WebElement createBtn2;

    @FindBy(xpath = "//*[@id=\"service_int_edit:service_constructor:close_editor_btn\"]")
    private WebElement saveCloseBtn;

    @FindBy(css = "body > div.ui-pnotify.ui-pnotify-top > div > h4")
    private WebElement confTxt;

    @FindBy(xpath = "//*[@id=\"service_int_settings_actions:action_delete\"]/span[2]")
    private WebElement delBtn2;

    public void inputName2() {
        botName2.sendKeys("bgtvfr");
    }

    public void inputWebName2() {
        botWebName2.sendKeys("nvvhv");
    }

    public void inputWebHead2() {
        botWebHead2.sendKeys("bgtvfr");
    }

    public void inputWebTxt2() {
        botWebTxt2.sendKeys("zaqxswcdevfrbgt1234567890");
    }

    public void createClick2() {
        createBtn2.click();
    }

    public void saveClose() {
        WebElement saveBtn = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(saveCloseBtn));
        Actions actions = new Actions(driver);
        actions.moveToElement(saveBtn).build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", saveBtn);

    }

    public String createConfirm2() {
        String subWindowHandler = null;
                Set<String> handles = driver.getWindowHandles();
                Iterator<String> iterator = handles.iterator();
                while (iterator.hasNext()) {
                    subWindowHandler = iterator.next();
                }
                driver.switchTo().window(subWindowHandler);
                String createConfirm2 = confTxt.getText();
                System.out.println(createConfirm2);
                return createConfirm2;

    }


    public void delete2() {
        WebElement delBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(delBtn2));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", delBot);
    }

   }