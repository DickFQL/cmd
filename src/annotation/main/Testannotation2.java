package annotation.main;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Testannotation2 {
    String name() default "";

    int age() default 0;

    String[] string() default "";
//
//    Math math();
//    Math[] math2();
}
