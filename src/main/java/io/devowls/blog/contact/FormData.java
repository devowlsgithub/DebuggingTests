package io.devowls.blog.contact;

public class FormData {
  private String name;
  private String email;
  private String phone;
  private String subject;
  private String message;

  public FormData(String name, String email, String phone, String subject, String message) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.subject = subject;
    this.message = message;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getSubject() {
    return subject;
  }

  public String getMessage() {
    return message;
  }
}
