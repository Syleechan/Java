package Enum;


import java.lang.annotation.Inherited;

@SuppressWarnings("")
@Inherited
public @interface MyAnnotation {

    String value() default "hello";

}
