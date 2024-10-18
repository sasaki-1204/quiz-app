package dto;

import java.util.Date;
// Userクラスはユーザー情報を表すためのDTO
public class User {

    private int id;// ユーザーの一意の識別子
    private String name;// ユーザーの名前
    private String mail;// ユーザーのメールアドレス
    private String password;// ユーザーのパスワード

    // コンストラクタ: 全てのフィールドを受け取る
    public User(int id, String name, String mail, String password) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
    }
    
// getter及びsetterメソッド
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
