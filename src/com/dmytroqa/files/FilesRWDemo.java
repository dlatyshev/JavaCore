package com.dmytroqa.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FilesRWDemo {

    private static final Path pathToFile = Paths.get("files/readme.txt");

    public static void main(String[] args) {
        try {
            byte[] bytes = Files.readAllBytes(pathToFile);
            String content = new String(bytes, Charset.defaultCharset());
            System.out.println(Arrays.toString(bytes));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
