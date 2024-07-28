package com.best.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author cctv14
 * @data 2023/10/6 10:54
 * @description
 */
@MyAnnotation(value = "com.best.annotation.User com.best.annotation.MyAnnotation", university = "家里蹲大学", age = 666)
public class User {
    @MyAnnotation(name = "main Method", age = 18, id = 1, university = "复旦大学", value = "main com.best.annotation.MyAnnotation")
    public static void main(String[] args) throws NoSuchMethodException {
        Class<User> userClass = User.class;
        System.out.println("==============method===============");
        Method main = userClass.getMethod("main", String[].class);
        if (main.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = main.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.age());
            System.out.println(annotation.id());
            System.out.println(Arrays.toString(annotation.university()));
            System.out.println(annotation.name());
            System.out.println(annotation.value());
        }
        System.out.println("==============class===============");
        if (userClass.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = userClass.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.age());
            System.out.println(annotation.id());
            System.out.println(Arrays.toString(annotation.university()));
            System.out.println(annotation.name());
            System.out.println(annotation.value());
        }
    }
}

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation {
    String name() default "name";

    int age() default 0;

    // -1 代表不存在
    int id() default -1;

    String[] university() default {"清华大学", "北京大学"};

    String value();
}
