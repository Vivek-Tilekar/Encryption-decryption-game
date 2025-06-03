<%-- 
    Document   : index
    Created on : 26-Sept-2024, 11:14:21 am
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Encryption Game</title>
        <link rel="stylesheet" href="home.css">
    </head>
    <body>
        
        <form method="post" enctype="multipart/form-data">
            <h1 class="score"></h1>
            <div class="inner-container">
                <div class="inputbox inputbox1">
                    <input type="file" name="file" id="encrypt" class="selector" onclick="form.action='Home';" onchange="form.submit()">
                    <h1>Encryption</h1>
                </div>
                <div class="inputbox inputbox2">
                    <input type="file" name="file2" id="decrypt" class="selector"onClick="form.action='DecryptHome'"  onchange="form.submit()">
                    <h1>Decryption</h1>
                </div>
            </div>

            <select name="encryption" id="type" required>
                <option value="ceaser">Ceaser</option>
                <option value="polyalphabetic">Polyalphabetic</option>
                <option value=" playfair"> Playfair</option>
                <option value=" columnar"> Columnar</option>
            </select>
        </form>

        <!-- <script>
            document.getElementsByClassName("selector").onchange = function() {
                document.getElementById("form").submit();
            };
        </script> -->
    </body>
</html>
