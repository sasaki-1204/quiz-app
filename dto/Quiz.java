package dto;
// Quizクラスはクイズ情報を表すためのData transfer object
//関連するデータを一つにまとめデータの格納・読み出しのためのメソッドを定義したオブジェクト
public class Quiz {

    private int quizId;// クイズの一意の識別子
    private String question;// クイズの質問文
    private String title;// クイズのタイトル
    private String choices_1;// クイズの選択肢1
    private String choices_2;// クイズの選択肢2
    private String choices_3;// クイズの選択肢3
    private String choices_4;// クイズの選択肢4
    private int correct;// 正解の選択肢の番号
    private String explanation;// クイズの解説
    private int status;// クイズのステータス（例: アクティブ、非アクティブなど)

    // コンストラクタで値を入れる(全てのフィールドを受け取る)
    public Quiz(int quizId, String question, String title, String choices_1, String choices_2, String choices_3,
            String choices_4, int correct, String explanation, int status) {
        super();
        this.quizId = quizId;
        this.question = question;
        this.title = title;
        this.choices_1 = choices_1;
        this.choices_2 = choices_2;
        this.choices_3 = choices_3;
        this.choices_4 = choices_4;
        this.correct = correct;
        this.explanation = explanation;
        this.status = status;
    }

    // コンストラクタ(ステータスを除くフィールドを受け取る)クイズの情報だけを知りたい場合、ステータスがなくてもインスタンス化できるように
    public Quiz(int quizId, String question, String title, String choices_1, String choices_2, String choices_3,
            String choices_4, int correct, String explanation) {
        super();
        this.quizId = quizId;
        this.question = question;
        this.title = title;
        this.choices_1 = choices_1;
        this.choices_2 = choices_2;
        this.choices_3 = choices_3;
        this.choices_4 = choices_4;
        this.correct = correct;
        this.explanation = explanation;
    }

    // getter及びsetter　オブジェクト内部のメンバ変数を外部から読み取るために用意されたメソッド。オブジェクト内部のメンバ変数に外部から書き込むために用意されたメソッド。
    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoices_1() {
        return choices_1;
    }

    public void setChoices_1(String choices_1) {
        this.choices_1 = choices_1;
    }

    public String getChoices_2() {
        return choices_2;
    }

    public void setChoices_2(String choices_2) {
        this.choices_2 = choices_2;
    }

    public String getChoices_3() {
        return choices_3;
    }

    public void setChoices_3(String choices_3) {
        this.choices_3 = choices_3;
    }

    public String getChoices_4() {
        return choices_4;
    }

    public void setChoices_4(String choices_4) {
        this.choices_4 = choices_4;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
