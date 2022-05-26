import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel mainPanel;
    private JMenuBar menuBar;
    private JMenu logo, dummy, info;

    MainWindow() {
        super("MitchTV Server");
        new createElements();
        loadingWindowSetup();
    }

    private void loadingWindowSetup() {
        this.add(mainPanel);
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    class createElements {
        createElements() {
            panelSetup();
            menuSetup();
            propertiesSetup();
        }

        private void panelSetup() {
            mainPanel = new JPanel(new BorderLayout());
        }

        private void menuSetup() {
            menuBar = new JMenuBar();
            menuBar.setBackground(new Color(25, 25, 25));
            mainPanel.setBackground(new Color(25, 25, 25));

            logo = new JMenu();
            dummy = new JMenu("   ");
            info = new JMenu("Server Running");

            logo.setIcon(new ImageIcon("src/images/mitch_sus_40.png"));
            dummy.setEnabled(false);
            info.setFont(new Font("Roobert", Font.PLAIN, 20));
            info.setForeground(Color.WHITE);

        }

        private void propertiesSetup() {
            menuBar.add(logo);
            menuBar.add(dummy);
            menuBar.add(info);
            mainPanel.add(menuBar, BorderLayout.NORTH);
        }

    }

}
