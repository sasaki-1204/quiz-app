<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<%@ page import="dto.Quiz" %>
<%@ page import="dao.QuizDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Quiz</title>
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/quiz-top.css">
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

        <div id="main-contents">
            <h1 id="page-title">クイズ一覧</h1>
            <div id="quiz-chart">
                <div id="quiz-records">
                    <%
                        //セッションからユーザー情報を取得
                        User user = (User) session.getAttribute("user");
                         //回答状況の表示に必要なデータを用意（QuizDAOでDataBaseから取得）
                        int countCorrect = QuizDAO.CountCorrect(user.getId());
                        int countAns = QuizDAO.CountAns(user.getId());
                        //不正解の数を計算
                        int countFail = countAns - countCorrect;
                        //未回答の数を計算
                        int notAns = 30 - countAns;

                        
                    %>

                    <!--帯グラフの上の回答状況の表示 -->
                    <span class="records" style="color: #B01B3C">正解:<%=countCorrect%></span>
                    <span class="records" style="color: #2941BC">不正解:<%=countFail%></span>
                    <span class="records" style="color: #aac">未回答:<%=notAns%></span>
                </div>
                <!--帯グラフの表示 -->
                <div id="chart">
                    <div class="bad" data-bad="<%=countAns%>">
                        <div class="good" data-good="<%=countCorrect%>"></div>
                    </div>
                </div>
            </div>
            <div id="quiz-list">
                <!--  このクイズ一つ一つをfor文で繰り返す  -->
                <%
                    //quizサーブレットで送ったデータを取得
                    ArrayList<Quiz> quizList = (ArrayList<Quiz>) request.getAttribute("quizList");
                    for (Quiz q : quizList) {//QuizListからクイズインスタンスを一つずつ取り出す拡張FOｒ文。
                %>
                <!--クイズクラスのインスタンスから各フィールドの値を取得 -->
                <a href="QuizTryServlet?quizId=<%=q.getQuizId()%>">
                    <div class="quiz">
                        <div class="quiz-num">問題<%=q.getQuizId()%></div><!--ＩＤ  -->
                        <div class="quiz-title"><%=q.getTitle()%></div><!--タイトル -->
                        <div class="quiz-status"><!--回答状況  -->
                            <% if (q.getStatus() == 0) { %>　<!--回答状況に応じて場合分け-->
                            <span style="color: #aac">ー</span>
                            <% } else if (q.getStatus() == 1) { %>
                            <span style="color: #B01B3C">◯</span>
                            <% } else { %>
                            <span style="color: #2941BC">✕</span>
                            <% } %>
                        </div>
                    </div>
                </a>
                <% }%>
            
        <div class="right-upper-contents">
            <div id="correct-answers">正答数 <span class="correct-count"><%=countCorrect%></span>/30</div>
            <!-- <button>ランダム出題</button> -->
        </div>

        <script>
            //帯グラフをかく
            let bad = document.querySelector(".bad");
            let badCount = document.querySelector(".bad").dataset.bad;
            bad.style.width = (badCount * 20) + 'px';//不正解数×２０ｐｘ分青線のびる

            let good = document.querySelector(".good");
            let goodCount = document.querySelector(".good").dataset.good;
            good.style.width = (goodCount * 20) + 'px';//正解数×２０ｐｘ分赤線のびる

        </script>
    </body>
</html>
