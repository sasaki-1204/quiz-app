package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDAO;
import dto.Quiz;
import dto.User;

/**
 * Servlet implementation class QuizResultServlet QuizResultServlet:
 * クイズ結果を処理するサーブレットクラス
 */
@WebServlet("/QuizResultServlet")
public class QuizResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()コンストラクタ
     */
    public QuizResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response) GETメソッド: クイズ結果の処理を行います。
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // セッションからユーザー情報を取得
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        // パラメータから回答とクイズIDを受け取って変数に代入
        int ans = Integer.parseInt(request.getParameter("ans"));
        int quizId = Integer.parseInt(request.getParameter("quizId"));
        Quiz quiz = QuizDAO.selectQuizById(quizId);
        // 正解かどうかを判定し、結果を設定
        int result = (ans == quiz.getCorrect()) ? 1 : 2;

        // クイズの回答履歴
        if (QuizDAO.selectQuizRecord(user.getId(), quizId) == 0) {
            // レコードが空だったらINSERT
            QuizDAO.registerQuizRecord(user.getId(), quizId, result);
        } else {
            // 回答済みだったらUPDATE
            QuizDAO.updateQuizRecord(user.getId(), quizId, result);
        }

        // リクエストに結果とクイズ情報を設定
        request.setAttribute("result", result);
        request.setAttribute("quiz", quiz);

        // 正解の選択肢を特定してリクエストに設定
        String correct = "";
        switch (quiz.getCorrect()) {
            case 1:
                correct = quiz.getChoices_1();
                break;
            case 2:
                correct = quiz.getChoices_2();
                break;
            case 3:
                correct = quiz.getChoices_3();
                break;
            case 4:
                correct = quiz.getChoices_4();
                break;
        }
        request.setAttribute("correct", correct);

        // 遷移先のJSPを指定してフォワード
        String view = "/last/4.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
