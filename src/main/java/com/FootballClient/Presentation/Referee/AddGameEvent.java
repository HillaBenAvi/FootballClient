package com.FootballClient.Presentation.Referee;

import javax.swing.*;
import com.FootballClient.Presentation.Menu;

import java.awt.*;

public class AddGameEvent implements Menu {
    private JComboBox gamesComboBox;
    private JLabel chooseGameLabel;
    private JComboBox typesComboBox;
    private JComboBox playersComboBox;
    private JTextArea descriptionArea;
    private JLabel chooseTypeLabel;
    private JLabel choosePlayerLabel;
    private JLabel descriptionLabel;
    private JLabel minutesLabel;
    private JTextField minuteInGameField;
    JFrame frame = new JFrame("Add Game Event");
    private JPanel menuPanel;


    public void showMenu() {
        this.menuPanel = new JPanel();
        frame.setSize(900,700);
        frame.setContentPane(this.menuPanel);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);


        chooseGameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseGameLabel.getPreferredSize();
        chooseGameLabel.setBounds(250, 70, size.width, size.height );

        gamesComboBox.setBounds(300, 110, 290, 30);

        chooseTypeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTypeLabel.getPreferredSize();
        chooseTypeLabel.setBounds(350, 150, size.width, size.height );



        menuPanel.setLayout(null);
        menuPanel.add(chooseGameLabel);
        menuPanel.add(gamesComboBox);
        menuPanel.add(chooseTypeLabel);

        frame.setVisible(true);

    }

    public void exitMenu() {

    }
}
