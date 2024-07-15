package com.sorokina.cryptanalyzer;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    private Validator() { //конструктор, чтобы нельзя было создать экземпляр класса
        throw new IllegalStateException("Utility class");//при попытке создания выбрасывается исключение
    }
//проверка существования файла по указанному пути filePath
//метод возвращает true, если файл существует, если нет - false
    public static boolean validateFileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
//Проверка ключа
//если ключ находится в пределах диапазона от 0 до длины алфавита шифра - true, если нет - false
    public static boolean validateKey(int key) {
        return key >= 0 && key < Cipher.getAlphabet().length;
    }
}