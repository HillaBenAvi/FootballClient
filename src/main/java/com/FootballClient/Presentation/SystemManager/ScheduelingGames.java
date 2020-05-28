package com.FootballClient.Presentation.SystemManager;

import javax.swing.*;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;
import com.FootballClient.Presentation.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScheduelingGames implements Menu{
    @Autowired
    Client client = new Client();

    private JPanel menuPanel;
    private JLabel chooseLabel;
    private JComboBox leaguesComboBox;
    private JButton okButton;
    private JButton backButton;
    JFrame frame = new JFrame("Scheduling Games");

    public ScheduelingGames(){
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.scheduleGames((String)leaguesComboBox.getSelectedItem());
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

        chooseLabel.setForeground(new Color(0x3A89CE));
        chooseLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseLabel.getPreferredSize();
        chooseLabel.setBounds(250, 200,size.width, size.height);

        leaguesComboBox.setBounds(300, 240,300, 30 );

        ArrayList<String> leaguesInSeasons = client.getLeaguesInSeasons();
        for(String league : leaguesInSeasons){
            leaguesComboBox.addItem(league);
        }

        leaguesComboBox.setBounds(300, 240,300, 30 );

        Style.setButtonStyle(backButton);
        backButton.setBounds(740, 540, 100, 50);
        Style.setButtonStyle(okButton);
        okButton.setBounds(370, 320, 150, 50);

        menuPanel.add(chooseLabel);
        menuPanel.add(leaguesComboBox);
        menuPanel.add(backButton);
        menuPanel.add(okButton);


        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
