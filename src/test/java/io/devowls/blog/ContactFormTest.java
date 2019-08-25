package io.devowls.blog;

import io.devowls.blog.contact.FormData;
import io.devowls.blog.contact.FormDataBuilder;
import io.devowls.blog.homepage.Homepage;
import io.devowls.blog.utils.junit.WebDriverExtension;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@WebDriverExtension
class ContactFormTest {

  @Test
  void example1(WebDriver webDriver) {
    FormData expectedData = new FormDataBuilder()
        .setName("Tester")
        .setPhone("123456789")
        .setEmail("test@example.com")
        .setSubject("Testing the form")
        .setMessage("...hoping it will work")
        .build();

    String confirmationMessage = new Homepage(webDriver)
        .open()
        .getContactForm()
        .fillIn(expectedData)
        .getConfirmationMessage();

    assertThat(confirmationMessage).contains("We'll get back to you about");
  }

  @Test
  void example1Fixed(WebDriver webDriver) {
    FormData expectedData = new FormDataBuilder()
        .setName("Tester")
        .setPhone("+01234567890")
        .setEmail("test@example.com")
        .setSubject("Testing the form")
        .setMessage("...hoping it will work")
        .build();

    String confirmationMessage = new Homepage(webDriver)
        .open()
        .getContactForm()
        .fillIn(expectedData)
        .getConfirmationMessage();

    assertThat(confirmationMessage).contains("We'll get back to you about");
  }
}
