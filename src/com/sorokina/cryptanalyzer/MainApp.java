package com.sorokina.cryptanalyzer;
import java.util.Scanner;
import java.util.function.Consumer;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select the operating mode:");
        System.out.println("1. Text encryption");
        System.out.println("2. Decryption of text");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Consumer<Scanner> action = switch (choice) {
            case 1 -> sc -> {
                System.out.println("Enter the file's path (resources/text.txt):");
                String inputFilePath = sc.nextLine();
                System.out.println("Input the path to save the encrypted text (resources/encrypt.txt):");
                String outputFilePath = sc.nextLine();
                System.out.println("Press the shift key:");
                int key = sc.nextInt();
                if (Validator.validateFileExists(inputFilePath) && Validator.validateKey(key)) {
                    Cipher.encrypt(inputFilePath, outputFilePath, key);
                } else {
                    System.out.println("The file path or key is incorrect!");
                }
            };
            case 2 -> (sc) -> {
                System.out.println("Enter the path to the encrypted file (resources/encrypt.txt):");
                String inputFilePath = sc.nextLine();
                System.out.println("Enter the file path to decrypt the text (resources/decrypt.txt):");
                String outputFilePath = sc.nextLine();
                System.out.println("Press the shift key:");
                int key = sc.nextInt();
                if (Validator.validateFileExists(inputFilePath) && Validator.validateKey(key)) {
                    Cipher.decrypt(inputFilePath, outputFilePath, key);
                } else {
                    System.out.println("The file path or key is incorrect!");
                }
            };
            default -> (sc) -> System.out.println("The wrong choice!");
        };

        action.accept(scanner);
    }
}