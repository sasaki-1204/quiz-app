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
        <style>
            /* resset.*/

            /* # =================================================================
               # Global selectors
               # ================================================================= */

            html {
                box-sizing: border-box;
                -webkit-text-size-adjust: 100%; /* Prevent adjustments of font size after orientation changes in iOS */
                word-break: normal;
                -moz-tab-size: 4;
                tab-size: 4;
            }

            *,
            ::before,
            ::after {
                background-repeat: no-repeat; /* Set `background-repeat: no-repeat` to all elements and pseudo elements */
                box-sizing: inherit;
            }

            ::before,
            ::after {
                text-decoration: inherit; /* Inherit text-decoration and vertical align to ::before and ::after pseudo elements */
                vertical-align: inherit;
            }

            * {
                padding: 0; /* Reset `padding` and `margin` of all elements */
                margin: 0;
            }

            /* # =================================================================
               # General elements
               # ================================================================= */

            a {
                text-decoration: none;  /* アンダーラインを削除 */
                color: inherit;         /* 親要素の文字色を継承 */
            }

            a:hover, a:focus {
                text-decoration: none;  /* ホバーやフォーカス時のアンダーラインも削除 */
            }

            ul {
                list-style:none;    /* リストの点を削除 */
            }

            hr {
                overflow: visible; /* Show the overflow in Edge and IE */
                height: 0; /* Add the correct box sizing in Firefox */
                color: inherit; /* Correct border color in Firefox. */
            }

            details,
            main {
                display: block; /* Render the `main` element consistently in IE. */
            }

            summary {
                display: list-item; /* Add the correct display in all browsers */
            }

            small {
                font-size: 80%; /* Set font-size to 80% in `small` elements */
            }

            [hidden] {
                display: none; /* Add the correct display in IE */
            }

            abbr[title] {
                border-bottom: none; /* Remove the bottom border in Chrome 57 */
                /* Add the correct text decoration in Chrome, Edge, IE, Opera, and Safari */
                text-decoration: underline;
                text-decoration: underline dotted;
            }

            a {
                background-color: transparent; /* Remove the gray background on active links in IE 10 */
            }

            a:active,
            a:hover {
                outline-width: 0; /* Remove the outline when hovering in all browsers */
            }

            code,
            kbd,
            pre,
            samp {
                font-family: monospace, monospace; /* Specify the font family of code elements */
            }

            pre {
                font-size: 1em; /* Correct the odd `em` font sizing in all browsers */
            }

            b,
            strong {
                font-weight: bolder; /* Add the correct font weight in Chrome, Edge, and Safari */
            }

            /* https://gist.github.com/unruthless/413930 */
            sub,
            sup {
                font-size: 75%;
                line-height: 0;
                position: relative;
                vertical-align: baseline;
            }

            sub {
                bottom: -0.25em;
            }

            sup {
                top: -0.5em;
            }

            table {
                border-color: inherit; /* Correct border color in all Chrome, Edge, and Safari. */
                text-indent: 0; /* Remove text indentation in Chrome, Edge, and Safari */
            }

            iframe {
                border-style: none;
            }

            /* # =================================================================
               # Forms
               # ================================================================= */

            input {
                border-radius: 0;
            }

            [type='number']::-webkit-inner-spin-button,
            [type='number']::-webkit-outer-spin-button {
                height: auto; /* Correct the cursor style of increment and decrement buttons in Chrome */
            }

            [type='search'] {
                /* 非推奨なのでコメントアウトした */
                /* -webkit-appearance: textfield; Correct the odd appearance in Chrome and Safari */
                outline-offset: -2px; /* Correct the outline style in Safari */
            }

            [type='search']::-webkit-search-decoration {
                -webkit-appearance: none; /* Remove the inner padding in Chrome and Safari on macOS */
            }

            textarea {
                overflow: auto; /* Internet Explorer 11+ */
                resize: vertical; /* Specify textarea resizability */
            }

            button,
            input,
            optgroup,
            select,
            textarea {
                font: inherit; /* Specify font inheritance of form elements */
            }

            optgroup {
                font-weight: bold; /* Restore the font weight unset by the previous rule */
            }

            button {
                overflow: visible; /* Address `overflow` set to `hidden` in IE 8/9/10/11 */
            }

            button,
            select {
                text-transform: none; /* Firefox 40+, Internet Explorer 11- */
            }

            /* Apply cursor pointer to button elements */
            button,
            [type='button'],
            [type='reset'],
            [type='submit'],
            [role='button'] {
                cursor: pointer;
            }

            /* Remove inner padding and border in Firefox 4+ */
            button::-moz-focus-inner,
            [type='button']::-moz-focus-inner,
            [type='reset']::-moz-focus-inner,
            [type='submit']::-moz-focus-inner {
                border-style: none;
                padding: 0;
            }

            /* Replace focus style removed in the border reset above */
            button:-moz-focusring,
            [type='button']::-moz-focus-inner,
            [type='reset']::-moz-focus-inner,
            [type='submit']::-moz-focus-inner {
                outline: 1px dotted ButtonText;
            }


            /* Remove the default button styling in all browsers */
            button,
            input,
            select,
            textarea {
                background-color: transparent;
                border-style: none;
            }

            a:focus,
            button:focus,
            input:focus,
            select:focus,
            textarea:focus {
                outline-width: 0;
            }


            select::-ms-expand {
                display: none; /* Internet Explorer 11+ */
            }

            select::-ms-value {
                color: currentColor; /* Internet Explorer 11+ */
            }

            legend {
                border: 0; /* Correct `color` not being inherited in IE 8/9/10/11 */
                color: inherit; /* Correct the color inheritance from `fieldset` elements in IE */
                display: table; /* Correct the text wrapping in Edge and IE */
                max-width: 100%; /* Correct the text wrapping in Edge and IE */
                white-space: normal; /* Correct the text wrapping in Edge and IE */
                max-width: 100%; /* Correct the text wrapping in Edge 18- and IE */
            }

            ::-webkit-file-upload-button {
                /* Correct the inability to style clickable types in iOS and Safari */
                -webkit-appearance: button;
                color: inherit;
                font: inherit; /* Change font properties to `inherit` in Chrome and Safari */
            }

            /* Replace pointer cursor in disabled elements */
            [disabled] {
                cursor: default;
            }

            /* # =================================================================
               # Specify media element style
               # ================================================================= */

           

            /* Add the correct vertical alignment in Chrome, Firefox, and Opera */
            progress {
                vertical-align: baseline;
            }

            /* # =================================================================
               # Accessibility
               # ================================================================= */

            /* Specify the progress cursor of updating elements */
            [aria-busy='true'] {
                cursor: progress;
            }

            /* Specify the pointer cursor of trigger elements */
            [aria-controls] {
                cursor: pointer;
            }

            /* Specify the unstyled cursor of disabled, not-editable, or otherwise inoperable elements */
            [aria-disabled='true'] {
                cursor: default;
            }
            /*style*/
            html, body {
                margin: 0;
                padding: 0;
            }
            body {
                text-align: center;
                background-color: #ffc0cb;
                font-size: 18px;
                font-family: 'HG創英角ｺﾞｼｯｸUB';
            }

            header {
                display: flex;
                justify-content: space-between;
                height: 72px;
                background-color: #ffb6c1;
                color: white;
                font-size: 36px;
            }

            #header-title {
                margin: auto 100px;
            }

            #header-contents {
                margin: auto 10px;
                display: flex;
            }

            #level {
                margin: 10px 0;
                font-size: 32px;
                font-family: 'Segoe UI';
            }

            #user-icon {
                margin-left: 10px;
                width: 60px;
                height: 60px;
            }

            /*lobin*/
            #main-contents {
                text-align: center;
            }

            #login-form {
                margin: 60px auto 0;
                text-align: center;

                width: 550px;
                height: 450px;
                background-color: white;
                font-family: 'メイリオ', 'Meiryo', sans-serif;
            }

            #input-area{
                padding: 60px 0 0 50px;
                text-align: left;
            }

            input[type=text], input[type=password] {
                margin-bottom: 40px;
                padding: 8px;

                width: 450px;
                height: 36px;
                background-color: white;
                border:  #808080 1px solid;
            }

            input[type=text]:focus, input[type=password]:focus {
                border:  black 2px solid;     /*フォーカス時に枠線を太くする*/
                box-shadow: inset 0 10px 25px 0 rgba(0, 0, 0, .05);  /*フォーカス時に影を付ける*/
            }

            .input-format {
                margin-left: 20px;

                font-size: 16px;
                color: grey;
            }

            #submit-button{
                text-align: center;
            }

            button[type=submit] {
                margin: 20px auto 30px;

                width: 150px;
                height: 50px;
                border-radius: 25px;
                background-color: #dda0dd;
                font-family: 'HG創英角ｺﾞｼｯｸUB';
                color: white;
            }

            .small-link {
                display: block;
                margin-bottom: 8px;
                color: #deb887;
                font-size: 20px;
            }
        </style>
        <header>
            <div id="header-title">バスケクイズ</div>
            <div id="header-contents">
            </div>
        </header>

        <div id="main-contents">
            <!<!-- １．jspのform内容をクイズサーブレットに送信 -->
            <form action="/Web/QuizServlet" method="post" id="login-form"> 

                <div id="input-area">
                    <label>メールアドレス</label>
                    <input type="text" name="mail"><br>

                    <label>パスワード<span class="input-format">※半角英数字</span></label><br>
                    <div class="password-container">
                        <input type="password" name="password" id="password-input">
                        <!-- 表示/非表示切り替え -->
                        <button type="button" id="toggle-password" style="font-family: 'Font Awesome 6 Free Solid';">👁️
                        </button>
                    </div>
                </div>

                <button type="submit">ログイン</button>
                <br>
　　　　　　　　　　<!--5.jspへ画面遷移 -->
                <a href="/Web/last/5.jsp" class="small-link">新規アカウント登録はこちら</a>

            </form>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const togglePasswordButton = document.getElementById('toggle-password');
                const passwordInput = document.getElementById('password-input');
                togglePasswordButton.addEventListener('click', () => {
                    console.log('click!');
                    // パスワードの表示/非表示を切り替える
                    const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
                    passwordInput.setAttribute('type', type);
                    
                });
            });
        </script>
    </body>
</html>