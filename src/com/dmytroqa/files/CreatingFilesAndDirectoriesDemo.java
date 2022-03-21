package com.dmytroqa.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CreatingFilesAndDirectoriesDemo {

    public static void main(String[] args) {
        try {
            Files.deleteIfExists(Paths.get("files/empty"));
            Files.createDirectory(Paths.get("files/empty"));
            Files.createFile(Paths.get("files/empty/" + System.currentTimeMillis() + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
