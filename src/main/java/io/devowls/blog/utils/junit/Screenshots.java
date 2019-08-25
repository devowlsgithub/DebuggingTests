package io.devowls.blog.utils.junit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static io.devowls.blog.utils.junit.WebDriverManager.WEBDRIVER_KEY;
import static io.devowls.blog.utils.junit.WebDriverManager.WEBDRIVER_NAMESPACE;

public class Screenshots implements TestExecutionExceptionHandler {
  private static final Logger LOG = LoggerFactory.getLogger(Screenshots.class);

  @Override
  public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
    WebDriver driver = context.getStore(WEBDRIVER_NAMESPACE).get(WEBDRIVER_KEY, WebDriver.class);
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String path = "build/screenshots/" + screenshot.getName();
    LOG.debug("Capturing screenshot {}", path);
    FileUtils.copyFile(screenshot, new File(path));
    throw throwable;
  }
}
