package com.sorokina.cryptanalyzer;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // объект Scanner для считывания ввода
        //выбор опции шифрование/дешифрование
        System.out.println("Select the operating mode:");
        System.out.println("1. Text encryption");
        System.out.println("2. Decryption of text");
        int choice = scanner.nextInt(); // считывание выбора ввода
        scanner.nextLine();

// оператор свитч для выбора действия
        switch (choice) {
            case 1: // если выбрано 1
                encryptText(scanner); // вызвать метод для шифрования
                break; // завершение
            case 2://если выбрано 2
                decryptText(scanner); // вызвать метод для дешифрования
                break; // завершение
            default: // если введено некорректное значение
                System.out.println("The wrong choice!"); // вывести сбщ об ошибке
                break; // завершение
        }
    }

    private static void encryptText(Scanner sc) { // метод для шифрования текста
        System.out.println("Введите путь к файлу (resources/text.txt):"); // запрос пути к файлу для шифрования
        String inputFilePath = sc.nextLine(); // считать путь к файлу
        System.out.println("Введите путь для сохранения зашифрованного текста (resources/encrypt.txt):"); // запрос пути для сохранения зашифрованного текста
        String outputFilePath = sc.nextLine(); // считать путь для сохранения зашифрованного текста
        System.out.println("Введите ключ сдвига:"); // запросить ключ сдвига для шифрования
        int key = sc.nextInt(); // считывание ключа сдвига
        if (Validator.validateFileExists(inputFilePath) && Validator.validateKey(key)) { // проверка существования файла и корректности ключа
            Cipher.encrypt(inputFilePath, outputFilePath, key); // если проверки пройдены, выполнить шифрование
        } else { // если проверки не пройдены
            System.out.println("Неверный путь к файлу или ключ!"); // вывести сбщ об ошибке
        }
    }

    private static void decryptText(Scanner sc) { // метод для дешифрования текста
        System.out.println("Введите путь к зашифрованному файлу (resources/text.txt):"); // запрос пути к зашифрованному файлу
        String inputFilePath = sc.nextLine(); // считать путь к зашифрованному файлу
        System.out.println("Введите путь для сохранения расшифрованного текста (resources/decrypt.txt):"); // запрос пути для сохранения расшифрованного текста
        String outputFilePath = sc.nextLine(); // считать путь для сохранения расшифрованного текста
        System.out.println("Введите ключ сдвига:"); // запрос ключа сдвига для дешифрования
        int key = sc.nextInt(); // считывание ключ сдвига
        if (Validator.validateFileExists(inputFilePath) && Validator.validateKey(key)) { // проверка существования файла и корректности ключа
            Cipher.decrypt(inputFilePath, outputFilePath, key); // если проверки пройдены, выполнить дешифрование
        } else { // если проверки не пройдены
            System.out.println("Неверный путь к файлу или ключ!"); // вывести сбщ об ошибке
        }
    }
}