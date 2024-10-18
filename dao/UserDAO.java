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

import dto.User;

// UserDAOクラスはユーザーに関するデータベースアクセスを担当します。
public class UserDAO {

    // DB接続を行うメソッド
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

    // ユーザー情報をメールアドレスから取得するメソッド
    public static User getUser(String email) {
        String sql = "SELECT * FROM users WHERE mail=?";
        try (
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
            pstmt.setString(1, email);
            // sql実行
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {//結果をJava変数に代入
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String mail = rs.getString("mail");
                    String password = rs.getString("password");

                    //インスタンス化
                    User user = new User(id, name, mail, password);
                    return user;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 新規ユーザーを登録するメソッド
    public static int registerUser(String name, String mail, String password) {
        int result = 0; // 更新件数0のままだったら登録失敗（もう登録済みの場合）
        String sql = "INSERT INTO users VALUES(null, ?, ?, ?)";

        try (
                Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) { 
            // 値をバインドする
            pstmt.setString(1, name);
            pstmt.setString(2, mail);
            pstmt.setString(3, password);

            // sql実行
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();

        }
        return result; // 更新件数を返す
    }
}
