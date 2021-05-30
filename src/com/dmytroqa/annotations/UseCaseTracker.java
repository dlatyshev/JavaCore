package com.dmytroqa.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCasesIds, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found use case " + uc.id() + "\n " + uc.description());
                useCasesIds.remove(Integer.valueOf(uc.id()));
            }
        }
        useCasesIds.forEach(id -> System.out.println("Missing use case " + id));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(1, 4).boxed().collect(Collectors.toList());
        trackUseCases(useCases, PasswordUtils.class);
    }
}

