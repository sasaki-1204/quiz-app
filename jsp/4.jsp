<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="dto.Quiz"%>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
       
        <title>Quiz</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/style2.css">
        <link rel="stylesheet" href="css/quiz-result.css">

    </head>
    <body>
        <style>
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

            #result {
                margin-top: 30px;
            }

            #result > .res {
                display: block;
                margin-bottom: 20px;
                font-size: 64px;
            }
            button {
                margin: 20px 60px;
                height: 48px;
                width: 150px;
                border-radius: 24px;

                color: white;
                background-color: #8a2be2;
            }

            #ex-title {
                position: relative;
                left: -550px;

                font-size: 32px;
                font-weight: normal;
                font-family: 'メイリオ', 'Meiryo', sans-serif;
            }

            #explanation {
                margin: auto;
                font-family: 'メイリオ', 'Meiryo', sans-serif;
                width: 800px;
            }


        </style>
        <header>
            <div id="header-title">バスケクイズ</div>
            <div id="header-contents">
               
            </div>
        </header>

        <div id="main-contents">
            <%
                int result = (int) request.getAttribute("result");
                Quiz q = (Quiz) request.getAttribute("quiz");
                String correct = (String) request.getAttribute("correct");


            %>
            <div id="result">
                <% if (result == 1) { %>
                <span class="res">正解です!</span>
                <span class="res">◯</span>
                <%} else { %>
                <span class="res">不正解です...</span>
                <span class="res">✕</span>
                <%}%>
            </div>
            <br>
            <div>正解は<%=q.getCorrect()%>. <%=correct%></div>
            <div id="button-group">
                <button onclick="location.href = '/Web/TopServlet'">クイズ一覧</button>
                <button onclick="location.href = '/Web/QuizTryServlet?quizId=<%=q.getQuizId() + 1 %>'">次の問題</button>
            </div>


            <h2 id="ex-title">解説</h2>
            <hr>
            <br>
            <div id="explanation">
                <%=q.getExplanation()%>
            </div>

        </div>
    </body>
</html>