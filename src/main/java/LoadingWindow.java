import javax.swing.*;
import java.awt.*;

public class LoadingWindow extends JFrame {
    private JPanel mainPanel, secondaryPanel, dummyPanel;

    LoadingWindow() {
        super("MitchTV Server");
        new createElements();
        loadingWindowSetup();
    }

    private void loadingWindowSetup() {
        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.NORTH);
        this.add(secondaryPanel, BorderLayout.SOUTH);
        this.add(dummyPanel, BorderLayout.CENTER);
        this.setSize(1280, 720);
        this.setVisible(true);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public void loadingWindowTermination() {
        this.setVisible(false);
        dispose();
    }

    class createElements {

        createElements() {
            panelSetup();
            propertiesSetup();
        }

        private void panelSetup() {
            mainPanel = new JPanel();
            secondaryPanel = new JPanel();
            dummyPanel = new JPanel();
        }

        private void propertiesSetup() {
            mainPanel.add(new JLabel(new ImageIcon("src/images/mitch_logo_480.png")), JLabel.CENTER);
            secondaryPanel.add(new JLabel(new ImageIcon("src/images/loading.gif")), JLabel.CENTER);
            dummyPanel.add(new JLabel("Please wait, making sure all videos are available..."), JLabel.CENTER);
            mainPanel.setBackground(new Color(211, 86, 194));
            secondaryPanel.setBackground(new Color(211, 86, 194));
            dummyPanel.setBackground(new Color(211, 86, 194));
        }

    }

}
