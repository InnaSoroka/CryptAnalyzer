package com.sorokina.cryptanalyzer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class FileManager {

    private FileManager() {
        throw new IllegalStateException("Utility class");
    }

    public static String readFile(String filePath) {
        try {
            return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFile(String filePath, String content) {
        try {
            Files.writeString(Path.of(filePath), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}