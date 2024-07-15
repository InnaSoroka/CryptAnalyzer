package com.sorokina.cryptanalyzer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class FileManager {

    private FileManager() { //конструктор, чтобы нельзя было создать экземпляр класса
        throw new IllegalStateException("Utility class"); //при попытке создания выбрасывается исключение
    }

    public static String readFile(String filePath) { //стат.метод, принимает параметр filePath, возвращает строку
        try { //чтение файла пути filePath, кодировкой UTF_8
            return Files.readString(Path.of(filePath), StandardCharsets.UTF_8);//возврат содержимого файла, в случае успеха
        } catch (IOException e) {//если будет исключение, напечатается в консоль, метод вернет null.
            e.printStackTrace();
            return null;
        }
    }

    public static void writeFile(String filePath, String content) { //стат.метод, принимает строковые параметры filePath/content,не возвращает значения
        try {//запись строки content в файл пути filePath, с кодировкой UTF-8
            Files.writeString(Path.of(filePath), content, StandardCharsets.UTF_8);
        } catch (IOException e) {//если будет исключение, напечатается в консоль
            e.printStackTrace();
        }
    }
}