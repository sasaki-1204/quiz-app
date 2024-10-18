package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuizDAO;
import dto.Quiz;

/**
 * Servlet implementation class QuizTryServlet
 * QuizTryServletはクイズをとく画面を呼び出すためのサーブレットです。
 */
@WebServlet("/QuizTryServlet")
public class QuizTryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 親クラス（HttpServlet）のコンストラクタを呼び出す
     */
    public QuizTryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         * doGet メソッドは、HTTP GET リクエストを処理するためにサーブレットによって実装されるメソッド
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからクイズIDを取得
                int quizId = Integer.parseInt(request.getParameter("quizId"));
		// クイズIDを使用してクイズ情報を取得
                Quiz quiz = QuizDAO.selectQuizById(quizId);
		
                // クイズ情報をセット
		request.setAttribute("quiz", quiz);
		
                 // 遷移先のJSPファイルを指定してフォワード
                String view = "/last/3.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         * HTTP POST リクエストを処理するためのメソッド
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}