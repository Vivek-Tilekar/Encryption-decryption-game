/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 *
 * @author user
 */
@MultipartConfig
public class DecryptHome extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           String encryptionType = request.getParameter("encryption");

        // Get the uploaded file part
        Part filePart = request.getPart("file2");

        // Extract file name from the uploaded part
        String fileName = extractFileName(filePart);

        // Define the directory where the file should be saved
        File directory = new File("D://EncryptionGame/");

        // Check if the directory exists, if not create it
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directory.getAbsolutePath());
            } else {
                System.out.println("Failed to create directory!");
            }
        }

        // Create a File object for the uploaded file in the specified directory
        File file = new File(directory, fileName);

        // Write the uploaded file to disk
        try (FileOutputStream outputStream = new FileOutputStream(file);
             InputStream inputStream = filePart.getInputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        // Now the file is available in 'file' variable
        // Perform the encryption or decryption on the same file
        if (encryptionType.equals("ceaser")) {
            CaesarCipher cc = new CaesarCipher();
            cc.decryptFile(file, 4);
        } else if (encryptionType.equals("polyalphabetic")) {
            PolyalphabeticCipher ps = new PolyalphabeticCipher();
            ps.decryptFile(file, "hack");
//            encryptPolyalphabetic(file);
        } else if (encryptionType.equals("columnar")) {
            ColumnarCipher cc = new ColumnarCipher();
            cc.decryptFile(file, "hack");
//            encryptPolyalphabetic(file);
        } 
        else {
            PlayfairCipher pf = new PlayfairCipher("hack");
            pf.decryptFile(file);
        }
        
//        try (FileOutputStream outputStream = new FileOutputStream(file);
//             InputStream inputStream = filePart.getInputStream()) {
//
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//        }

        // Send a response to the user
        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
        out.println("<b class='message' style='color: green;'>Success! The file was decrypted.</b>");
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String extractFileName(Part filePart) {
        String contentDisposition = filePart.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
