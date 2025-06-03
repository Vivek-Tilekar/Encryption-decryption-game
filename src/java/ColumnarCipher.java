import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;

public class ColumnarCipher {

    // Columnar Transposition Cipher Encryption Method
    public String encrypt(String text, String key) {
        // Remove newlines and spaces from the text (if necessary)
        text = text.replaceAll("\\s+", "");  // Removes all whitespaces and newlines
        key = key.replaceAll("\\s", "");

        int numRows = (int) Math.ceil((double) text.length() / key.length());
        char[][] grid = new char[numRows][key.length()];

        // Fill the grid row by row with the text
        int index = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key.length(); c++) {
                if (index < text.length()) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c] = 'X';  // Padding if necessary
                }
            }
        }

        // Sort columns according to the key
        Integer[] colOrder = getColumnOrder(key);

        // Build the encrypted string column by column
        StringBuilder encryptedText = new StringBuilder();
        for (int col : colOrder) {
            for (int row = 0; row < numRows; row++) {
                encryptedText.append(grid[row][col]);
            }
        }

        return encryptedText.toString();
    }

    // Columnar Transposition Cipher Decryption Method
    public String decrypt(String text, String key) {
        key = key.replaceAll("\\s", "");
        int numRows = (int) Math.ceil((double) text.length() / key.length());
        char[][] grid = new char[numRows][key.length()];

        // Get column order for decryption
        Integer[] colOrder = getColumnOrder(key);

        // Fill the grid column by column with the cipher text
        int index = 0;
        for (int col : colOrder) {
            for (int row = 0; row < numRows; row++) {
                if (index < text.length()) {
                    grid[row][col] = text.charAt(index++);
                }
            }
        }

        // Build the decrypted string row by row
        StringBuilder decryptedText = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key.length(); c++) {
                decryptedText.append(grid[r][c]);
            }
        }

        return decryptedText.toString().replace("X", ""); // Remove padding
    }

    // Function to encrypt the content of a File object and overwrite the same file
    public void encryptFile(File file, String key) throws IOException {
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
    public void decryptFile(File file, String key) throws IOException {
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

    // Helper function to determine the column order based on the key
    private Integer[] getColumnOrder(String key) {
        Integer[] order = new Integer[key.length()];
        for (int i = 0; i < key.length(); i++) {
            order[i] = i;
        }

        Arrays.sort(order, Comparator.comparingInt(i -> key.charAt(i)));
        return order;
    }

    
}
