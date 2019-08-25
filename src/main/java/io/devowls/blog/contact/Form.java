package io.devowls.blog.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Form {

  private static final String SUBMIT_CONTACT_CSS = "#submitContact";
  private final WebDriver webDriver;

  @FindBy(css = "#name")
  private WebElement name;

  @FindBy(css = "#email")
  private WebElement email;

  @FindBy(css = "#phone")
  private WebElement phone;

  @FindBy(css = "#subject")
  private WebElement subject;

  @FindBy(css = "#description")
  private WebElement message;

  @FindBy(css = SUBMIT_CONTACT_CSS)
  private WebElement submit;

  @FindBy(css = "div.col-sm-5 div")
  private WebElement confirmationMessage;

  public Form(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  public Form fillIn(FormData data) {
    new WebDriverWait(webDriver, 3).until(visibilityOf(name));
    name.sendKeys(data.getName());
    email.sendKeys(data.getEmail());
    phone.sendKeys(data.getPhone());
    subject.sendKeys(data.getSubject());
    message.sendKeys(data.getMessage());
    submit.click();
    return this;
  }

  public String getConfirmationMessage() {
    new WebDriverWait(webDriver, 5).until(invisibilityOfElementLocated(By.cssSelector(SUBMIT_CONTACT_CSS)));
    return confirmationMessage.getText();
  }
}
