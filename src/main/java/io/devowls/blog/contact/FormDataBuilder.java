package io.devowls.blog.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormDataBuilder {
  private static final Logger LOG = LoggerFactory.getLogger(FormDataBuilder.class);
  private String name;
  private String email;
  private String phone;
  private String subject;
  private String message;

  public FormDataBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public FormDataBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public FormDataBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public FormDataBuilder setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public FormDataBuilder setMessage(String message) {
    this.message = message;
    return this;
  }

  public FormData build() {
    LOG.info("Building new FormData: {}", this);
    return new FormData(name, email, phone, subject, message);
  }

  @Override
  public String toString() {
    return "{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", subject='" + subject + '\'' +
        ", message='" + message + '\'' +
        '}';
  }
}