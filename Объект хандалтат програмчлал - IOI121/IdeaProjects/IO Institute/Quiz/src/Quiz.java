import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class Quiz  {

        String[] questions = 	{
                "Svvld garsan Intel iin CPU?",
                "Neg jild hden honog baidag ve?",
                "Hamgiin svvlchiin windows?",
                "Odoo baigaa mongoliin yrunhiilugch?"
        };
        String[][] hariultuud = 	{
                {"i3","i5","i7","i9"},
                {"335","365","345","375"},
                {"XP","Windows7","Windows10","Windows8"},
                {"Bayrmagnai","Battulga","Elbegdorj","Erdene"}
        };
        char[] answers = 		{
                'D',
                'B',
                'C',
                'B'
        };
        char answer;
        int index;
        int correct_guesses =0;
        int total_questions = questions.length;
        int result;

        JFrame frame = new JFrame();
        JTextField textfield = new JTextField();
        JTextArea textarea = new JTextArea();
        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();
        JLabel answer_labelA = new JLabel();
        JLabel answer_labelB = new JLabel();
        JLabel answer_labelC = new JLabel();
        JLabel answer_labelD = new JLabel();
        JTextField number_right = new JTextField();
        JTextField percentage = new JTextField();




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


        public void results() throws SQLException {

                buttonA.setVisible(false);
                buttonB.setVisible(false);
                buttonC.setVisible(false);
                buttonD.setVisible(false);

                result = (int)((correct_guesses/(double)total_questions)*100);

                textfield.setText("hariult");
                textarea.setText("");
                answer_labelA.setText("");
                answer_labelB.setText("");
                answer_labelC.setText("");
                answer_labelD.setText("");

                number_right.setText(correct_guesses+"/"+total_questions);
                percentage.setText(result+"%");
                String x = result + "%";

                frame.add(number_right);
                frame.add(percentage);



                String query = "INSERT INTO score ("
                        + " get,"
                        + " total,"
                        + " percent ) VALUES ("
                        + "?, ?, ?)";
                if (result >= 0 ){
                        try {

                                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb","root","");

                                PreparedStatement st = con.prepareStatement(query);
                                st.setInt(1, correct_guesses);
                                st.setInt(2, total_questions);
                                st.setString(3, x);

                                st.executeUpdate();
                                st.close();
                        } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                        }
                }
        }



        public static void main(String[] args) throws SQLException {

                QuizBehind quiz = new QuizBehind();
        }

}
