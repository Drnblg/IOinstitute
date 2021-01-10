import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class login implements ActionListener {

    Connection con;
    Statement stmt,stmtt;
    ResultSet rs,ra;

    JFrame frame;
    JLabel unameLbl, passLbl;
    JTextField unameField;
    JPasswordField passField;
    JButton loginBtn, registerBtn;

    public login(){

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocation(800,300);

        unameLbl = new JLabel("Username");
        unameField = new JTextField();
        passLbl = new JLabel("Password");
        passField = new JPasswordField();
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");


        unameLbl.setBounds(30, 20, 100, 30);
        unameLbl.setForeground(Color.white);
        unameField.setBounds(140, 20, 200, 30);
        passLbl.setBounds(30, 70, 100, 30);
        passLbl.setForeground(Color.white);
        passField.setBounds(140, 70, 200, 30);
        loginBtn.setBounds(100, 160, 200, 30);
        loginBtn.setBackground(Color.white);
        loginBtn.setBorder(null);
        registerBtn.setBounds(100, 200, 200 ,30);
        registerBtn.setBackground(Color.white);
        registerBtn.setBorder(null);
        loginBtn.addActionListener(this);
        registerBtn.addActionListener(this);

        frame.add(unameLbl);
        frame.add(unameField);
        frame.add(passLbl);
        frame.add(passField);
        frame.add(loginBtn);
        frame.add(registerBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){
            try{

                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb", "root", "");

                stmt = con.createStatement();
                stmtt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM users");
                ra = stmtt.executeQuery("SELECT * FROM admin");


                while (ra.next()){
                    if (unameField.getText().equals(ra.getString("username")) && passField.getText().equals(ra.getString("password"))) {

                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Admin Erheer Newterlee");
                        new QuizBehind();
                        break;
                    }
                }
                while(rs.next()){
                    if (unameField.getText().equals(rs.getString("username")) && passField.getText().equals(rs.getString("password"))) {

                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Amjilttai Newterlee");
                        new QuizBehind();
                        break;


                    }else if ((unameField.getText().equals(rs.getString("username")) || passField.getText().equals(rs.getString("password")))) {
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Nevtreh bolomjgui baina");
                        break;

                    }

                }



            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }else if(e.getSource() == registerBtn){
            new register();
        }
    }



}