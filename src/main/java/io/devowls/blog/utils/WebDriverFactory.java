package io.devowls.blog.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
  private static final Logger LOG = LoggerFactory.getLogger(WebDriverFactory.class);

  private static WebDriver driver = null;

  public static WebDriver chrome() {
    if (driver == null) {
      LOG.info("Creating new ChromeDriver");
      driver = new ChromeDriver();
    }
    return driver;
  }
}
