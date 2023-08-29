package org.example.layout;

import lombok.Data;

import javax.swing.*;

@Data
public class MainPage {
    private JPanel mainPage;

    public MainPage() {
        this.mainPage = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPage,BoxLayout.Y_AXIS);
        mainPage.setLayout(boxLayout);
        FormPanel formPanel = new FormPanel();
        mainPage.add(formPanel.getFormPanel());
    }
}
