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

public class CaesarCipher {

    // Caesar Cipher Encryption Method
    public String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char charToEncrypt = text.charAt(i);

            if (Character.isLetter(charToEncrypt)) {
                char offset = Character.isUpperCase(charToEncrypt) ? 'A' : 'a';
                char encryptedChar = (char) (((charToEncrypt - offset + key) % 26) + offset);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(charToEncrypt); // Leave non-letters unchanged
            }
        }
        return encryptedText.toString();
    }

    // Caesar Cipher Decryption Method
    public String decrypt(String text, int key) {
        return encrypt(text, 26 - key); // Reverse the encryption process by subtracting the key
    }

    // Function to encrypt the content of a File object and overwrite the same file
    public void encryptFile(File file, int key) throws IOException {
        // Read the content of the file
        String content = new String(Files.readAllBytes(file.toPath()));

        // Encrypt the content
        String encryptedContent = encrypt(content, key);

        // Overwrite the same file with the encrypted content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(encryptedContent);
        }

        System.out.println("File encrypted successfully!");
    }

    // Function to decrypt the content of a File object and overwrite the same file
    public void decryptFile(File file, int key) throws IOException {
        // Read the content of the file
        String content = new String(Files.readAllBytes(file.toPath()));

        // Decrypt the content
        String decryptedContent = decrypt(content, key);

        // Overwrite the same file with the decrypted content
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(decryptedContent);
        }

        System.out.println("File decrypted successfully!");
    }
}
