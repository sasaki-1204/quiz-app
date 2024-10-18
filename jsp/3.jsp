<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="dto.User"%>
<%@ page import="dto.Quiz"%>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>Document</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/quiz-try.css">
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

            #main-contents {
                margin-top: 30px;
            }

            #page-title {
                font-size: 36px;
                font-family: 'HG創英角ｺﾞｼｯｸUB';
                font-weight: lighter;
            }

            #quiz-chart {
                margin: 20px auto;
                padding-top: 10px;
                width: 680px;
                height: 80px;
                background-color: white;
            }

            .records {
                margin-left: 30px;
            }

            #chart {
                text-align: left;

                margin: 20px auto;
                width: 600px;
                height: 10px;

                background-color: #ddd;
            }

            .bad {
                height: 10px;
                background-color: #2941BC;
            }

            .good {
                height: 10px;
                background-color: #B01B3C;
            }

            #quiz-list {
                display: block;
                margin: 40px auto;
                width: 800px;
            }

            .quiz {
                display: flex;
                margin-bottom: 10px;
                padding: 10px 20px;
                position: relative;

                height: 48px;

                background-color: white;
                border: black 1px solid;
                border-radius: 20px;

                font-family: 'メイリオ', 'Meiryo', sans-serif;
                font-size: 18px;
            }

            .quiz-title {
                position: absolute;
                left: 100px;
            }

            .quiz-status {
                position: absolute;
                top: 5px;
                right: 20px;

                font-size: 28px;
                font-family: 'メイリオ', 'Meiryo', sans-serif;
                font-weight: bold;
            }

            .right-upper-contents {
                position: absolute;
                top: 100px;
                right: 0px;

                width: 250px;
            }

            #correct-answers {
                font-size: 24px;
            }

            button {
                margin-top: 20px;
                height: 48px;
                width: 150px;
                border-radius: 24px;

                color: white;
                background-color: #8a2be2;
            }

        </style>
        <header>
            <div id="header-title">バスケクイズ</div>
            <div id="header-contents">
            </div>
        </header>
        <button class="back-button"  onclick="location.href = '/Web/TopServlet'">戻る</button>

        <div id="quiz">
            <%
                Quiz q = (Quiz) request.getAttribute("quiz");
            %>
            <h2>
                問題<%=q.getQuizId()%></h2>
            <p><%=q.getQuestion()%></p>
            <div id="answer">
                <button class="ans-button" onclick="location.href = '/Web/QuizResultServlet?ans=1&quizId=<%=q.getQuizId()%>'">A.<%=q.getChoices_1()%></button>
                <button class="ans-button" onclick="location.href = '/Web/QuizResultServlet?ans=2&quizId=<%=q.getQuizId()%>'">B.<%=q.getChoices_2()%></button>
                <button class="ans-button" onclick="location.href = '/Web/QuizResultServlet?ans=3&quizId=<%=q.getQuizId()%>'">C.<%=q.getChoices_3()%></button>
                <button class="ans-button" onclick="location.href = '/Web/QuizResultServlet?ans=4&quizId=<%=q.getQuizId()%>'">D.<%=q.getChoices_4()%></button>
            </div>
        </div>
    </body>
</html>