import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main implements ActionListener {

    Connection con;
    Statement stmt;
    ResultSet rs;

    JFrame frame;
    JLabel unameLbl, passLbl;
    JTextField unameField;
    JPasswordField passField;
    JButton loginBtn, registerBtn;

    public main(){

        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setResizable(false);

        unameLbl = new JLabel("Username");
        unameField = new JTextField();
        passLbl = new JLabel("Password");
        passField = new JPasswordField();
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");


        unameLbl.setBounds(30, 20, 100, 30);
        unameField.setBounds(140, 20, 200, 30);
        passLbl.setBounds(30, 70, 100, 30);
        passField.setBounds(140, 70, 200, 30);
        loginBtn.setBounds(100, 120, 200, 30);
        loginBtn.setBounds(100, 160, 200, 30);
        registerBtn.setBounds(100, 200, 200 ,30);
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
        new main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginBtn){
            try{

                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javadb", "root", "");

                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM users");

                while(rs.next()) {
                    if (unameField.getText().equals(rs.getString("username")) && passField.getText().equals(rs.getString("password"))) {

                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Amjilttai Newterlee");
                        new gui();
                        break;

                    } else if ((unameField.getText().equals(rs.getString("username")) || passField.getText().equals(rs.getString("password")))) {
                        frame.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Nevtreh bolomjgui baina");
                        break;
                    }
                }
                con.close();

            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }else if(e.getSource() == registerBtn){
            new register();
        }
    }



}