package com.dmytroqa.paths;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class PathDemo {

    public static void main(String[] args) {
        Path absolute = Path.of("/home", "Downloads");
        Path related = Path.of("myprog", "conf", "user.properties");
        Path newFile = Path.of("myprog", "conf", "myFile.txt");
        System.out.println(absolute);
        System.out.println(related);
        System.out.println(related.getParent());

        try (var in = new Scanner(related);
             var out = new PrintWriter(newFile.toFile())) {
            while (in.hasNextLine()) {
                out.println(in.nextLine());
            }

        } catch (IOException ex) {

        }
    }
}
