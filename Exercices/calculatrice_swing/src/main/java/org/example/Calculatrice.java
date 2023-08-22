package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[][] buttons;
    private JPanel panel;

    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";

    public Calculatrice() {
        setTitle("CASIO");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(400, 100));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);

        buttons = new JButton[5][4];

        String[][] buttonLabels = {
                {"C", "+/-", "%", "/"},
                {"7", "8", "9", "*"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "+"},
                {"0", "", ",", "="}
        };

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton(buttonLabels[row][col]);
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 24));
                if (buttonLabels[row][col].equals("+") || buttonLabels[row][col].equals("-")
                        || buttonLabels[row][col].equals("*") || buttonLabels[row][col].equals("/")
                        || buttonLabels[row][col].equals("=")){
                    buttons[row][col].setBackground(Color.ORANGE);
                } else {
                    buttons[row][col].setBackground(Color.LIGHT_GRAY);
                }
                buttons[row][col].addActionListener(this);
                panel.add(buttons[row][col]);
            }
        }

        add(textField, BorderLayout.NORTH);
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String buttonLabel = e.getActionCommand();

        switch (buttonLabel) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                currentInput += buttonLabel;
                break;

            case ",":
                if (!currentInput.contains(",")) {
                    currentInput += ",";
                }
                break;

            case "C":
                currentInput = "";
                firstOperand = 0;
                operator = "";
                break;

            case "+/-":
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value = -value;
                    currentInput = String.valueOf(value);
                }
                break;

            case "%":
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value /= 100;
                    currentInput = String.valueOf(value);
                }
                break;

            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonLabel;
                firstOperand = Double.parseDouble(currentInput);
                currentInput = "";
                break;

            case "=":
                if (!operator.isEmpty() && !currentInput.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = firstOperand + secondOperand;
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            break;
                        case "/":
                            if (secondOperand != 0) {
                                result = firstOperand / secondOperand;
                            } else {
                                textField.setText("Error");
                                return;
                            }
                            break;
                    }
                    currentInput = String.valueOf(result);
                }
                break;
        }

        textField.setText(currentInput);
    }
}
