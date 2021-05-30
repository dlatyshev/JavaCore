package com.dmytroqa.annotations.db;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length < 1) {
            System.out.println("There are no annotated classes");;
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }

            String tableName = dbTable.name();
            // If the name is empty, use the Class name:
            if (tableName.isEmpty()) {
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnNames = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length > 1) {
                    continue;
                }
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                }
            }
        }
    }
}
