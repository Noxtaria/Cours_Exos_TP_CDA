package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculatrice extends JFrame implements ActionListener {

    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton equalButton, clearButton;
    private JPanel JPanel;

    private String currentInput;
    private double firstOperand;
    private String operator;

    public Calculatrice() {
        setTitle("CASIO");
        setSize(400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        currentInput = "";
        firstOperand = 0.0;
        operator = "";

        JPanel = new JPanel();
        JPanel.setLayout(new GridLayout(5, 4));

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            numberButtons[i].addActionListener(this);
        }

        operationButtons = new JButton[4];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        operationButtons[0] = addButton;
        operationButtons[1] = subButton;
        operationButtons[2] = mulButton;
        operationButtons[3] = divButton;

        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(this);
        }

        equalButton = new JButton("=");
        equalButton.setFont(new Font("Arial", Font.PLAIN, 24));
        equalButton.addActionListener(this);

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        clearButton.addActionListener(this);

        JPanel.add(numberButtons[7]);
        JPanel.add(numberButtons[8]);
        JPanel.add(numberButtons[9]);
        JPanel.add(divButton);
        JPanel.add(numberButtons[4]);
        JPanel.add(numberButtons[5]);
        JPanel.add(numberButtons[6]);
        JPanel.add(mulButton);
        JPanel.add(numberButtons[1]);
        JPanel.add(numberButtons[2]);
        JPanel.add(numberButtons[3]);
        JPanel.add(subButton);
        JPanel.add(numberButtons[0]);
        JPanel.add(clearButton);
        JPanel.add(equalButton);
        JPanel.add(addButton);

        add(textField, BorderLayout.NORTH);
        add(JPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                currentInput += i;
                textField.setText(currentInput);
                return;
            }
        }

        if (source == clearButton) {
            currentInput = "";
            firstOperand = 0.0;
            operator = "";
            textField.setText("");
        }

        if (source == addButton || source == subButton || source == mulButton || source == divButton) {
            operator = e.getActionCommand();
            firstOperand = Double.parseDouble(currentInput);
            currentInput = "";
        }

        if (source == equalButton) {
            if (!operator.isEmpty() && !currentInput.isEmpty()) {
                double secondOperand = Double.parseDouble(currentInput);
                double result = 0.0;
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
            }
        }
    }
}
