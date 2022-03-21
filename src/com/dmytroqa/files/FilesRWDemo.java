package com.dmytroqa.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class FilesRWDemo {

    private static final Path pathToFile = Paths.get("files/readme.txt");

    public static void main(String[] args) {
        try {
            byte[] bytes = Files.readAllBytes(pathToFile);
            String content = new String(bytes, Charset.defaultCharset());
            System.out.println(Arrays.toString(bytes));
            System.out.println(content);

            List<String> lines = Files.readAllLines(pathToFile);
            System.out.println(lines);

            Files.write(pathToFile, List.of(String.valueOf(System.currentTimeMillis())), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
