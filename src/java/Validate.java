/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@MultipartConfig
public class Validate extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the original content from the hidden form field
//        String originalContent = request.getParameter("originalContent");
        String keys = request.getParameter("keys");
        HttpSession session=request.getSession(false);
        String encodingType =(String)session.getAttribute("encodingType"); 
        String originalContent =(String)session.getAttribute("originalcontent"); 
        
        int Score = 0;

        // Get the uploaded decoded file part
        Part decodedFilePart = request.getPart("decodedFile");

        // Read the decoded file content as a string directly from the uploaded file
        String decodedContent = readFileContent(decodedFilePart.getInputStream());
        

        if(keys.equals("4") || keys.equals("hack")) {
        // Compare the original content with the decoded content
        if (originalContent.equals(decodedContent)) {
//            response.getWriter().println("Success! The file was correctly decoded.");
            String message = "Success! The file was correctly decoded.";
            Score +=1;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<b class='message' style='color: green;'>Success! The file was correctly decoded.</b>");
//            request.setAttribute("score", Score);
            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.include(request, response);
        } else {
//            response.getWriter().println("Failed! The decoded file does not match the original.");
//            String message = "Faild! The file was Not decoded.";
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<b class='message' style='color: red;'>Faied! The file was Not decoded.</b>");
            RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
            rd.include(request, response);
        }} else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<b class='message' style='color: red;'>Faied! You entered wrong Key.</b>");
            RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
            rd.include(request, response);
        }
    }

    // Utility method to read file content from InputStream and convert it to a String
    private String readFileContent(InputStream inputStream) {
        String content;
        try ( // Use a Scanner to read InputStream as a string
                Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
            content = scanner.useDelimiter("\\A").next(); // Read entire content
        } // Read entire content
        return content;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

