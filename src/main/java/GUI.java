import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    static JFrame frame;

    public GUI() {
        //Make a frame
        frame = new JFrame();

        //Make a label
        JLabel titleLabel = new JLabel("Questions");
        titleLabel.setFont(new Font("Courier", Font.BOLD, 20));


        //Make a panel and set it up
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10,30));
        panel.setLayout(new GridLayout(10, 1));

        panel.add(titleLabel);
        panel.add(new JSeparator());

        //Add questions
        ArrayList<Question> allQuestions = Question.getAllQuestions();
        for (Question question : allQuestions) {
            JLabel questionLabel = new JLabel(question.questionText);
            panel.add(questionLabel);

            //Make button group so only one can be selected at a time
            ButtonGroup buttonGroup = new ButtonGroup();

            //Add answer choices
            for (String id : question.answerChoiceIds) {
                AnswerChoice answerChoice = AnswerChoice.getAnswerChoiceById(id);

                //Button to select answer
                JRadioButton answerChoiceButton = new JRadioButton(answerChoice.answerChoiceText);

                //Add it to this button group so that only one can be selected at a time
                buttonGroup.add(answerChoiceButton);

                //Add the answer choice to the panel
                panel.add(answerChoiceButton);
            }
        }

        //Set up the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FBLA Quiz");
        frame.setLocationRelativeTo(null);


        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

    }
}
