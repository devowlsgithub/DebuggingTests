package io.devowls.blog.homepage;

import io.devowls.blog.contact.Form;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Homepage {
  private static final Logger LOG = LoggerFactory.getLogger(Homepage.class);
  private static final String URL = "https://automationintesting.online/#/";
  private final WebDriver webDriver;

  public Homepage(WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public Homepage open() {
    webDriver.get(URL);
    handleWelcomePopup();
    return this;
  }

  public Form getContactForm() {
    return new Form(webDriver);
  }

  private void handleWelcomePopup() {
    LOG.info("Hiding welcome popup");
    webDriver.manage().addCookie(new Cookie("welcome", "true"));
    webDriver.navigate().refresh();
  }
}
