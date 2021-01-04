import java.util.Map;

public class AnswerChoice {
    String id;
    String questionId;
    String answerChoiceText;
    boolean isCorrect;

    public AnswerChoice(String id, String questionId, String answerChoiceText, boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.answerChoiceText = answerChoiceText;
        this.isCorrect = isCorrect;
    }

    public static AnswerChoice getAnswerChoiceById(String id) {
        return Database.idsAndAnswerChoices.get(id);
    }

    public static String getId(AnswerChoice answerChoice) {
        return answerChoice.id;
    }

    public static String getQuestionId(AnswerChoice answerChoice) {
        return answerChoice.questionId;
    }

    public static String getAnswerChoiceText(AnswerChoice answerChoice) {
        return answerChoice.answerChoiceText;
    }

    public static boolean isCorrect(AnswerChoice answerChoice) {
        return answerChoice.isCorrect;
    }
}
