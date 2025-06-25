package com.jisj.fb2.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for attribute of DOM Node
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Attribute {
    /**
     * Attribute name
     */
    String name();

    /**
     * Attribute value
     */
    String value() default "";
}
