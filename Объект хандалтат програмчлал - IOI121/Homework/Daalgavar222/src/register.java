import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class register implements ActionListener {

    Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement pst;

    JFrame frame;
    JLabel unameLbl, passLbl, fNameLbl, lNameLbl;
    JTextField unameField, fNameField, lNameField;
    JPasswordField passField;
    JButton loginBtn, registerBtn;

    public register() {

        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setResizable(false);

        fNameLbl = new JLabel("FirstName");
        fNameField = new JTextField();
        lNameLbl = new JLabel("LastName");
        lNameField = new JTextField();
        unameLbl = new JLabel("Username");
        unameField = new JTextField();
        passLbl = new JLabel("Password");
        passField = new JPasswordField();
        loginBtn = new JButton("Login");
        registerBtn = new JButton("Register");

        fNameLbl.setBounds(30, 20, 100, 30);
        fNameField.setBounds(140, 20, 200, 30);
        lNameLbl.setBounds(30, 70, 100, 30);
        lNameField.setBounds(140, 70, 200, 30);
        unameLbl.setBounds(30, 120, 100, 30);
        unameField.setBounds(140, 120, 200, 30);
        passLbl.setBounds(30, 170, 100, 30);
        passField.setBounds(140, 170, 200, 30);
        registerBtn.setBounds(100, 220, 200, 30);
        registerBtn.setBounds(100, 260, 200, 30);
        registerBtn.addActionListener(this);
        loginBtn.setBounds(100,300,200,30);

        frame.add(fNameLbl);
        frame.add(fNameField);
        frame.add(lNameLbl);
        frame.add(lNameField);
        frame.add(unameLbl);
        frame.add(unameField);
        frame.add(passLbl);
        frame.add(passField);
        frame.add(registerBtn);
        frame.add(loginBtn);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new register();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerBtn) {
            String query = "INSERT INTO Users ("
                    + " id,"
                    + " firstname,"
                    + " lastname,"
                    + " username,"
                    + " password ) VALUES ("
                    + "null, ?, ?, ?, ?)";
            try {

                Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/javadb","root","");

                // set all the preparedstatement parameters
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, fNameField.getText());
                st.setString(2, lNameField.getText());
                st.setString(3, unameField.getText());
                st.setString(4, passField.getText());

                // execute the preparedstatement insert
                st.executeUpdate();
                st.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        if(e.getSource() == loginBtn){
            new main();
        }



    }
}