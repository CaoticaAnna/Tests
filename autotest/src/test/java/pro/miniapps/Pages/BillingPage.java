package pro.miniapps.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BillingPage {
    public BillingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"balanceSection\"]/div[1]/div/div[2]/div[1]/div/span[3]/a")
    private WebElement topUp;

    @FindBy(xpath = "//*[@id=\"wallet_top_up:money_selector\"]")
    private WebElement sumTopUp;

    @FindBy(xpath = "//*[@id=\"uniform-wallet_top_up:money_selector\"]")
    private WebElement sumChange;

    @FindBy(xpath = "//*[@id=\"wallet_top_up:money_selector\"]/option")
    private List<WebElement> sumItems;

    @FindBy(xpath = "//*[@id=\"wallet_top_up:topUpBtn\"]")
    private WebElement topUpBtn;

    public void topUpBalance(){
        WebElement topUpBalance = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(topUp));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", topUpBalance);
    }

    public void sum(){
        sumTopUp.click();
        WebElement sum = (new WebDriverWait(driver, 500)).until(ExpectedConditions.elementToBeClickable(sumChange));
        Actions action = new Actions(driver);
        action.moveToElement(sum).click().build().perform();
        List<WebElement> sc = sumItems;
        for (WebElement scchild : sc) {
            System.out.println(scchild.getAttribute("value"));
            if (scchild.getAttribute("value").equals("100.00")) {
                scchild.click();
            }
        }
    }
    public void clickTopUpBtn(){
        topUpBtn.click();
    }

}
