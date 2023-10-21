package annotation.main;


public @interface Testannotation {
    String name() default "";

    int age() default 0;

    String[] string() default "";
//
//    Math math();
//    Math[] math2();
}
