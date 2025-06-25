package com.jisj.fb2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for the parent book node in DOM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BookElement {
    String tag();
    Attribute[] attr() default {};
    ChildElement[] children() default {};
}
