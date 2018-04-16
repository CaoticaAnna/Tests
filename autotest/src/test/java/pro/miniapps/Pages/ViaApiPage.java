package pro.miniapps.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViaApiPage {

    public ViaApiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"service_ext_new:form:name\"]")
    private WebElement botName;

    @FindBy(xpath = "//*[@id=\"service_ext_new:form:url\"]")
    private WebElement botUrl;

    @FindBy(xpath = "//*[@id=\"service_ext_new:service_ext_new_landing_page_new:form:pageId\"]")
    private WebElement botWebName;

    @FindBy(xpath = "//*[@id=\"service_ext_new:service_ext_new_landing_page_new:form:title\"]")
    private WebElement botWebHead;

    @FindBy(xpath = "//*[@id=\"service_ext_new:service_ext_new_landing_page_new:form:defaultDescription\"]")
    private WebElement botWebTxt;

    @FindBy(xpath = "//*[@id=\"service_ext_new:saveBtn\"]")
    private WebElement createBtn;

    @FindBy(xpath = "//*[@id=\"service_ext_edit:ext_name:form:label_edit_btn\"]")
    private WebElement botNameEdit;

    @FindBy(xpath = "//*[@id=\"service_ext_settings_actions:action_delete\"]/span[2]")
    private WebElement delBtn;

    public void inputName() {
        botName.sendKeys("bgtvfr");
    }

    public void inputUrl() {
        botUrl.sendKeys("https://ghjgjhjh.ghg");
    }

    public void inputWebName() {
        botWebName.sendKeys("nvvhv");
    }

    public void inputWebHead() {
        botWebHead.sendKeys("bgtvfr");
    }

    public void inputWebTxt() {
        botWebTxt.sendKeys("zaqxswcdevfrbgt1234567890");
    }

    public void createClick() {
        createBtn.click();
    }

    public String createConfirm() {
        String createConfirm = botNameEdit.getAttribute("oldtitle");
        System.out.println(createConfirm);
        return createConfirm;
    }

    public void delete() {
        WebElement delBot = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(delBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", delBot);
     }

}



