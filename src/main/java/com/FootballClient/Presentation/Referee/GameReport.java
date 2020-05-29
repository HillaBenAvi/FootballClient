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


public class GameReport implements Menu{
    @Autowired
    Client client =Client.getInstance();

    private JPanel menuPanel;
    private JButton createGameReportButton;
    private JButton backButton;
    private JComboBox gamesComboBox;
    private JLabel chooseGameLabel;
    JFrame frame = new JFrame("Create Game Report");

    public GameReport(){
        createGameReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //todo:add the function below after its ready in the server
                // client.createGameReport((String)gamesComboBox.getSelectedItem());
                exitMenu();
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
        chooseGameLabel.setBounds(390, 160, size.width, size.height );

        gamesComboBox.setBounds(295, 200, 300,30);

        ArrayList<String> games = client.getRefereeGames();
        for (String game: games){
            gamesComboBox.addItem(game);
        }

        Style.setButtonStyle(createGameReportButton);
        createGameReportButton.setBounds(350, 250, 200, 50);

        Style.setButtonStyle(backButton);
        backButton.setBounds(350, 410, 200, 50);

        menuPanel.setLayout(null);
        menuPanel.add(gamesComboBox);
        menuPanel.add(createGameReportButton);
        menuPanel.add(backButton);
        menuPanel.add(chooseGameLabel);

        frame.setVisible(true);
    }

    public void exitMenu() {
        RefereeMenu refereeMenu = new RefereeMenu();
        refereeMenu.showMenu();
        this.frame.dispose();
    }
}
