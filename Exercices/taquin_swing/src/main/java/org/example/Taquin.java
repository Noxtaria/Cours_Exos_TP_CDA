package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taquin extends JFrame {
    private JPanel panel;
    private List<JButton> buttons;
    private int size;

    private List<Integer> buttonValues;

    public Taquin(int size) {
        this.size = size;
        buttons = new ArrayList<>();

        panel = new JPanel(new GridLayout(size, size, 10, 10));

        Font buttonFont = new Font("Arial", Font.BOLD, 30);

        buttonValues = new ArrayList<>();
        for (int i = 1; i <= size * size - 1; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setFont(buttonFont);
            button.addActionListener(new ButtonListener());
            buttons.add(button);
            buttonValues.add(i);
        }

        Collections.shuffle(buttons);
        buttons.add(new JButton(""));
        for (JButton button : buttons) {
            panel.add(button);
        }

        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Taquin");
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            int buttonIndex = buttons.indexOf(button);
            int emptyIndex = buttons.indexOf(buttons.get(size * size - 1));

            if (isMovable(buttonIndex, emptyIndex)) {
                Collections.swap(buttons, buttonIndex, emptyIndex);
                updateButtons();
                checkWin();
            }
        }

        private boolean isMovable(int buttonIndex, int emptyIndex) {
            int buttonRow = buttonIndex / size;
            int buttonCol = buttonIndex % size;
            int emptyRow = emptyIndex / size;
            int emptyCol = emptyIndex % size;

            return (Math.abs(buttonRow - emptyRow) == 1 && buttonCol == emptyCol) ||
                    (Math.abs(buttonCol - emptyCol) == 1 && buttonRow == emptyRow);
        }

        private void updateButtons() {
            panel.removeAll();
            for (JButton button : buttons) {
                panel.add(button);
            }
            panel.revalidate();
            panel.repaint();
        }

        private void checkWin() {
            boolean isWin = true;
            for (int i = 0; i < buttons.size() - 1; i++) {
                if (!buttons.get(i).getText().equals(String.valueOf(i + 1))) {
                    isWin = false;
                    break;
                }
            }
            if (isWin) {
                JOptionPane.showMessageDialog(panel, "You win!");
            }
        }
    }
}
