package javaswing;

import javaswing.OperationAdd;
import javaswing.OperationSub;
import javaswing.OperationMul;
import javaswing.OperationDiv;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private JTextField input1, input2, result;

    public Calculator() {
        setTitle("Mini Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center screen
        setResizable(false);

        Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
        Font titleFont = new Font("SansSerif", Font.BOLD | Font.ITALIC, 18);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 5, 10);

        JLabel title = new JLabel("Tính toán đơn giản 2 số");
        title.setFont(titleFont);
        title.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("Số thứ 1 :"), gbc);

        gbc.gridx = 1;
        input1 = new JTextField(12);
        panel.add(input1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Số thứ 2 :"), gbc);

        gbc.gridx = 1;
        input2 = new JTextField(12);
        panel.add(input2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Kết quả :"), gbc);

        gbc.gridx = 1;
        result = new JTextField(12);
        result.setEditable(false);
        result.setForeground(Color.BLUE);
        panel.add(result, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnAdd = new JButton("Cộng");
        JButton btnSub = new JButton("Trừ");
        JButton btnMul = new JButton("Nhân");
        JButton btnDiv = new JButton("Chia");
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSub);
        buttonPanel.add(btnMul);
        buttonPanel.add(btnDiv);
        panel.add(buttonPanel, gbc);

        gbc.gridy++;
        JButton btnExit = new JButton("Thoát");
        btnExit.setForeground(Color.RED);
        panel.add(btnExit, gbc);

        btnAdd.addActionListener(e -> calculate("add"));
        btnSub.addActionListener(e -> calculate("sub"));
        btnMul.addActionListener(e -> calculate("mul"));
        btnDiv.addActionListener(e -> calculate("div"));
        btnExit.addActionListener(e -> System.exit(0));

        add(panel);
    }

    private void calculate(String operation) {
        try {
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            double res = 0;

            switch (operation) {
                case "add": res = OperationAdd.add(a, b); break;
                case "sub": res = OperationSub.subtract(a, b); break;
                case "mul": res = OperationMul.multiply(a, b); break;
                case "div": res = OperationDiv.divide(a, b); break;
            }

            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("❌ Nhập sai định dạng!");
        } catch (Exception ex) {
            result.setText("⚠️ Lỗi tính toán!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculator().setVisible(true));
    }
}