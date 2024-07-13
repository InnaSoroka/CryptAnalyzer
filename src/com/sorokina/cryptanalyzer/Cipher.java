package com.sorokina.cryptanalyzer;

public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
            'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', '.', ',', '«', '»', '"', '/', ':', ';', '!', '?', '-', '_', ' ',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private Cipher() {
        throw new IllegalStateException("Utility class");
    }

    public static void encrypt(String inputFilePath, String outputFilePath, int key) {
        String text = FileManager.readFile(inputFilePath);
        if (text != null) {
            String encodedText = encodeText(text, key);
            FileManager.writeFile(outputFilePath, encodedText);
        }
    }

    public static void decrypt(String inputFilePath, String outputFilePath, int key) {
        String text = FileManager.readFile(inputFilePath);
        if (text != null) {
            String decodedText = encodeText(text, -key);
            FileManager.writeFile(outputFilePath, decodedText);
        }
    }

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

    public static char[] getAlphabet() {
        return ALPHABET;
    }
}