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
 * QuizServletはユーザーのログイン処理とクイズ一覧表示を担当するサーブレット
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
//    親クラス（HttpServlet）のコンストラクタを呼び出す
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    //doGet メソッドは、HTTP GET リクエストを処理するためにサーブレットによって実装されるメソッド
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータからメールアドレスとパスワードを取得
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        // ユーザーの情報をデータベースから取得
        User user = UserDAO.getUser(mail);
        // パスワードが一致するか確認
        if (password.equals(user.getPassword())) {
             // ログイン成功。セッションにユーザー情報を格納。
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // ユーザーに関連するクイズ一覧を取得（QuizDAOを使って、DateBaseにアクセスしデータを取得）
            List<Quiz> quizList = QuizDAO.selectQuizListByUser(user.getId());
            request.setAttribute("quizList", quizList);

             // 遷移先のJSPファイルを指定してフォワード
            String view = "/last/2.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } else { // ログイン失敗（1.jspに戻る）
            String view = "/last/1.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
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
