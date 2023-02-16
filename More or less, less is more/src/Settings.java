import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Settings {

    public static JTextField target = new JTextField("100");
    public static JTextField moves = new JTextField("20");
    public static JComboBox fieldSize = new JComboBox();

    public static Random random = new Random();

    public static void CreateFrame() {

        JFrame settings = new JFrame("Settings");
        settings.setSize(1280, 720);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setLocationRelativeTo(null);
        settings.setResizable(false);

        SettingsPanel(settings, random);
    }

    public static void SettingsPanel(JFrame settings, Random random) {
        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(0, 1));
        settingsPanel.setSize(400,720);
        settingsPanel.setBackground(Color.WHITE);
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));
        fieldSize.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        JLabel difficultyLabel = new JLabel("<html><center>Difficulty settings</html>");
        difficultyLabel.setHorizontalAlignment(JLabel.CENTER);
        difficultyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        difficultyLabel.setBackground(Color.WHITE);
        difficultyLabel.setForeground(Color.BLUE);

        JLabel targetLabel = new JLabel("<html><center>Target number</html>");
        targetLabel.setHorizontalAlignment(JLabel.CENTER);
        targetLabel.setFont(new Font("Arial", Font.BOLD, 20));
        targetLabel.setBackground(Color.WHITE);
        targetLabel.setForeground(Color.BLUE);

        JLabel movesLabel = new JLabel("<html><center>Number of moves</html>");
        movesLabel.setHorizontalAlignment(JLabel.CENTER);
        movesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        movesLabel.setBackground(Color.WHITE);
        movesLabel.setForeground(Color.BLUE);

        JLabel fieldSizeLabel = new JLabel("<html><center>Field size</html>");
        fieldSizeLabel.setHorizontalAlignment(JLabel.CENTER);
        fieldSizeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fieldSizeLabel.setBackground(Color.WHITE);
        fieldSizeLabel.setForeground(Color.BLUE);

        target.setHorizontalAlignment(JTextField.CENTER);
        target.setFont(new Font("Arial", Font.BOLD, 20));
        target.setBackground(Color.WHITE);
        target.setForeground(Color.BLUE);
        target.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        moves.setHorizontalAlignment(JTextField.CENTER);
        moves.setFont(new Font("Arial", Font.BOLD, 20));
        moves.setBackground(Color.WHITE);
        moves.setForeground(Color.BLUE);
        moves.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        fieldSize.addItem("2x2");
        fieldSize.addItem("3x3");
        fieldSize.addItem("4x4");
        fieldSize.addItem("5x5");
        fieldSize.addItem("6x6");
        fieldSize.addItem("7x7");
        fieldSize.addItem("8x8");
        fieldSize.addItem("9x9");
        fieldSize.addItem("10x10");
        fieldSize.setSelectedIndex(0);
        fieldSize.setFont(new Font("Arial", Font.BOLD, 20));
        fieldSize.setBackground(Color.WHITE);
        fieldSize.setForeground(Color.BLUE);

        int tempTarget = Integer.parseInt(target.getText());

        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.BOLD, 20));
        playButton.setBackground(Color.WHITE);
        playButton.setForeground(Color.BLUE);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (target.getText().equals("") || moves.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please input all the fields");
                }
                else {
                    Game.target = Integer.parseInt(target.getText());
                    Game.moves = Integer.parseInt(moves.getText());

                    if (fieldSize.getSelectedItem().equals("2x2")) {
                        Game.rows = 2;
                        Game.columns = 2;
                    } else if (fieldSize.getSelectedItem().equals("3x3")) {
                        Game.rows = 3;
                        Game.columns = 3;
                    } else if (fieldSize.getSelectedItem().equals("4x4")) {
                        Game.rows = 4;
                        Game.columns = 4;
                    } else if (fieldSize.getSelectedItem().equals("5x5")) {
                        Game.rows = 5;
                        Game.columns = 5;
                    } else if (fieldSize.getSelectedItem().equals("6x6")) {
                        Game.rows = 6;
                        Game.columns = 6;
                    } else if (fieldSize.getSelectedItem().equals("7x7")) {
                        Game.rows = 7;
                        Game.columns = 7;
                    } else if (fieldSize.getSelectedItem().equals("8x8")) {
                        Game.rows = 8;
                        Game.columns = 8;
                    } else if (fieldSize.getSelectedItem().equals("9x9")) {
                        Game.rows = 9;
                        Game.columns = 9;
                    } else if (fieldSize.getSelectedItem().equals("10x10")) {
                        Game.rows = 10;
                        Game.columns = 10;
                    }

                    settings.removeAll();
                    settings.dispose();
                    Game.CreateGame();
                }
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLUE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (target.getText().equals("") || moves.getText().equals("")) {
                    Game.target = random.nextInt(Game.sum, Game.sum * 2);
                    Game.moves = 20;
                } else {
                Game.target = Integer.parseInt(target.getText());
                Game.moves = Integer.parseInt(moves.getText());
                }

                if (fieldSize.getSelectedItem().equals("2x2")) {
                    Game.rows = 2;
                    Game.columns = 2;
                } else if (fieldSize.getSelectedItem().equals("3x3")) {
                    Game.rows = 3;
                    Game.columns = 3;
                } else if (fieldSize.getSelectedItem().equals("4x4")) {
                    Game.rows = 4;
                    Game.columns = 4;
                } else if (fieldSize.getSelectedItem().equals("5x5")) {
                    Game.rows = 5;
                    Game.columns = 5;
                } else if (fieldSize.getSelectedItem().equals("6x6")) {
                    Game.rows = 6;
                    Game.columns = 6;
                } else if (fieldSize.getSelectedItem().equals("7x7")) {
                    Game.rows = 7;
                    Game.columns = 7;
                } else if (fieldSize.getSelectedItem().equals("8x8")) {
                    Game.rows = 8;
                    Game.columns = 8;
                } else if (fieldSize.getSelectedItem().equals("9x9")) {
                    Game.rows = 9;
                    Game.columns = 9;
                } else if (fieldSize.getSelectedItem().equals("10x10")) {
                    Game.rows = 10;
                    Game.columns = 10;
                }

                settings.removeAll();
                settings.dispose();
                MainMenu.main(null);
            }
        });

        SetFrameSettings(settings, settingsPanel, difficultyLabel, playButton, targetLabel, movesLabel, fieldSizeLabel);
    }

    public static void SetFrameSettings(JFrame settings, JPanel settingsPanel, JLabel difficultyLabel, JButton backButton, JLabel targetLabel, JLabel movesLabel, JLabel fieldSizeLabel) {


        settingsPanel.add(difficultyLabel, BorderLayout.NORTH);
        settingsPanel.add(fieldSizeLabel, BorderLayout.CENTER);
        settingsPanel.add(fieldSize, BorderLayout.CENTER);
        settingsPanel.add(targetLabel, BorderLayout.CENTER);
        settingsPanel.add(target, BorderLayout.CENTER);
        settingsPanel.add(movesLabel, BorderLayout.CENTER);
        settingsPanel.add(moves, BorderLayout.CENTER);
        settingsPanel.add(backButton, BorderLayout.SOUTH);

        settings.add(settingsPanel, BorderLayout.CENTER);

        settings.setVisible(true);

    }

    public static void main(String[] args) {
        CreateFrame();

    }

}
