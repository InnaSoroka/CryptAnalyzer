package com.sorokina.cryptanalyzer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private Validator() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean validateFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }

    public static boolean validateKey(int key) {
        return key >= 0 && key < Cipher.getAlphabet().length;
    }
}