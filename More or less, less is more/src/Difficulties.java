import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class Difficulties {

    public static Random random = new Random();

    public static void CreateFrame() {
        JFrame difficulties = new JFrame("Difficulties");
        difficulties.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        difficulties.setSize(1280, 720);
        difficulties.setLocationRelativeTo(null);
        difficulties.setResizable(false);

        CreatePanel(difficulties);
    }

    public static void CreatePanel(JFrame difficulties) {

        JPanel labelPanel = new JPanel(new GridLayout(1, 0));
        JPanel backPanel = new JPanel(new GridLayout(1, 0));

        JPanel difficultiesPanel = new JPanel();
        difficultiesPanel.setLayout(new GridLayout(5, 0));
        difficultiesPanel.setSize(600, 600);

        labelPanel.setSize(400,50);
        backPanel.setSize(400,150);

        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        JButton customButton = new JButton("Custom");
        JButton backButton = new JButton("Back");

        CreateButtons(difficulties, difficultiesPanel, easyButton, mediumButton, hardButton, customButton, backButton, labelPanel, backPanel);

    }

    public static void CreateButtons(JFrame difficulties, JPanel difficultiesPanel, JButton easyButton, JButton mediumButton, JButton hardButton, JButton customButton, JButton backButton, JPanel labelPanel, JPanel backPanel) {

        easyButton.setBackground(Color.GREEN);
        easyButton.setForeground(Color.WHITE);
        easyButton.setFont(new Font("Arial", Font.BOLD, 20));
        easyButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        mediumButton.setBackground(Color.ORANGE);
        mediumButton.setForeground(Color.WHITE);
        mediumButton.setFont(new Font("Arial", Font.BOLD, 20));
        mediumButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        hardButton.setBackground(Color.RED);
        hardButton.setForeground(Color.WHITE);
        hardButton.setFont(new Font("Arial", Font.BOLD, 20));
        hardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        customButton.setBackground(Color.BLUE);
        customButton.setForeground(Color.WHITE);
        customButton.setFont(new Font("Arial", Font.BOLD, 20));
        customButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));

        labelPanel.setBackground(Color.WHITE);
        backPanel.setBackground(Color.WHITE);
        difficultiesPanel.setBackground(Color.WHITE);

        JLabel difficultyLabel = new JLabel("Select Difficulty");

        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 40));
        difficultyLabel.setForeground(Color.BLUE);
        difficultyLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel easyLabel = new JLabel("Easy: 4x4, 20 moves");
        JLabel mediumLabel = new JLabel("Medium: 5x5, 16 moves");
        JLabel hardLabel = new JLabel("Hard: 6x6, 12 moves");
        JLabel customLabel = new JLabel("Custom settings");

        easyLabel.setForeground(Color.BLUE);
        easyLabel.setHorizontalAlignment(JLabel.CENTER);
        mediumLabel.setForeground(Color.BLUE);
        mediumLabel.setHorizontalAlignment(JLabel.CENTER);
        hardLabel.setForeground(Color.BLUE);
        hardLabel.setHorizontalAlignment(JLabel.CENTER);
        customLabel.setForeground(Color.BLUE);
        customLabel.setHorizontalAlignment(JLabel.CENTER);

        easyLabel.setFont(new Font("ARIAL", Font.BOLD, 30));
        mediumLabel.setFont(new Font("ARIAL", Font.BOLD, 30));
        hardLabel.setFont(new Font("ARIAL", Font.BOLD, 30));
        customLabel.setFont(new Font("ARIAL", Font.BOLD, 30));

        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.rows=4;
                Game.columns=4;
                Game.moves=20;
                Game.target=random.nextInt(Game.sum-10, Game.sum+100);
                difficulties.removeAll();
                difficulties.dispose();
                Game.CreateGame();
            }
        });

        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.rows=5;
                Game.columns=5;
                Game.moves=16;
                Game.target=random.nextInt(Game.sum-50, Game.sum+50);
                difficulties.removeAll();
                difficulties.dispose();
                Game.CreateGame();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game.rows=6;
                Game.columns=6;
                Game.moves=12;
                Game.target=random.nextInt(Game.sum-100, Game.sum+10);
                difficulties.removeAll();
                difficulties.dispose();
                Game.CreateGame();
            }
        });

        customButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulties.removeAll();
                difficulties.dispose();
                Settings.main(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulties.removeAll();
                difficulties.dispose();
                MainMenu.main(null);
            }
        });

        SetSettings(difficulties, difficultiesPanel, easyButton, mediumButton, hardButton, customButton, backButton, easyLabel, mediumLabel, hardLabel, customLabel, difficultyLabel, labelPanel, backPanel);
    }

    public static void SetSettings(JFrame difficulties, JPanel difficultiesPanel, JButton easyButton, JButton mediumButton, JButton hardButton, JButton customButton, JButton backButton, JLabel easyLabel, JLabel mediumLabel, JLabel hardLabel, JLabel customLabel, JLabel difficultyLabel, JPanel labelPanel, JPanel backPanel) {

        difficultiesPanel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        backPanel.setBorder(BorderFactory.createEmptyBorder(0, 250, 20, 250));

        labelPanel.add(difficultyLabel, BorderLayout.CENTER);
        backPanel.add(backButton, BorderLayout.CENTER);

        difficultiesPanel.add(easyButton, BorderLayout.CENTER);
        difficultiesPanel.add(easyLabel, BorderLayout.CENTER);
        difficultiesPanel.add(mediumButton, BorderLayout.CENTER);
        difficultiesPanel.add(mediumLabel, BorderLayout.CENTER);
        difficultiesPanel.add(hardButton, BorderLayout.CENTER);
        difficultiesPanel.add(hardLabel, BorderLayout.CENTER);
        difficultiesPanel.add(customButton, BorderLayout.CENTER);
        difficultiesPanel.add(customLabel, BorderLayout.CENTER);

        difficulties.add(labelPanel, BorderLayout.NORTH);
        difficulties.add(difficultiesPanel, BorderLayout.CENTER);
        difficulties.add(backPanel, BorderLayout.SOUTH);
        difficulties.setVisible(true);
    }

    public static void main(String[] args) {
        CreateFrame();

    }

}
