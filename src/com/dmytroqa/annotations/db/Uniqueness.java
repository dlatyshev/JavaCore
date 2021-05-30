package com.dmytroqa.annotations.db;

public @interface Uniqueness {
    Constrains constrains() default @Constrains(unique = true);
}
