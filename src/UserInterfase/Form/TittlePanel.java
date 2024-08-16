package UserInterfase.Form;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TittlePanel extends JFrame{
    private static final String FlowLayout = null;

    public void TitlePanel() {
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("CMEcuaFauna2K24", JLabel.LEFT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.WEST);

        // Window control buttons (minimize, maximize, close)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
        JButton closeButton = new JButton("X");
        closeButton.addActionListener(e -> System.exit(0));
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.EAST);
    }
}
