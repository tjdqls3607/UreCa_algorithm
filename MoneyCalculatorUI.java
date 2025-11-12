import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoneyCalculatorUI extends JFrame {
    private JTextField inputField;
    private JLabel[] countLabels;

    private final int[] units = {50000, 10000, 1000, 500, 100, 10, 1};
    private final String[] unitNames = {"5만원", "1만원", "1천원", "500원", "100원", "10원", "1원"};

    public MoneyCalculatorUI() {
        setTitle("금액 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        // 입력 영역
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(10);
        JButton calcButton = new JButton("계산");
        inputPanel.add(new JLabel("금액 입력:"));
        inputPanel.add(inputField);
        inputPanel.add(calcButton);
        add(inputPanel, BorderLayout.NORTH);

        // 결과 출력 영역
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(units.length, 2, 5, 5));
        countLabels = new JLabel[units.length];

        for (int i = 0; i < units.length; i++) {
            JLabel label = new JLabel(unitNames[i]);
            label.setHorizontalAlignment(JLabel.RIGHT);

            JLabel countLabel = new JLabel("0");
            countLabel.setHorizontalAlignment(JLabel.CENTER);
            countLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // 박스처럼 보이게

            resultPanel.add(label);
            resultPanel.add(countLabel);
            countLabels[i] = countLabel;
        }

        add(resultPanel, BorderLayout.CENTER);

        // 계산 버튼 이벤트
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMoney();
            }
        });

        setVisible(true);
    }

    private void calculateMoney() {
        String inputText = inputField.getText();
        try {
            int amount = Integer.parseInt(inputText);
            for (int i = 0; i < units.length; i++) {
                int count = amount / units[i];
                amount %= units[i];
                countLabels[i].setText(String.valueOf(count));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "숫자만 입력하세요", "입력 오류", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MoneyCalculatorUI());
    }
}