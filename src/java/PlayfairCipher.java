/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.io.*;
import java.nio.file.Files;

public class PlayfairCipher {

    private char[][] matrix;

    public PlayfairCipher(String key) {
        matrix = generateMatrix(key);
    }

    // Generate a 5x5 Playfair cipher matrix using the provided key
    private char[][] generateMatrix(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        boolean[] used = new boolean[26];  // Track which letters are used
        char[][] matrix = new char[5][5];
        int index = 0;

        // Fill the matrix with the key characters
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[index / 5][index % 5] = c;
                used[c - 'A'] = true;
                index++;
            }
        }

        // Fill remaining letters (excluding J)
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!used[c - 'A'] && c != 'J') {
                matrix[index / 5][index % 5] = c;
                used[c - 'A'] = true;
                index++;
            }
        }

        return matrix;
    }

    // Encrypt the text using Playfair cipher
    public String encrypt(String text) {
        text = prepareText(text.toUpperCase().replaceAll("[^A-Z]", ""));
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) { // Same row
                encryptedText.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                encryptedText.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                encryptedText.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                encryptedText.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else { // Rectangle rule
                encryptedText.append(matrix[posA[0]][posB[1]]);
                encryptedText.append(matrix[posB[0]][posA[1]]);
            }
        }
        return encryptedText.toString();
    }

    // Decrypt the text using Playfair cipher
    public String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);
            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) { // Same row
                decryptedText.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                decryptedText.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                decryptedText.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                decryptedText.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else { // Rectangle rule
                decryptedText.append(matrix[posA[0]][posB[1]]);
                decryptedText.append(matrix[posB[0]][posA[1]]);
            }
        }
        return decryptedText.toString();
    }

    // Prepare text for encryption: pairs letters, adds padding if necessary
    private String prepareText(String text) {
        StringBuilder preparedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (i + 1 < text.length() && current == text.charAt(i + 1)) {
                preparedText.append(current).append('X');
            } else {
                preparedText.append(current);
            }
        }
        if (preparedText.length() % 2 != 0) {
            preparedText.append('X');
        }
        return preparedText.toString();
    }

    // Find the position of the character in the matrix
    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Function to encrypt the content of a File object and overwrite the file
    public void encryptFile(File file) throws IOException {
        String content = new String(Files.readAllBytes(file.toPath())).toUpperCase();
        String preparedContent = prepareText(content);
        String encryptedContent = encrypt(preparedContent);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(encryptedContent);
        }
        System.out.println("File encrypted successfully using Playfair cipher!");
    }

    // Function to decrypt the content of a File object and overwrite the file
    public void decryptFile(File file) throws IOException {
        String content = new String(Files.readAllBytes(file.toPath()));
        String decryptedContent = decrypt(content);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(decryptedContent);
        }
        System.out.println("File decrypted successfully using Playfair cipher!");
    }

}


