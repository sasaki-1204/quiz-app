package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDAO;
import dao.UserDAO;
import dto.Quiz;
import dto.User;

/**
 * Servlet implementation class QuizServlet
 * TopServletはクイズ一覧表示のみを担当するサーブレットです。（戻るとクイズ一覧へを押したとき用）セッションにない、クイズリストをDataBeseから取得している
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()コンストラクタ
     */
    public TopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        // ユーザーごとに関連するクイズ一覧を取得
        List<Quiz> quizList = QuizDAO.selectQuizListByUser(user.getId());
        request.setAttribute("quizList", quizList);

        // 遷移先のJSPファイルを指定してフォワード
        String view = "/last/2.jsp";
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
