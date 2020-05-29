package com.FootballClient.Presentation.Referee;

import javax.swing.*;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AddGameEvent implements Menu {
    @Autowired
    Client client =Client.getInstance();

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
    private JButton backButton;
    private JButton addEventButton;
    JFrame frame = new JFrame("Add Game Event");
    private JPanel menuPanel;


    public AddGameEvent(){

        addEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.updateGameEvents((String)gamesComboBox.getSelectedItem(),descriptionArea.getText(),
                        minuteInGameField.getText(), (String)typesComboBox.getSelectedItem(),
                        (String)playersComboBox.getSelectedItem());
                }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
    }

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

        ArrayList<String> games = client.getRefereeGames();
        for (int i = 0; i < games.size(); i++) {
            gamesComboBox.addItem(games.get(i));
        }

        chooseTypeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTypeLabel.getPreferredSize();
        chooseTypeLabel.setBounds(350, 150, size.width, size.height );

        typesComboBox.setBounds(300, 190, 290, 30);

        typesComboBox.addItem("GOAL");
        typesComboBox.addItem("OFFSIDE");
        typesComboBox.addItem("RED_CARD");
        typesComboBox.addItem("YELLOW_CARD");
        typesComboBox.addItem("WOUND");
        typesComboBox.addItem("REPLACEMENT");

        choosePlayerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = choosePlayerLabel.getPreferredSize();
        choosePlayerLabel.setBounds(325, 230, size.width, size.height );

        playersComboBox.setBounds(300, 270, 290, 30);

        ArrayList<String> players = client.getGamePlayers((String)gamesComboBox.getSelectedItem());
        for (String player: players) {
            playersComboBox.addItem(player);
        }

        minutesLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = minutesLabel.getPreferredSize();
        minutesLabel.setBounds(360, 310, size.width, size.height );

        minuteInGameField.setBounds(365, 350, 150, 30);

        descriptionLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = descriptionLabel.getPreferredSize();
        descriptionLabel.setBounds(390, 390, size.width, size.height );

        descriptionArea.setBounds(365, 430, 150, 80);

        Style.setButtonStyle(addEventButton);
        addEventButton.setBounds(365, 555, 150, 50);

        Style.setButtonStyle(backButton);
        backButton.setBounds(750, 560, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(chooseGameLabel);
        menuPanel.add(gamesComboBox);
        menuPanel.add(chooseTypeLabel);
        menuPanel.add(typesComboBox);
        menuPanel.add(choosePlayerLabel);
        menuPanel.add(playersComboBox);
        menuPanel.add(minutesLabel);
        menuPanel.add(minuteInGameField);
        menuPanel.add(descriptionLabel);
        menuPanel.add(descriptionArea);
        menuPanel.add(addEventButton);
        menuPanel.add(backButton);


        frame.setVisible(true);

    }

    public void exitMenu() {
        RefereeMenu refereeMenu = new RefereeMenu();
        refereeMenu.showMenu();
        this.frame.dispose();
    }
}
