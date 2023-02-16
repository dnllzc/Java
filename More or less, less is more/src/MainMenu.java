import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class MainMenu {

    public static void CreateFrame() {

        JFrame mainmenu = new JFrame("Main Menu");
        mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainmenu.setSize(1280, 720);
        mainmenu.setLocationRelativeTo(null);
        mainmenu.setLayout(new BorderLayout());
        mainmenu.setResizable(false);

        CreatePanel(mainmenu);
    }

    public static void CreatePanel(JFrame mainmenu) {
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1));
        menuPanel.setSize(400,200);

        JButton playButton = new JButton("Play");
        JButton howToButton = new JButton("How to Play?");
        JButton settingsButton = new JButton("Settings");
        JButton exitButton = new JButton("Exit");

        CreateButtons(mainmenu, menuPanel, playButton, howToButton, settingsButton, exitButton);
    }

    public static void CreateButtons(JFrame mainmenu, JPanel menuPanel, JButton playButton, JButton howToButton, JButton settingsButton, JButton exitButton) {
        playButton.setBackground(Color.BLUE);
        playButton.setForeground(Color.WHITE);
        playButton.setSize(400, 200);
        playButton.setFont(new Font("Arial", Font.BOLD, 20));

        howToButton.setBackground(Color.BLUE);
        howToButton.setForeground(Color.WHITE);
        howToButton.setSize(400, 200);
        howToButton.setFont(new Font("Arial", Font.BOLD, 20));

        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setSize(400, 200);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int loadGame = JOptionPane.showConfirmDialog(null, "Do you want to load last saved game?" , "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (loadGame == JOptionPane.YES_OPTION) {

                    File saveFile = new File("saves.txt");
                    if (saveFile.exists()) {

                        ReadFromFile.main(null);
                        mainmenu.removeAll();
                        mainmenu.dispose();
                        Game.LoadedGame();
                    }

                    else {
                        mainmenu.removeAll();
                        mainmenu.dispose();
                        Difficulties.main(null);
                    }

                }
                else {
                    mainmenu.removeAll();
                    mainmenu.dispose();
                    Difficulties.main(null);
                }

                }
        });

        howToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainmenu.removeAll();
                mainmenu.dispose();
                HowToPlay.main(null);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainmenu.removeAll();
                mainmenu.dispose();
                System.exit(0);
            }
        });

        JLabel label = new JLabel("<html><center>Welcome to the game 'More is less, less is more'!</html>");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBackground(Color.WHITE);
        label.setForeground(Color.BLUE);

        SetSettings(mainmenu, menuPanel, playButton, howToButton, settingsButton, exitButton, label);
    }

    public static void SetSettings(JFrame mainmenu, JPanel menuPanel, JButton playButton, JButton howToButton, JButton settingsButton, JButton exitButton, JLabel label) {
        menuPanel.add(label, BorderLayout.NORTH);
        menuPanel.add(playButton);
        menuPanel.add(howToButton);
        menuPanel.add(exitButton);

        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 250, 50, 250));
        mainmenu.setBackground(Color.WHITE);
        menuPanel.setBackground(Color.WHITE);
        mainmenu.add(menuPanel, BorderLayout.CENTER);
        mainmenu.setVisible(true);
    }

    public static void main(String[] args) {
        CreateFrame();
    }

}
