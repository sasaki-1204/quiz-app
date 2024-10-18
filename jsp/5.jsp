<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <header>
            <div id="header-title">バスケクイズ　新規アカウント登録</div>
            <div id="header-contents">
            </div>
        </header>

        <div id="main-contents">
            <form action="/Web/RegisterServlet" method="post" id="login-form">

                <div id="input-area">
                    <label>名前<span class="input-format">※ローマ字</label><br>
                    <input type="text" name="name"><br>
                    
                    <label>メールアドレス</label>
                    <input type="text" name="mail"><br>

                    <label>パスワード<span class="input-format">※半角英数字</span></label><br>
                    <div class="password-container">
                        <input type="password" name="password" id="password-input">
                        <button type="button" id="toggle-password" style="font-family: 'Font Awesome 6 Free Solid';">👁️
</button>
                    </div>
                </div>

                <button type="submit">ログイン</button>
                <br>

                
            </form>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const togglePasswordButton = document.getElementById('toggle-password');
                const passwordInput = document.getElementById('password-input');

                togglePasswordButton.addEventListener('click', () => {
                    // パスワードの表示/非表示を切り替える
                    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
                    passwordInput.setAttribute('type', type);
                  
                });
            });
        </script>
    </body>
</html>