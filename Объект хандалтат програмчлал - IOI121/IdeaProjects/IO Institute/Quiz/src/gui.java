import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class gui implements ActionListener{


        JMenu menu;
        JMenuItem i1, i2;
        gui(){
        JFrame f= new JFrame("Menu and MenuItem Example");
        JMenuBar mb=new JMenuBar();

        f.setJMenuBar(mb);
        f.setLayout(null);
        f.setVisible(true);

            menu=new JMenu("Menu");
            i1 = new JMenuItem("XO Game");
            i2 = new JMenuItem("Item 2");
            menu.add(i1); menu.add(i2);
            mb.add(menu);
    }
        public static void main(String args[])
        {
            new gui();
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == i1) {
        }
    }
}


