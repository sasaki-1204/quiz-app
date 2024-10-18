package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Quiz;

// QuizDAOクラスはクイズに関するデータベースアクセスを担当します。
public class QuizDAO {
    // DB接続をするメソッド

    private static Connection getConnection() throws URISyntaxException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //com.mysql.jdbc.Driverはドライバのクラス名
            String url = "jdbc:mysql://localhost/quiz?characterEncoding=UTF-8"; //quizがデータベース名：文字エンコードはUTF-8
            Connection conn = DriverManager.getConnection(url, "root", "e1tehzd9"); //上記URL設定でユーザ名とパスワードを使って接続
            return conn;
        } catch (Exception e) {
            return null;
        }
    }

    // ユーザー毎に全てのクイズを取得するメソッド
    public static List<Quiz> selectQuizListByUser(int userId) {
        System.out.println("aiueo");
        // 実行するSQL文（クイズテ－ブルとanswer_recordテーブルを外部結合して回答記録が空だったら０に置き換える。）
        String sql = "SELECT quiz.*, COALESCE(ar.status, 0) AS status FROM quiz LEFT OUTER JOIN (select * from answer_record WHERE user_id=?) as ar ON quiz.id=ar.quiz_id ORDER BY quiz.id";
        // 返却用のListインスタンス
        List<Quiz> result = new ArrayList<>();

        
        try (//データベースに接続　？に値を結びつけるためのPreparedStatement（インスタンス）
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            //？にユーザーIDを結びつける 
            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {//SQL実行

                //1行ずつ値をセット
                while (rs.next()) {
                    int quiz_id = rs.getInt("id");
                    String question = rs.getString("question");
                    String title = rs.getString("title");
                    String choices_1 = rs.getString("choices_1");
                    String choices_2 = rs.getString("choices_2");
                    String choices_3 = rs.getString("choices_3");
                    String choices_4 = rs.getString("choices_4");
                    int correct = rs.getInt("correct");
                    String explanation = rs.getString("explanation");
                    int status = rs.getInt("status");

                     // クイズオブジェクトを作成してリストに追加
                    Quiz quiz = new Quiz(quiz_id, question, title, choices_1, choices_2,
                            choices_3, choices_4, correct, explanation, status);
                    result.add(quiz);
                }
            } catch (SQLException e) {// TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            // TODO 自動生成された catch ブロック
            e1.printStackTrace();
        } catch (URISyntaxException e2) {
            // TODO 自動生成された catch ブロック
            e2.printStackTrace();
        }
        //Listを返却する。0件の場合は空のListが返却される。
        return result;
    }

    //クイズの正答数を数えるメソッド
    public static int CountCorrect(int userId) {
        //ユーザーごとに正答数を取得
        String sql = "SELECT count(*) as count FROM answer_record WHERE user_id=? AND status=1";
        try (
                //データベースに接続　？に値を結びつけるためのPreparedStatement（インスタンス）
                Connection con = getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, userId);
            // sql実行
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");//値をJavaの値にセット
                    return count;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //クイズの回答数を数えるメソッド
    public static int CountAns(int userId) {//こたえた問題の数を数える
        String sql = "SELECT count(*) as count FROM answer_record WHERE user_id=?";
        try (
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, userId);
            // sql実行
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // IDからクイズを取得するメソッド
    public static Quiz selectQuizById(int quizId) {
        String sql = "SELECT * FROM quiz WHERE id=?";
        try (
                //データベースに接続　？に値を結びつけるためのPreparedStatement（インスタンス）
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, quizId);
            // sqlの実行結果を1行ごとにJavaの変数にセット
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int quiz_id = rs.getInt("id");
                    String question = rs.getString("question");
                    String title = rs.getString("title");
                    String choices_1 = rs.getString("choices_1");
                    String choices_2 = rs.getString("choices_2");
                    String choices_3 = rs.getString("choices_3");
                    String choices_4 = rs.getString("choices_4");
                    int correct = rs.getInt("correct");
                    String explanation = rs.getString("explanation");

                    //インスタンス化、クイズインスタンスを作る
                    Quiz quiz = new Quiz(quiz_id, question, title, choices_1, choices_2, choices_3, choices_4, correct, explanation);
                    return quiz;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    //クイズ記録を取得するメソッド
    public static int selectQuizRecord(int userId, int quizId) {
         // 実行するSQL文（クイズテ－ブルとanswer_recordテーブルを外部結合して回答記録が空だったら０に置き換える。）
        String sql = "SELECT COALESCE(ar.status, 0) AS status FROM quiz LEFT OUTER JOIN (select * from answer_record WHERE user_id=?) as ar "
                + "ON quiz.id=ar.quiz_id WHERE quiz.id=? ORDER BY quiz.id";
        try (
                //データベースに接続　？に値を結びつけるためのPreparedStatement（インスタンス）
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, quizId);
            // sql実行
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int status = rs.getInt("status");
                    return status;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // クイズの結果をインサートするメソッド
    public static int registerQuizRecord(int userId, int quizId, int status) {
        int result = 0;
        String sql = "INSERT INTO answer_record VALUES(?, ?, ?)";
        try (
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, quizId);
            pstmt.setInt(3, status);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }

    // クイズの結果を更新するメソッド
    public static int updateQuizRecord(int userId, int quizId, int status) {
        int result = 0;
        String sql = "UPDATE answer_record SET status=? WHERE user_id=? AND quiz_id=?";
        try (
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setInt(1, status);
            pstmt.setInt(2, userId);
            pstmt.setInt(3, quizId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return result;
    }       
}

