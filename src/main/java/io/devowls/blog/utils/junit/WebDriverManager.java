package io.devowls.blog.utils.junit;

import io.devowls.blog.utils.WebDriverFactory;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverManager implements BeforeEachCallback, AfterEachCallback, ParameterResolver {
  public static final ExtensionContext.Namespace WEBDRIVER_NAMESPACE = ExtensionContext.Namespace.create("webdriver");
  public static final String WEBDRIVER_KEY = "webdriver";
  private static final Logger LOG = LoggerFactory.getLogger(WebDriverManager.class);

  @Override
  public void beforeEach(ExtensionContext context) {
    LOG.debug("Starting new test: {}", context.getDisplayName());
    context.getStore(WEBDRIVER_NAMESPACE).put(WEBDRIVER_KEY, WebDriverFactory.chrome());
  }

  @Override
  public void afterEach(ExtensionContext context) {
    LOG.debug("Teardown for test: {}", context.getDisplayName());
    context.getStore(WEBDRIVER_NAMESPACE).get(WEBDRIVER_KEY, WebDriver.class).quit();
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return WebDriver.class.equals(parameterContext.getParameter().getType());
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
    return extensionContext.getStore(WEBDRIVER_NAMESPACE).get(WEBDRIVER_KEY, WebDriver.class);
  }
}
