import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game {

    public static int sum;
    public static int rows = 4;
    public static int columns = 4;
    public static int score = 0;
    public static int moves = 20;
    public static int[][] numValues = new int[20][20];
    public static int count = 0;
    public static int tempX;
    public static int tempY;
    public static int tempSum;
    public static int target = 0;
    public static int tempRandIndex;


    public static JButton[][] numButton = new JButton[20][20];
    public static JPanel operationPanel = new JPanel(new GridLayout(4,1));
    public static Random random = new Random();


    public static void CreateGame() {

        String[] operation = {"+", "-", "*", "/"};

        JFrame frame = new JFrame("Project 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));
        panel.setSize(800,300);

        JPanel sumScore = new JPanel();
        sumScore.setLayout(new GridLayout(1, 1));
        sumScore.setSize(100,500);

        JLabel movesLabel = new JLabel("Moves: " + moves);
        movesLabel.setHorizontalAlignment(JLabel.CENTER);
        movesLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel targetMoves = new JPanel();
        targetMoves.setLayout(new GridLayout(1, 0));
        targetMoves.setSize(1000,100);

        JLabel sumLabel = new JLabel("Sum: " + sum);

        JLabel[] operationLabel = new JLabel[4];

        for (int i=0; i<4; i++) {
            operationLabel[i] = new JLabel();
            operationLabel[i].setText(operation[i] + "");
            operationLabel[i].setFont(new Font("Arial", Font.BOLD, 20));
            operationLabel[i].setForeground(Color.RED);
            operationLabel[i].setBackground(Color.WHITE);
        }

        JLabel targetLabel = new JLabel("Target: " + target);

        // Make all labels centered and bigger font
        sumLabel.setHorizontalAlignment(JLabel.CENTER);
        sumLabel.setFont(new Font("Arial", Font.BOLD, 20));
        targetLabel.setHorizontalAlignment(JLabel.CENTER);
        targetLabel.setFont(new Font("Arial", Font.BOLD, 20));

        CreateButtons(random, movesLabel, panel, sumScore, frame, sumLabel, targetLabel, targetMoves, operationLabel);

    }

    public static void CreateButtons(Random random, JLabel movesLabel, JPanel panel, JPanel sumScore, JFrame frame, JLabel sumLabel, JLabel targetLabel, JPanel targetMoves, JLabel[] operationLabel) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int rand = random.nextInt(1, 9);
                String[] operation = {"+", "-", "*", "/"};
                sum += rand;
                score = rand;
                numValues[i][j] = rand;
                numButton[i][j] = new JButton(Integer.toString(rand));
                numButton[i][j].setBackground(Color.BLUE);
                numButton[i][j].setForeground(Color.WHITE);
                numButton[i][j].setFont(new Font("Arial", Font.BOLD, 20));

                numButton[i][j].setAlignmentX(i);
                numButton[i][j].setAlignmentY(j);

                int buttonRow = i;
                int buttonCol = j;
                numButton[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        operationLabel[tempRandIndex].setForeground(Color.RED);
                        int randIndex = random.nextInt(0,3);
                        operationLabel[randIndex].setForeground(Color.GREEN);
                        tempRandIndex = randIndex;

                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < columns; j++) {
                                numButton[i][j].setEnabled(false);
                                numButton[i][j].setBackground(Color.RED);

                                numButton[buttonRow][j].setEnabled(true);
                                numButton[j][buttonCol].setEnabled(true);
                                numButton[buttonRow][j].setBackground(Color.GREEN);
                                numButton[j][buttonCol].setBackground(Color.GREEN);
                            }
                        }

                        movesLabel.setText("Moves: " + moves);

                        if (sum == target) {
                            JOptionPane.showMessageDialog(null, "Congratulations!\nYou win!");
                            System.exit(0);
                        }

                        if (moves == 0) {
                            if (target > sum) {
                                JOptionPane.showMessageDialog(null, "Congratulations!\nYou win!");
                                System.exit(0);
                            } else {
                                JOptionPane.showMessageDialog(null, "Game Over!\nYou were " + (sum - target) + " away from the target.");
                                System.exit(0);
                            }
                        }

                        if (count == 0) {
                            tempX = buttonRow;
                            tempY = buttonCol;
                            count++;
                        }
                        else if (numButton[buttonRow][buttonCol] == numButton[tempX][tempY]) {
                            JOptionPane.showMessageDialog(null, "You cannot play the same number twice!");
                            count = 0;
                        }
                        else if (count == 1) {

                            switch (operation[randIndex]) {
                                case "+":
                                    tempSum = numValues[tempX][tempY] + numValues[buttonRow][buttonCol];
                                    break;
                                case "-":
                                    tempSum = numValues[tempX][tempY] - numValues[buttonRow][buttonCol];
                                    break;
                                case "*":
                                    tempSum = numValues[tempX][tempY] * numValues[buttonRow][buttonCol];
                                    break;
                                case "/":
                                    tempSum = numValues[tempX][tempY] / numValues[buttonRow][buttonCol];
                                    break;
                            }

                            moves--;

                            sum = 0;

                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < columns; j++) {
                                    sum+=numValues[i][j];
                                }
                            }

                            sumLabel.setText("Score: " + sum);

                            numButton[tempX][tempY].setText(Integer.toString(tempSum%10));
                            numValues[tempX][tempY] = tempSum%10;

                            tempSum = 0;
                            tempX = buttonRow;
                            tempY = buttonCol;

                        }

                    }
                });

                panel.add(numButton[i][j]);

            }
        };

        JButton exitButton = new JButton("Main Menu");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt are you sure you want to exit
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    int response2 = JOptionPane.showConfirmDialog(null, "Do you want to save game?" , "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response2 == JOptionPane.YES_OPTION) {
                        SaveToFile.main(null);
                        frame.removeAll();
                        frame.dispose();
                        MainMenu.main(null);
                    }
                    else {
                        frame.removeAll();
                        frame.dispose();
                        MainMenu.main(null);
                    }
                }
            }
        });

        setFrameSettings(panel, frame, sumLabel, sumScore, movesLabel, exitButton, targetLabel, targetMoves, operationLabel);

    }

    public static void setFrameSettings(JPanel panel, JFrame frame, JLabel sumLabel, JPanel sumScore, JLabel movesLabel, JButton exitButton, JLabel targetLabel, JPanel targetMoves, JLabel[] operationLabel) {
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        sumScore.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 20));
        targetMoves.setBorder(BorderFactory.createEmptyBorder(50, 100, 0, 0));
        operationPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));

        frame.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);

        operationPanel.setBackground(Color.WHITE);

        sumScore.setBackground(Color.WHITE);

        targetMoves.setBackground(Color.WHITE);

        sumLabel.setText("Sum: " + sum);

        sumScore.add(sumLabel);
        for(int i = 0; i < 4; i++) {
            operationLabel[i].setFont(new Font("Arial", Font.BOLD, 30));
            operationPanel.add(operationLabel[i], BorderLayout.CENTER);
        }
        sumScore.add(exitButton);

        targetMoves.add(targetLabel);
        targetMoves.add(movesLabel, BorderLayout.WEST);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(sumScore, BorderLayout.SOUTH);
        frame.add(operationPanel, BorderLayout.EAST);
        frame.add(targetMoves, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    public static void LoadedGame() {
        String[] operation = {"+", "-", "*", "/"};

        JFrame frame = new JFrame("Project 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(rows, columns));
        panel.setSize(800,300);

        JPanel sumScore = new JPanel();
        sumScore.setLayout(new GridLayout(1, 1));
        sumScore.setSize(100,500);

        JLabel movesLabel = new JLabel("Moves: " + moves);
        movesLabel.setHorizontalAlignment(JLabel.CENTER);
        movesLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel targetMoves = new JPanel();
        targetMoves.setLayout(new GridLayout(1, 0));
        targetMoves.setSize(1000,100);

        JLabel sumLabel = new JLabel("Sum: " + sum);

        JLabel[] operationLabel = new JLabel[4];

        for (int i=0; i<4; i++) {
            operationLabel[i] = new JLabel();
            operationLabel[i].setText(operation[i] + "");
            operationLabel[i].setFont(new Font("Arial", Font.BOLD, 20));
            operationLabel[i].setForeground(Color.RED);
            operationLabel[i].setBackground(Color.WHITE);
        }

        JLabel targetLabel = new JLabel("Target: " + target);

        // Make all labels centered and bigger font
        sumLabel.setHorizontalAlignment(JLabel.CENTER);
        sumLabel.setFont(new Font("Arial", Font.BOLD, 20));
        targetLabel.setHorizontalAlignment(JLabel.CENTER);
        targetLabel.setFont(new Font("Arial", Font.BOLD, 20));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numButton[i][j] = new JButton(Integer.toString(numValues[i][j]));
                numButton[i][j].setBackground(Color.BLUE);
                numButton[i][j].setForeground(Color.WHITE);
                numButton[i][j].setFont(new Font("Arial", Font.BOLD, 20));

                numButton[i][j].setAlignmentX(i);
                numButton[i][j].setAlignmentY(j);

                int buttonRow = i;
                int buttonCol = j;

                numButton[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        operationLabel[tempRandIndex].setForeground(Color.RED);
                        int randIndex = random.nextInt(0,3);
                        operationLabel[randIndex].setForeground(Color.GREEN);
                        tempRandIndex = randIndex;

                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < columns; j++) {
                                numButton[i][j].setEnabled(false);
                                numButton[i][j].setBackground(Color.RED);

                                numButton[buttonRow][j].setEnabled(true);
                                numButton[j][buttonCol].setEnabled(true);
                                numButton[buttonRow][j].setBackground(Color.GREEN);
                                numButton[j][buttonCol].setBackground(Color.GREEN);
                            }
                        }

                        movesLabel.setText("Moves: " + moves);

                        if (sum == target) {
                            JOptionPane.showMessageDialog(null, "Congratulations!\nYou win!");
                            System.exit(0);
                        }

                        if (moves == 0) {
                            if (target > sum) {
                                JOptionPane.showMessageDialog(null, "Congratulations!\nYou win!");
                                System.exit(0);
                            } else {
                                JOptionPane.showMessageDialog(null, "Game Over!\nYou were " + (sum - target) + " away from the target.");
                                System.exit(0);
                            }
                        }

                        if (count == 0) {
                            tempX = buttonRow;
                            tempY = buttonCol;
                            count++;
                        }
                        else if (numButton[buttonRow][buttonCol] == numButton[tempX][tempY]) {
                            JOptionPane.showMessageDialog(null, "You cannot play the same number twice!");
                            count = 0;
                        }
                        else if (count == 1) {

                            switch (operation[randIndex]) {
                                case "+":
                                    tempSum = numValues[tempX][tempY] + numValues[buttonRow][buttonCol];
                                    break;
                                case "-":
                                    tempSum = numValues[tempX][tempY] - numValues[buttonRow][buttonCol];
                                    break;
                                case "*":
                                    tempSum = numValues[tempX][tempY] * numValues[buttonRow][buttonCol];
                                    break;
                                case "/":
                                    tempSum = numValues[tempX][tempY] / numValues[buttonRow][buttonCol];
                                    break;
                            }

                            moves--;

                            sum = 0;

                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < columns; j++) {
                                    sum+=numValues[i][j];
                                }
                            }

                            sumLabel.setText("Score: " + sum);

                            numButton[tempX][tempY].setText(Integer.toString(tempSum%10));
                            numValues[tempX][tempY] = tempSum%10;

                            tempSum = 0;
                            tempX = buttonRow;
                            tempY = buttonCol;

                        }

                    }
                });

                panel.add(numButton[i][j]);

            }
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numButton[i][j].setEnabled(false);
                numButton[i][j].setBackground(Color.RED);

                numButton[tempX][j].setEnabled(true);
                numButton[j][tempY].setEnabled(true);
                numButton[tempX][j].setBackground(Color.GREEN);
                numButton[j][tempY].setBackground(Color.GREEN);
            }
        }

        JButton exitButton = new JButton("Main Menu");
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt are you sure you want to exit
                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    int response2 = JOptionPane.showConfirmDialog(null, "Do you want to save game?" , "Confirm",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (response2 == JOptionPane.YES_OPTION) {
                        SaveToFile.main(null);
                        frame.removeAll();
                        frame.dispose();
                        MainMenu.main(null);
                    }
                    else {
                        frame.removeAll();
                        frame.dispose();
                        MainMenu.main(null);
                    }
                }
            }
        });

        setFrameSettings(panel, frame, sumLabel, sumScore, movesLabel, exitButton, targetLabel, targetMoves, operationLabel);

    }

    public static void main(String[] args) {

        CreateGame();
    }

}