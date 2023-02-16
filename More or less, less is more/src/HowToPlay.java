import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class HowToPlay {


    public static void CreatePanel(JFrame mainFrame) {
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(500,700);
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setBackground(Color.WHITE);

        JLabel label1 = new JLabel("<html><center>How to play:</html>");
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(new Font("Arial", Font.BOLD, 40));
        label1.setBackground(Color.WHITE);
        label1.setForeground(Color.BLUE);

        JLabel label2 = new JLabel("<html>The first move is determined by the player by selecting any button (button A) on the</br>" +
                "game field.</html>");
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setBackground(Color.WHITE);
        label2.setForeground(Color.BLUE);

        JLabel label3 = new JLabel("<html>1. The player is allowed to choose a second button (button B) located in the column<br/>" +
                "or row of the previously selected button (A).<br/>" +
                "2. Upon selecting the second button (B), the value of button (A) is updated according<br/>" +
                "to the following formula: A = (AoperationB)mod10.<br/>" +
                "3. The operation for the basic game will be +.<br/>" +
                "4. Decrement the number of moves and repeat from step 1, using the previously selected<br/>" +
                "button (B) as the current button (A). Continue until the move counter is greater<br/>" +
                "than 0.</html>");
        label3.setHorizontalAlignment(JLabel.CENTER);
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setBackground(Color.WHITE);
        label3.setForeground(Color.BLUE);

        JButton backButton = new JButton("Main Menu");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.addActionListener(e -> {
            mainFrame.removeAll();
            mainFrame.dispose();
            MainMenu.main(null);
        });


        SetFrameSettings(mainPanel, mainFrame, label1, label2, label3, backButton);
    }

    public static void CreateFrame() {
        JFrame mainFrame = new JFrame("How to Play");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

        CreatePanel(mainFrame);
    }

    public static void SetFrameSettings(JPanel mainPanel, JFrame mainFrame, JLabel label1, JLabel label2, JLabel label3, JButton backButton) {
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 20, 50));

        mainFrame.setBackground(Color.WHITE);
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(label1, BorderLayout.NORTH);
        mainPanel.add(label2, BorderLayout.CENTER);
        mainPanel.add(label3, BorderLayout.CENTER);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(backButton, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CreateFrame();
    }

}
