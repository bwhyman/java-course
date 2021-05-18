package com.example33.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Authority {
    AuthorityType[] value() default AuthorityType.USER;

    public enum AuthorityType {
        USER, ADMIN, SUPERADMIN,
    }
}
