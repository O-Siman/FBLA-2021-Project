import java.util.ArrayList;
import java.util.Map;

public class Question {
    String id;
    String questionText;
    ArrayList<String> answerChoiceIds;

    public Question(String id, String questionText, ArrayList<String> answerChoiceIds) {
        this.id = id;
        this.questionText = questionText;
        this.answerChoiceIds = answerChoiceIds;
    }

    public static Question getQuestionById(String id) {
        return (Question) Database.idsAndQuestions.get(id);
    }

    public static ArrayList<Question> getAllQuestions() {
        ArrayList<Question> allQuestions = new ArrayList<>();
        for (Map.Entry<String, Question> entry : Database.idsAndQuestions.entrySet()) {
            allQuestions.add(entry.getValue());
        }

        return allQuestions;
    }

    public static String getId(Question question) {
        return question.id;
    }

    public static String getQuestionText(Question question) {
        return question.questionText;
    }

    public static ArrayList<String> getAnswerChoiceIds(Question question) {
        return question.answerChoiceIds;
    }
}
