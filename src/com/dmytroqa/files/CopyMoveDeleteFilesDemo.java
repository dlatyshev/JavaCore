package com.dmytroqa.files;

import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CopyMoveDeleteFilesDemo {

    private static final Path pathToFile = Paths.get("files/tempFile.txt");
    private static final Path pathToTempFile = Paths.get("files/copy-tempFile.txt");

    public static void main(String[] args) throws IOException {
        Files.deleteIfExists(pathToFile);
        Files.deleteIfExists(pathToTempFile);
        Files.deleteIfExists(Paths.get("files/moved/moved-file.txt"));

        Files.createFile(pathToFile);
        Files.writeString(pathToFile, "Hello My Beautiful World! Opa Opa Opapa.", StandardOpenOption.WRITE);
        Files.copy(pathToFile, pathToTempFile);
        Assert.assertTrue(Files.exists(pathToTempFile));

        List<String> lines = Files.readAllLines(pathToTempFile);
        Assert.assertTrue(lines.stream().anyMatch(line -> line.contains("My Beautiful World!")));


        Files.move(pathToTempFile, Paths.get("files/moved/moved-file.txt"));
        Assert.assertFalse(Files.exists(pathToTempFile));
        Assert.assertTrue(Files.exists(Paths.get("files/moved/moved-file.txt")));
    }
}
