<%-- 
    Document   : info
    Created on : 26-Sept-2024, 1:58:17 pm
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Information Page</title>
        <link rel="stylesheet" href="info.css">
    </head>
    <body>
        <%
//            HttpSession session=request.getSession(false);
            String encryptionType =(String)session.getAttribute("encodingType");
//            String encryptionType = request.getParameter("encryption");
        %>

        
        
        
        <div class="container">
            <a href="home.jsp" class="button">Back</a>
            <% 
                if(encryptionType.equals("ceaser")) {
            %>
            <h1>Welcome to Crack the <%=encryptionType%></h1>

            <p class="story">
                You have been hired by an elite cyber defense team. A top-secret file containing mission-critical information has been encrypted by a rogue agent. Your task is to decrypt the file and recover the message. The encryption method used is a Caesar cipher.
                <br/> <br/>
                But be careful—time is of the essence! The agent has left you a few hints to decode the file. Can you crack the cipher and reveal the secret before it’s too late?
            </p>

            <h1>Hints to Decrypt the File:</h1>

            <ol>
                <li class="olType">The Number is Key</li>
                <ul>
                    <li>The file is locked using a simple number shift.</li>
                    <li>Every letter in the message has been moved by a fixed number of positions in the alphabet.</li>
                    <li>Challenge: Try common shifts like 3 or 5.</li>
                </ul>
                <li class="olType">Watch for Repeating Letters</li>
                <ul>
                    <li>In English, certain letters appear more often than others. For example, E is the most common letter in English texts.</li>
                    <li>Challenge: If a letter appears frequently in the encrypted message, it might be E or another common letter like T or A.</li>
                </ul>

                <li class="olType"> Non-Letters Remain the Same</li>
                <ul>
                    <li>The spaces, punctuation marks, and numbers in the text are not encrypted. Focus only on the letters.</li>
                    <li>Challenge: Use the spacing between words to help identify common English words like "the", "and", or "is".</li>
                    
                </ul>

                <li class="olType">Shifting Back</li>
                <ul>
                    <li>If you think a letter has been shifted forward in the alphabet by a few positions, shift it backward by the same number to recover the original.</li>
                    <li>Challenge: Try shifting each letter back by 1, 2, or 3 positions to see if a meaningful word appears.</li>
                    
                </ul>

                <li class="olType">Remember the Alphabet’s Loop</li>
                <ul>
                    <li>When shifting, if the letter goes past Z, it loops back to the start of the alphabet. For example, shifting X forward by 3 results in A.</li>
                    <li>Challenge: If a letter is close to the end of the alphabet (like Y or Z), think about how it wraps around to A.</li>
                </ul>
            </ol>

            <h1>Game Instructions:</h1>
            <ul class="steps">
                <li><span>Step 1: </span> Look at the encrypted text in the file. Try different shift values (from 1 to 25) to decode the message.</li>
                <li><span>Step 2: </span>  Use the hints above to analyze the patterns in the text. Look for common letters, words, and letter positions.</li>
                <li><span>Step 3: </span>  If you believe you’ve figured out the shift number, apply it to the entire message to reveal the original text.</li>
            </ul>

            <div class="keyMessage">
                <h1>Find your Key</h1>

                <p>Key is hidden inside the below message you have to find the key</p>

                <h2>Message: Four times the wind blows, as four corners meet. The square has a secret. Look between the words, but the answer is singular.</h2>
                <!-- <h3>Hint to solve message</h3> -->
                <p><b>Hint: </b> The key is exactly what you think it is after reading carefully.</p>
            </div>
            
            <% } else if(encryptionType.equals("polyalphabetic")) {%>
                <h1>Welcome to Crack the <%=encryptionType%></h1>

                <p class="story">
                    A secret message has been intercepted from a rogue agent, but this time, the encryption is more complex. The file has been encoded using a Polyalphabetic Cipher, which means the encryption shifts letters by a varying amount, based on a keyword known only to the agent.
                    <br/> <br/>
                    Your mission is to crack the code and reveal the secret. Decoding this message is trickier, but a few hints left behind might help. Will you be able to decrypt the file using the keyword?
                </p>

                <h1>Hints to Decrypt the File:</h1>

                <ol>
                    <li class="olType">The Keyword Holds the Key</li>
                    <ul>
                        <li>Unlike the Caesar cipher, which uses a single shift, this cipher changes shifts based on a keyword.</li>
                        <li>The keyword repeats over the length of the message.</li>
                        <li>Challenge: Look for patterns. The same letter may be encrypted differently based on where it appears in the message.</li>
                    </ul>
                    <li class="olType">Analyze Letter Frequencies</li>
                    <ul>
                        <li>Even though the cipher is more complex, certain letters (like E or T) still appear frequently in English text.</li>
                        <li>Try to find the repeating keyword or part of it by comparing how often letters occur.</li>
                        <li>Challenge: Is there a word in the encrypted message that seems to follow a pattern?</li>
                    </ul>

                    <li class="olType"> Shifting Based on the Keyword</li>
                    <ul>
                        <li>Each letter in the keyword corresponds to a different shift. The first letter of the keyword might shift the alphabet by 3, the second by 7, and so on.</li>
                        <li>Challenge: Test out small words or repeated letters (like "the") and try shifting them based on guessed keywords.</li>

                    </ul>

                    <li class="olType"> Repeating Cipher Key</li>
                    <ul>
                        <li>The keyword is repeated across the length of the message, looping back to the start after reaching the end of the keyword.</li>
                        <li>Challenge: If you can figure out part of the keyword, you can use it to start decoding the rest of the message.</li>

                    </ul>

                    <li class="olType">The Vigenère Table</li>
                    <ul>
                        <li>Polyalphabetic Ciphers often use a Vigenère Table for encryption. This table shifts the alphabet based on each letter in the keyword.</li>
                        <li>Challenge: If you know the first few letters of the keyword, you can use them to decrypt the first few letters of the text.</li>
                    </ul>
                </ol>

                <h1>Game Instructions:</h1>
                <ul class="steps">
                    <li><span>Step 1: </span> Figure out what the keyword might be by analyzing letter patterns and frequencies.</li>
                    <li><span>Step 2: </span>  Apply the shifts based on your guessed keyword. If you’re right, a readable message will begin to emerge.</li>
                    <li><span>Step 3: </span>  Decrypt the entire message using the full keyword!</li>
                    <li><span>Step 4: </span> You have to decrypt the text and put that text in new file and provide that file below</li>
                </ul>

                <div class="keyMessage">
                    <h1>Find your Key</h1>
    
                    <p>Key is hidden inside the below message you have to find the key</p>
    
                    <h2>Message: Have A Cup of tea, Karen.</h2>
                    <!-- <h3>Hint to solve message</h3> -->
                    <p><b>Hint: </b> Look at the capital letter.</p>
                </div>
                
                <% } else if(encryptionType.equals("columnar")) {%>
                
                <h1>Welcome to Crack the Columnar Cipher</h1> 

                <p class="story">
                    A mysterious message has surfaced, encrypted using the Columnar Cipher, a classic transposition technique used in espionage. Unlike substitution ciphers, this method rearranges the letters of the message based on a keyword.
                    <br/> <br/>
                    Your mission is to unscramble the message by finding the right keyword that determines the rearrangement. Will you be able to reveal the hidden message?
                </p>

                <h1>Hints to Decrypt the File:</h1>

                <ol>
                    <li class="olType">Understand the Columnar Cipher Structure</li>
                    <ul>
                        <li>The message is written in rows based on a specific width, determined by the keyword.</li>
                        <li>The letters are then rearranged by reading down the columns, but the columns themselves are rearranged according to the alphabetical order of the keyword.</li>
                        <li>Challenge: Try to figure out the number of columns by analyzing the length of the message and any repeating patterns.</li>
                    </ul>

                    <li class="olType">The Keyword Determines the Column Order</li>
                    <ul>
                        <li>The keyword tells you how to rearrange the columns. For example, a keyword of "SPY" might change the order of the columns based on the alphabetical order of the letters (P comes first, then S, and Y last).</li>
                        <li>Challenge: Look for clues in the message that might reveal the keyword. Short, common words like "the" may help you guess the rearrangement.</li>
                    </ul>

                    <li class="olType">Analyze Letter Patterns</li>
                    <ul>
                        <li>Even though the letters are scrambled, common English letter patterns (like TH, HE, or ER) might still emerge once the columns are partially rearranged.</li>
                        <li>Challenge: Identify letter pairings that might signal how the columns are shifted.</li>
                    </ul>

                    <li class="olType">Columns and Rows</li>
                    <ul>
                        <li>Once you find the correct column order, you’ll read the message by going down each column in the correct sequence.</li>
                        <li>Challenge: Try different column widths and see if readable text starts to emerge.</li>
                    </ul>

                    <li class="olType">The Keyword Length</li>
                    <ul>
                        <li>Determining the length of the keyword is critical, as it tells you how many columns there are. The keyword length can often be guessed by looking at the structure of the message or from contextual hints.</li>
                        <li>Challenge: Experiment with different keyword lengths and observe how the message begins to form.</li>
                    </ul>
                </ol>

                <h1>Game Instructions:</h1>
                <ul class="steps">
                    <li><span>Step 1: </span> Figure out the length of the keyword by analyzing the message's structure.</li>
                    <li><span>Step 2: </span> Rearrange the columns based on the alphabetical order of the keyword’s letters.</li>
                    <li><span>Step 3: </span> Once the columns are rearranged, read the message by going down the columns in the new order.</li>
                    <li><span>Step 4: </span> You have to decrypt the text and put that text in new file and provide that file below</li>
                </ul>

                <div class="keyMessage">
                    <h1>Find your Key</h1>
    
                    <p>Key is hidden inside the below message you have to find the key</p>
    
                    <h2>Message: Have A Cup of tea, Karen.</h2>
                    <!-- <h3>Hint to solve message</h3> -->
                    <p><b>Hint: </b> Look at the capital letter.</p>
                </div>

                
                
            <% } else { %>
                <h1>Welcome to Crack the <%=encryptionType%></h1>

                <p class="story">
                    Your team has recovered a file that holds vital information, but it’s been encrypted using the Playfair Cipher, an advanced cipher technique used by spies. This is no ordinary cipher—pairs of letters are encoded together, making it harder to break.
                    <br/> <br/>
                    Will you be able to solve this forgotten puzzle and decrypt the message before it’s too late?
                </p>

                <h1>Hints to Decrypt the File:</h1>

                <ol>
                    <li class="olType"> It’s All About Pairs</li>
                    <ul>
                        <li>Unlike other ciphers, the Playfair cipher works by encrypting pairs of letters.</li>
                        <li>Every two letters are placed into a grid, and their positions determine the encryption.</li>
                        <li>Challenge: Look at the pairs of letters and see if any patterns emerge. Two common letters like TH or HE may give you a clue.</li>
                    </ul>
                    <li class="olType">The Grid of Letters</li>
                    <ul>
                        <li>The cipher uses a 5x5 grid of letters to encrypt the text. The keyword generates the grid, and the rest of the alphabet follows.</li>
                        <li>Challenge: Try guessing parts of the grid based on common letter combinations.</li>
                    </ul>

                    <li class="olType">Watch for Rules in the Grid</li>
                    <ul>
                        <li>If the two letters in the pair are in the same row, they are shifted to the right.</li>
                        <li>If they are in the same column, they are shifted down.</li>
                        <li>If they form a rectangle, they are swapped diagonally.</li>
                        <li>Challenge: Once you figure out the grid or parts of it, apply these rules to decrypt pairs of letters.</li>
                    </ul>

                    <li class="olType">Beware of Duplicates</li>
                    <ul>
                        <li>Duplicate letters (like LL in "hello") are not allowed in Playfair. Instead, a filler letter (often X) is added.</li>
                        <li>Challenge: If you see strange X’s in the text, they might have been added to separate duplicate letters!</li>

                    </ul>

                    <li class="olType">Finding the Keyword</li>
                    <ul>
                        <li>The keyword creates the initial grid. The rest of the letters of the alphabet follow, excluding J (or sometimes Q).</li>
                        <li>Challenge: If you think you know part of the keyword, build the grid and try using it to decrypt the file.</li>
                    </ul>
                </ol>

                <h1>Game Instructions:</h1>
                <ul class="steps">
                    <li><span>Step 1: </span> Break the message into pairs of letters.</li>
                    <li><span>Step 2: </span>  Use the hints to figure out how the pairs were shifted based on the grid.</li>
                    <li><span>Step 3: </span>  Once you have an idea of how the letters move in the grid, apply the Playfair rules to decode the pairs.</li>
                    <li><span>Step 4: </span> You have to decrypt the text and put that text in new file and provide that file below</li>
                </ul>

                <div class="keyMessage">
                    <h1>Find your Key</h1>
    
                    <p>Key is hidden inside the below message you have to find the key</p>
    
                    <h2>Message: Have A Cup of tea, Karen.</h2>
                    <!-- <h3>Hint to solve message</h3> -->
                    <p><b>Hint: </b> Look at the capital letter.</p>
                </div>
            <% } %>

            
            

            <div class="inputcontainer">
<!--                <h2>You have to decrypt the text and put that text in new file and provide that file</h2>-->
                <form action="Validate" method="post" enctype="multipart/form-data">

                    <div class="textInput">
                        <label for="firstname" class="">Enter a Key</label>
                        <input id="key" type="text" name="keys" placeholder="Enter a key" />
                      </div>

                      <div class="">
                          <input type="file" class="custom-file-input" name="decodedFile" required>
                        <input type="hidden" name="originalContent" value="${originalcontent}">
                      </div>

                      

                      <button type="submit">Submit</button>
                </form>
            </div>
            
        </div>
        
        
    </body>
</html>
