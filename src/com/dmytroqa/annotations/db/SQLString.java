package com.dmytroqa.annotations.db;

public @interface SQLString {
    int value() default 0;
    String name() default "";
    Constrains constrains() default @Constrains;
}
