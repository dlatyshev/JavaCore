package com.dmytroqa.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesInformationDemo {
    private static final String pathToFile = "files/testFile.txt";

    public static void main(String[] args) {
        // Getting file information
        Path pathToTestFile = Paths.get(pathToFile);

        // Does File exist?
        boolean isFileExist = Files.exists(pathToTestFile);
        System.out.println("File 'testFile.txt' exists: " + isFileExist);

        // Is File hidden?
        try {
            boolean isFileHidden = Files.isHidden(pathToTestFile);
            System.out.println("Is File 'testFile.txt' hidden: " + isFileHidden);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Is File readable?
        boolean isFileReadable = Files.isReadable(pathToTestFile);
        System.out.println("Is File 'testFile.txt' readable: " + isFileReadable);

        // Is File writeable?
        boolean isFileWritable = Files.isWritable(pathToTestFile);
        System.out.println("Is File 'testFile.txt' writeable: " + isFileWritable);
        boolean isReadOnlyFileWriteable = Files.isWritable(Paths.get("files/readOnlyFile.txt"));
        System.out.println("Is File 'readOnlyFile.txt' writeable: " + isReadOnlyFileWriteable);

        // Is File executable?
        boolean isFileExecutable = Files.isExecutable(pathToTestFile);
        System.out.println("Is File 'readOnlyFile.txt' executable: " + isFileExecutable);
        boolean isExecutableFileIndeedExecutable = Files.isExecutable(Paths.get("files/script.py"));
        System.out.println("Is File 'script.py' executable: " + isExecutableFileIndeedExecutable);

        // Is Directory?
        boolean isPathDirectory = Files.isDirectory(Paths.get("files"));
        System.out.println("Is path a directory: " + isPathDirectory);

        // Get File Size
        try {
            long fileSize = Files.size(pathToTestFile);
            System.out.println("File's 'testFile.txt' size is " + fileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
