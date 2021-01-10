import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui implements ActionListener {

    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile;
    JMenuItem Puzzle, TicTacToe;



    public static void main(String[] args) {

        new gui();

    }
    public gui() {

        createWindow();
        createTextArea();
        createMenubar();
        createFileMenu();

        window.setVisible(true);
    }

    public void createWindow() {

        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(700,250);
    }

    public void createTextArea() {

        textArea = new JTextArea();

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);

    }

    public void createMenubar() {

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);
    }

    public void createFileMenu() {

        Puzzle = new JMenuItem("Puzzle");
        Puzzle.addActionListener(this);
        Puzzle.setActionCommand("Puzzle");
        menuFile.add(Puzzle);

        TicTacToe = new JMenuItem("XO");
        TicTacToe.addActionListener(this);
        TicTacToe.setActionCommand("XO");
        menuFile.add(TicTacToe);
    }





    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == Puzzle){
        new Puzzle();
    }
    else if (e.getSource() == TicTacToe){
        new TicTacToe();
    }
    }
}