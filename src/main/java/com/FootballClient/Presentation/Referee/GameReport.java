package com.FootballClient.Presentation.Referee;

import javax.swing.*;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.aop.aspectj.annotation.MetadataAwareAspectInstanceFactory;
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
    private JLabel label;

    public GameReport(){
        createGameReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ans = client.addNotifyGameFinalReport((String)gamesComboBox.getSelectedItem());
                Message message = new Message();
                message.showMessage(ans);
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

        //background
        ImageIcon icon = new ImageIcon("resources\\GameReport.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        chooseGameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseGameLabel.getPreferredSize();
        chooseGameLabel.setBounds(390, 100, size.width, size.height );

        gamesComboBox.setBounds(295, 140, 300,30);

        ArrayList<String> games = client.getRefereeGames();
        for (String game: games){
            gamesComboBox.addItem(game);
        }

        Style.setButtonStyle(createGameReportButton);
        createGameReportButton.setBounds(350, 200, 200, 50);

        Style.setButtonStyle(backButton);
        backButton.setBounds(730, 560, 100, 50);

        frame.setLayout(null);
        frame.add(gamesComboBox);
        frame.add(createGameReportButton);
        frame.add(backButton);
        frame.add(chooseGameLabel);

        frame.setVisible(true);
    }

    public void exitMenu() {
        RefereeMenu refereeMenu = new RefereeMenu();
        refereeMenu.showMenu();
        this.frame.dispose();
    }
}
