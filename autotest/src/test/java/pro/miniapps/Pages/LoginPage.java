package pro.miniapps.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"gotoRegisterBtn\"]")
    private WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"j_username\"]")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"j_password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"login:form:loginBtn\"]")
    private WebElement loginBtn;

    public void clickRegisterBtn() {
        registerBtn.click();
    }

    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }
    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }
}
