
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
 * RegisterServletは新規ユーザー登録を担当するサーブレットです
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータからユーザー情報を取得
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");

        // ユーザーの新規登録を行い、結果を受け取る
        int result= UserDAO.registerUser(name, mail, password);

        // 登録結果に応じて適切なページに遷移
        if (result == 1){// 登録成功
            String view = "/last/1.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } else {// 登録失敗
            String view = "/last/5.jsp";
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
