package com.sorokina.cryptanalyzer;

public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '.', ',', '«', '»', '"', '/', ':', ';', '!', '?', '-', '_', ' ',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Cipher() { //конструктор, чтобы нельзя было создать экземпляр класса
        throw new IllegalStateException("Utility class");//при попытке создания выбрасывается исключение
    }

// метод encrypt принимает путь к входному файлу, путь к выходному файлу, ключ для шифрования
// читает текст из входного файла, шифрует его с использованием метода encodeText,записывает зашифрованный текст в выходной файл

    public static void encrypt(String inputFilePath, String outputFilePath, int key) {
        String text = FileManager.readFile(inputFilePath);
        if (text != null) {
            String encodedText = encodeText(text, key);
            FileManager.writeFile(outputFilePath, encodedText);
        }
    }
// у метода decrypt аналогичная работа как у метода encrypt
// в качестве дешифровки используется отрицатьльное значение
    public static void decrypt(String inputFilePath, String outputFilePath, int key) {
        String text = FileManager.readFile(inputFilePath);
        if (text != null) {
            String decodedText = encodeText(text, -key);
            FileManager.writeFile(outputFilePath, decodedText);
        }
    }

// метод для принятия текста, ключа, трансформирует текст в массив символов шифрует его
// сдвигая каждый символ на значение ключа в пределах алфавита
// если ключ отрицательный, выполняется дешифрование
    private static String encodeText(String text, int key) {
        char[] charText = text.toCharArray();
        for (int i = 0; i < charText.length; i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (charText[i] == ALPHABET[j]) {
                    charText[i] = ALPHABET[(j + key + ALPHABET.length) % ALPHABET.length];
                    break;
                }
            }
        }
        return new String(charText);
    }

// метод для возврата массива символов
    public static char[] getAlphabet() {
        return ALPHABET;
    }
}