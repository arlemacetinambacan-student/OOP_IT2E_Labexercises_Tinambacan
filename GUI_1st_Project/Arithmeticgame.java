import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Arithmeticgame extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, answerField;
    private JLabel operatorLabel, correctLabel, incorrectLabel;
    private JRadioButton addBtn, subBtn, mulBtn, divBtn;
    private JButton submitBtn;
    private ButtonGroup group;
    private int correct = 0, incorrect = 0;
    private char operation = ' ';
    private Random rand = new Random(); // 👈 Added for random numbers

    public Arithmeticgame() {
        setTitle("Arithmetic Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Number fields
        num1Field = new JTextField();
        num1Field.setBounds(100, 80, 80, 60);
        num1Field.setFont(new Font("Arial", Font.BOLD, 24));
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        add(num1Field);

        operatorLabel = new JLabel("");
        operatorLabel.setBounds(190, 80, 60, 60);
        operatorLabel.setFont(new Font("Arial", Font.BOLD, 32));
        operatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(operatorLabel);

        num2Field = new JTextField();
        num2Field.setBounds(250, 80, 80, 60);
        num2Field.setFont(new Font("Arial", Font.BOLD, 24));
        num2Field.setHorizontalAlignment(JTextField.CENTER);
        add(num2Field);

        JLabel equalLabel = new JLabel("=");
        equalLabel.setBounds(340, 80, 40, 60);
        equalLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(equalLabel);

        answerField = new JTextField();
        answerField.setBounds(380, 80, 80, 60);
        answerField.setFont(new Font("Arial", Font.BOLD, 24));
        answerField.setHorizontalAlignment(JTextField.CENTER);
        add(answerField);

        // Submit Button
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(480, 95, 90, 35);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 14));
        submitBtn.addActionListener(this);
        add(submitBtn);

        // Operation buttons
        JLabel opLabel = new JLabel("Operation");
        opLabel.setFont(new Font("Arial", Font.BOLD, 14));
        opLabel.setBounds(70, 180, 100, 20);
        add(opLabel);

        addBtn = new JRadioButton("Addition");
        subBtn = new JRadioButton("Subtraction");
        mulBtn = new JRadioButton("Multiplication");
        divBtn = new JRadioButton("Division");

        JRadioButton[] ops = {addBtn, subBtn, mulBtn, divBtn};
        String[] labels = {"+", "-", "×", "÷"};
        int y = 200;

        group = new ButtonGroup();
        for (int i = 0; i < ops.length; i++) {
            ops[i].setBounds(70, y, 120, 25);
            ops[i].setFont(new Font("Arial", Font.PLAIN, 14));
            ops[i].setBackground(Color.WHITE);
            final int idx = i;
            ops[i].addActionListener(e -> {
                operation = labels[idx].charAt(0);
                operatorLabel.setText(String.valueOf(operation));
                generateRandomNumbers(); // 👈 random numbers when selecting operation
            });
            add(ops[i]);
            group.add(ops[i]);
            y += 25;
        }

        // Score Labels
        JLabel scoreText = new JLabel("Score:");
        scoreText.setBounds(350, 180, 100, 25);
        scoreText.setFont(new Font("Arial", Font.BOLD, 16));
        add(scoreText);

        JLabel correctText = new JLabel("Correct");
        correctText.setBounds(350, 205, 80, 25);
        correctText.setFont(new Font("Arial", Font.BOLD, 14));
        add(correctText);

        correctLabel = new JLabel("0", SwingConstants.CENTER);
        correctLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        correctLabel.setBounds(420, 205, 40, 25);
        add(correctLabel);

        JLabel incorrectText = new JLabel("Incorrect");
        incorrectText.setBounds(350, 235, 80, 25);
        incorrectText.setFont(new Font("Arial", Font.BOLD, 14));
        add(incorrectText);

        incorrectLabel = new JLabel("0", SwingConstants.CENTER);
        incorrectLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        incorrectLabel.setBounds(420, 235, 40, 25);
        add(incorrectLabel);

        setVisible(true);
    }

    // ✅ NEW METHOD: Generates random numbers automatically
    private void generateRandomNumbers() {
        int num1 = rand.nextInt(10) + 1; // 1–10
        int num2 = rand.nextInt(10) + 1; // 1–10

        // Avoid divide by zero
        if (operation == '÷' && num2 == 0)
            num2 = 1;

        num1Field.setText(String.valueOf(num1));
        num2Field.setText(String.valueOf(num2));
        answerField.setText(""); // clear previous answer
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double ans = Double.parseDouble(answerField.getText());
            double correctAnswer = 0;

            switch (operation) {
                case '+': correctAnswer = num1 + num2; break;
                case '-': correctAnswer = num1 - num2; break;
                case '×': correctAnswer = num1 * num2; break;
                case '÷': correctAnswer = num2 != 0 ? num1 / num2 : Double.NaN; break;
                default:
                    JOptionPane.showMessageDialog(this, "Select an operation first!");
                    return;
            }

            if (Math.abs(ans - correctAnswer) < 0.0001)
                correctLabel.setText(String.valueOf(++correct));
            else
                incorrectLabel.setText(String.valueOf(++incorrect));

            // 🟩 Automatically generate new random numbers after submitting
            generateRandomNumbers();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new Arithmeticgame();
    }
}
