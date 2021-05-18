package com.example33.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Preamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "";
    String lastModifiedBy() default "";
    // note user of array
    String[] reviewers();
}
