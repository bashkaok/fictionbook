package com.jisj.fb2.annotation;

import com.jisj.fb2.elements.BaseElement;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ChildElement {
    String tag();
    boolean optional() default false;
    int order();

    /**
     * Occurrence in book: <ul>
     *     <li>1 - required once,</li>
     *     <li>0..1 - optional once,</li>
     *     <li>1..2 - required once or twice,</li>
     *     <li>* - many optional (default),</li>
     *     <li>1..* - required 1 or many</li>
     * </ul>
     */
    String occurrence() default "*";
    Class<? extends BaseElement> wrapperClass() default BaseElement.class;
}
