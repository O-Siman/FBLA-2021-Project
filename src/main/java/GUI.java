import javafx.scene.control.ScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI implements ActionListener {
    static JFrame frame;
    static JButton submitButton = new JButton();

    public GUI() {
        //Make a frame
        frame = new JFrame();
        //Make a panel and set it up
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setLayout(new GridLayout(0, 3));

        //Make a label
        JLabel titleLabel = new JLabel("FBLA 2020-2021 Questions");

        titleLabel.setFont(new Font("Courier", Font.BOLD, 20));



        //Title
        panel.add(titleLabel);
        //2 separators for 3 columns
        panel.add(new JSeparator());
        panel.add(new JSeparator());

//        //Panel for each Q&A
//        ArrayList<JPanel> questionPanels = new ArrayList<>();
        //Add questions
        ArrayList<Question> allQuestions = Question.getAllQuestions();
        for (Question question : allQuestions) {
            //Specific question panel
            JPanel currentPanel = new JPanel();

            JLabel questionLabel = new JLabel(question.questionText);
            currentPanel.add(questionLabel);

            //Make button group so only one can be selected at a time
            ButtonGroup buttonGroup = new ButtonGroup();

            int amountOfAnswers = 0;
            //Add answer choices
            for (String id : question.answerChoiceIds) {
                AnswerChoice answerChoice = AnswerChoice.getAnswerChoiceById(id);

                //Button to select answer
                JRadioButton answerChoiceButton = new JRadioButton(answerChoice.answerChoiceText);

                //Add it to this button group so that only one can be selected at a time
                buttonGroup.add(answerChoiceButton);

                //Add the answer choice to the panel
                currentPanel.add(answerChoiceButton);
                amountOfAnswers++;
            }
            //Question title + number of answers
            currentPanel.setLayout(new GridLayout(1 + amountOfAnswers, 1));

            panel.add(currentPanel);
        }

        //Separator between questions and submit
        panel.add(new JSeparator());
        //Add submit button
        submitButton.setText("Submit");
        panel.add(submitButton);

        //Stack overflow?
        panel.add(Box.createVerticalGlue());

        //Set up the frame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMaximumSize(screenSize);
        frame.add(scrollPane, BorderLayout.CENTER);
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
