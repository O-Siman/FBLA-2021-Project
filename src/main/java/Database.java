import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Database {

    static Map<String, Question> idsAndQuestions = new HashMap<>();
    static Map<String, AnswerChoice> idsAndAnswerChoices = new HashMap<>();

    public static void loadJson() {
        Gson gson = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();

        Type mapStringQuestion = new TypeToken<Map<String, Question>>() {}.getType();
        Type mapStringAnswerChoice = new TypeToken<Map<String, AnswerChoice>>() {}.getType();

        try {
            idsAndQuestions = gson.fromJson(new FileReader("idsAndQuestions.json"), mapStringQuestion);
            idsAndAnswerChoices = gson.fromJson(new FileReader("idsAndAnswerChoices.json"), mapStringAnswerChoice);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
