import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Arithmeticgame extends JFrame implements ActionListener, ComponentListener {
    private JTextField num1Field, num2Field, answerField;
    private JLabel operatorLabel, correctLabel, incorrectLabel, title, scoreText, correctText, incorrectText, levelText, opLabel;
    private JLabel nameLabel; // ✅ Displays user's name
    private JRadioButton addBtn, subBtn, mulBtn, divBtn;
    private JButton submitBtn;
    private JComboBox<String> levelBox;
    private JPanel mathPanel;
    private ButtonGroup group;
    private int correct = 0, incorrect = 0;
    private char operation = ' ';
    private Random rand = new Random();
    private int level = 1; // 1 = Easy, 2 = Medium, 3 = Hard
    private String playerName = ""; // ✅ store player name

    public Arithmeticgame() {
        setTitle("Arithmetic Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setMinimumSize(new Dimension(900, 600));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 247, 250));
        addComponentListener(this);

        // ✅ Show login dialog before setting up UI
        playerName = JOptionPane.showInputDialog(this, "Enter your name:", "Login", JOptionPane.PLAIN_MESSAGE);
        if (playerName == null || playerName.trim().isEmpty()) {
            playerName = "Player"; // default name if empty
        }

        setupUI();
        setVisible(true);
    }

    private void setupUI() {
        title = new JLabel("Arithmetic Challenge", SwingConstants.CENTER);
        title.setFont(new Font("Poppins", Font.BOLD, 36));
        title.setForeground(new Color(40, 53, 88));
        add(title);

        // ✅ Add name label at the top
        nameLabel = new JLabel("Welcome, " + playerName + "!", SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(new Color(60, 70, 110));
        add(nameLabel);

        levelText = new JLabel("Select Level:");
        levelText.setFont(new Font("Arial", Font.BOLD, 18));
        add(levelText);

        String[] levels = {"Easy", "Medium", "Hard"};
        levelBox = new JComboBox<>(levels);
        levelBox.setFont(new Font("Arial", Font.PLAIN, 16));
        levelBox.addActionListener(e -> {
            level = levelBox.getSelectedIndex() + 1;
            generateRandomNumbers();
        });
        add(levelBox);

        opLabel = new JLabel("Operation");
        opLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(opLabel);

        addBtn = new JRadioButton("Addition");
        subBtn = new JRadioButton("Subtraction");
        mulBtn = new JRadioButton("Multiplication");
        divBtn = new JRadioButton("Division");

        JRadioButton[] ops = {addBtn, subBtn, mulBtn, divBtn};
        String[] labels = {"+", "-", "×", "÷"};

        group = new ButtonGroup();
        for (int i = 0; i < ops.length; i++) {
            final int idx = i;
            ops[i].setFont(new Font("Arial", Font.PLAIN, 16));
            ops[i].setBackground(new Color(245, 247, 250));
            ops[i].addActionListener(e -> {
                operation = labels[idx].charAt(0);
                operatorLabel.setText(String.valueOf(operation));
                generateRandomNumbers();
            });
            add(ops[i]);
            group.add(ops[i]);
        }

        mathPanel = new JPanel();
        mathPanel.setBackground(Color.WHITE);
        mathPanel.setBorder(BorderFactory.createLineBorder(new Color(180, 180, 180), 3));
        mathPanel.setLayout(null);
        add(mathPanel);

        num1Field = new JTextField();
        num1Field.setFont(new Font("Arial", Font.BOLD, 28));
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        mathPanel.add(num1Field);

        operatorLabel = new JLabel("", SwingConstants.CENTER);
        operatorLabel.setFont(new Font("Arial", Font.BOLD, 36));
        mathPanel.add(operatorLabel);

        num2Field = new JTextField();
        num2Field.setFont(new Font("Arial", Font.BOLD, 28));
        num2Field.setHorizontalAlignment(JTextField.CENTER);
        mathPanel.add(num2Field);

        JLabel equalLabel = new JLabel("=");
        equalLabel.setFont(new Font("Arial", Font.BOLD, 36));
        equalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mathPanel.add(equalLabel);

        answerField = new JTextField();
        answerField.setFont(new Font("Arial", Font.BOLD, 28));
        answerField.setHorizontalAlignment(JTextField.CENTER);
        mathPanel.add(answerField);

        // ✅ Allow pressing Enter to trigger submit
        answerField.addActionListener(this);

        // Scoreboard
        scoreText = new JLabel("Scoreboard");
        scoreText.setFont(new Font("Arial", Font.BOLD, 20));
        add(scoreText);

        correctText = new JLabel("Correct:");
        correctText.setFont(new Font("Arial", Font.PLAIN, 18));
        add(correctText);

        correctLabel = new JLabel("0", SwingConstants.CENTER);
        correctLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        correctLabel.setFont(new Font("Arial", Font.BOLD, 16));
        correctLabel.setOpaque(true);
        correctLabel.setBackground(new Color(220, 255, 220));
        add(correctLabel);

        incorrectText = new JLabel("Incorrect:");
        incorrectText.setFont(new Font("Arial", Font.PLAIN, 18));
        add(incorrectText);

        incorrectLabel = new JLabel("0", SwingConstants.CENTER);
        incorrectLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 16));
        incorrectLabel.setOpaque(true);
        incorrectLabel.setBackground(new Color(255, 220, 220));
        add(incorrectLabel);

        submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(66, 135, 245));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        submitBtn.setFocusPainted(false);
        submitBtn.setBorderPainted(false);
        submitBtn.addActionListener(this);
        add(submitBtn);

        repositionComponents();
    }

    private void repositionComponents() {
        int w = getWidth();
        int h = getHeight();

        title.setBounds(0, (int) (h * 0.03), w, 50);
        nameLabel.setBounds(0, (int) (h * 0.11), w, 25);

        levelText.setBounds((int) (w * 0.08), (int) (h * 0.18), 150, 30);
        levelBox.setBounds((int) (w * 0.18), (int) (h * 0.18), 160, 30);
        opLabel.setBounds((int) (w * 0.08), (int) (h * 0.25), 150, 30);

        int y = (int) (h * 0.3);
        for (Component c : getContentPane().getComponents()) {
            if (c instanceof JRadioButton) {
                c.setBounds((int) (w * 0.08), y, 200, 25);
                y += 30;
            }
        }

        mathPanel.setBounds((int) (w * 0.35), (int) (h * 0.25), (int) (w * 0.4), (int) (h * 0.25));
        int mw = mathPanel.getWidth();
        int mh = mathPanel.getHeight();

        Component[] m = mathPanel.getComponents();
        if (m.length == 5) {
            m[0].setBounds((int) (mw * 0.05), (int) (mh * 0.3), (int) (mw * 0.18), (int) (mh * 0.4));
            m[1].setBounds((int) (mw * 0.27), (int) (mh * 0.3), (int) (mw * 0.1), (int) (mh * 0.4));
            m[2].setBounds((int) (mw * 0.4), (int) (mh * 0.3), (int) (mw * 0.18), (int) (mh * 0.4));
            m[3].setBounds((int) (mw * 0.6), (int) (mh * 0.3), (int) (mw * 0.1), (int) (mh * 0.4));
            m[4].setBounds((int) (mw * 0.72), (int) (mh * 0.3), (int) (mw * 0.18), (int) (mh * 0.4));
        }

        submitBtn.setBounds((int) (w * 0.45), (int) (h * 0.55), (int) (w * 0.1), 45);

        scoreText.setBounds((int) (w * 0.08), (int) (h * 0.65), 200, 30);
        correctText.setBounds((int) (w * 0.08), (int) (h * 0.70), 120, 25);
        correctLabel.setBounds((int) (w * 0.18), (int) (h * 0.70), 60, 25);
        incorrectText.setBounds((int) (w * 0.08), (int) (h * 0.75), 120, 25);
        incorrectLabel.setBounds((int) (w * 0.18), (int) (h * 0.75), 60, 25);
    }

    @Override
    public void componentResized(ComponentEvent e) { repositionComponents(); }
    @Override public void componentMoved(ComponentEvent e) {}
    @Override public void componentShown(ComponentEvent e) {}
    @Override public void componentHidden(ComponentEvent e) {}

    private void generateRandomNumbers() {
        int max = switch (level) {
            case 2 -> 50;
            case 3 -> 100;
            default -> 10;
        };
        int num1 = rand.nextInt(max) + 1;
        int num2 = rand.nextInt(max) + 1;
        if (operation == '÷' && num2 == 0) num2 = 1;
        num1Field.setText(String.valueOf(num1));
        num2Field.setText(String.valueOf(num2));
        answerField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double ans = Double.parseDouble(answerField.getText());
            double correctAnswer = switch (operation) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '×' -> num1 * num2;
                case '÷' -> num2 != 0 ? num1 / num2 : Double.NaN;
                default -> {
                    JOptionPane.showMessageDialog(this, "Select an operation first!");
                    yield Double.NaN;
                }
            };
            if (Double.isNaN(correctAnswer)) return;

            if (Math.abs(ans - correctAnswer) < 0.0001) {
                correctLabel.setText(String.valueOf(++correct));
            } else {
                incorrectLabel.setText(String.valueOf(++incorrect));
            }
            generateRandomNumbers();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Arithmeticgame::new);
    }
}
