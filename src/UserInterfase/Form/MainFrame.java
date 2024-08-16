package UserInterfase.Form;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
    public MainFrame() {
        setTitle("CMEcuaFauna2K24");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1)); // 6 vertical rectangles

        // Add panels
        add(new TitlePanel());
        add(new IDPanel());
        add(new HormigueroPanel());
        add(new GridPanel());
        add(new FoodMenuPanel());
        add(new ControlPanel());

        setVisible(true);
    }
}
