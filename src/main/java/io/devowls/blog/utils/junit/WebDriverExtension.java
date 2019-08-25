package io.devowls.blog.utils.junit;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

@ExtendWith(Screenshots.class)
@ExtendWith(WebDriverManager.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
public @interface WebDriverExtension {
}
