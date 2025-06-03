# **EncryptionGame**

**EncryptionGame** is an interactive encryption and decryption game built using Java (JSP & Servlets) to help cybersecurity students practice cryptography techniques. The app allows users to encrypt text files with various algorithms and provides hints for decrypting them. Users can also manually or automatically decrypt the files based on the clues provided.

## Features
- **Multiple Encryption Techniques**: Users can encrypt files using different algorithms like Caesar Cipher, Polyalphabetic, Playfair, and others.
- **Hints for Decryption**: After encryption, the app provides clues to help users decrypt the file.
- **Manual & Auto Decryption**: If a user can't manually decrypt the file, they can choose to auto-decrypt it using the app.
- **Core Java**: Built entirely using Java web technologies (JSP, Servlets, Tomcat Server) without any external databases.

## Tech Stack
- **Backend**: Java (JSP, Servlets)
- **Server**: Apache Tomcat
- **Frontend**: JSP for rendering the views
- **Encryption Algorithms**: Caesar Cipher, Polyalphabetic, Playfair and Columnar

## Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Vivek-Tilekar/Encryption-decryption-game.git
    cd Encryption-decryption-game
    ```

2. **Set Up Apache Tomcat**: 
    - Download and install [Apache Tomcat](https://tomcat.apache.org/).
    - configure your local Tomcat server to run the project.

3. **Run the Application**:
    - Start Tomcat and navigate to `http://localhost:8089/RansomwareGame/` in your web browser to access the app.

## Usage

- **Encrypting a File**: Choose an encryption method and upload your text file to encrypt. 
  - Once encrypted, the file is stored in the `D:\EncryptionGame` directory on your local machine. 
  - If the `EncryptionGame` folder does not exist, the app will automatically create the folder before saving the encrypted file.

- **Decrypting a File**: After receiving your encrypted file, try to decrypt it using the provided hints. If you can't figure it out, use the automatic decryption option.

## Images

![image](https://github.com/user-attachments/assets/6da00c5a-d010-4677-9c8d-8772ea3c21fd)

![image](https://github.com/user-attachments/assets/9bb42076-e7a3-4238-971e-4f222b4c62d2)

![image](https://github.com/user-attachments/assets/7e793757-ddb5-4a3d-8eb7-3a021bd8b0b1)




