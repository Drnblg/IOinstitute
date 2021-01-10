import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class QuizBehind extends Quiz implements ActionListener {
    public QuizBehind() throws SQLException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(670,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocation(800,300);

        textfield.setBounds(0,10,650,50);
        textfield.setBackground(null);
        textfield.setForeground(new Color(255,255, 255));
        textfield.setFont(new Font("Candara",Font.BOLD,30));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setBorder(null);
        textfield.setEditable(false);

        textarea.setBounds(100,80,650,60);
        textarea.setBackground(null);
        textarea.setForeground(new Color(255,255, 255));
        textarea.setFont(new Font("Candara",Font.BOLD,35));
        textarea.setBorder(null);
        textarea.setEditable(false);

        buttonA.setBounds(40,140,50,50);
        buttonA.setFont(new Font("Candara",Font.BOLD,40));
        buttonA.setFocusable(false);
        buttonA.setForeground(new Color(0, 0, 0));
        buttonA.setBackground(new Color(255, 255, 255));
        buttonA.setBorder(null);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(40,240,50,50);
        buttonB.setFont(new Font("Candara",Font.BOLD,40));
        buttonB.setFocusable(false);
        buttonB.setForeground(new Color(0, 0, 0));
        buttonB.setBackground(new Color(255, 255, 255));
        buttonB.setBorder(null);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(40,340,50,50);
        buttonC.setFont(new Font("Candara",Font.BOLD,40));
        buttonC.setFocusable(false);
        buttonC.setForeground(new Color(0, 0, 0));
        buttonC.setBackground(new Color(255, 255, 255));
        buttonC.setBorder(null);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(40,440,50,50);
        buttonD.setFont(new Font("Candara",Font.BOLD,40));
        buttonD.setFocusable(false);
        buttonD.setForeground(new Color(0, 0, 0));
        buttonD.setBackground(new Color(255, 255, 255));
        buttonD.setBorder(null);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(145,120,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(255,255, 255));
        answer_labelA.setFont(new Font("Candara",Font.PLAIN,35));

        answer_labelB.setBounds(145,220,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(255,255, 255));
        answer_labelB.setFont(new Font("Candara",Font.PLAIN,35));

        answer_labelC.setBounds(145,320,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(255,255, 255));
        answer_labelC.setFont(new Font("Candara",Font.PLAIN,35));

        answer_labelD.setBounds(145,420,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(255,255, 255));
        answer_labelD.setFont(new Font("Candara",Font.PLAIN,35));



        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(255,255,255));
        number_right.setFont(new Font("Candara",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Candara",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();

    }


    public void nextQuestion() throws SQLException {

        if(index>=total_questions) {
            results();
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(hariultuud[index][0]);
            answer_labelB.setText(hariultuud[index][1]);
            answer_labelC.setText(hariultuud[index][2]);
            answer_labelD.setText(hariultuud[index][3]);
        }
    }

    public void hugatsaa() {


        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer = ' ';
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                try {
                    nextQuestion();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA) {
            answer= 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB) {
            answer= 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC) {
            answer= 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD) {
            answer= 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }

        hugatsaa();


    }
}
