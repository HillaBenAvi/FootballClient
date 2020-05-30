package com.FootballClient.Presentation.Fan;


import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FanMenu implements Menu {

    Client  client = Client.getInstance();

    JFrame frame = new JFrame("Fan");

    private JPanel menuPanel;
    private JPanel notification;
    private JButton followTeamButton;
    private JButton followGameButton;
    private JButton logOutButton;
    private JLabel name;
    private JLabel label;

    public FanMenu() {

        followGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.addNotifyFollowEventGame();
                Message message = new Message();
                message.showMessage(ans);
            }
        });

        followTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.addNotifyAddAssetToTeam();
                Message message = new Message();
                message.showMessage(ans);
            }
        });

        logOutButton.addActionListener(new ActionListener() {
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
        ImageIcon icon = new ImageIcon("resources\\FanMenu.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);


        Style.setButtonStyle(followGameButton, new Color(0x8CB2FF), 20);
        followGameButton.setBounds(150, 150, 200, 50);
        Style.setButtonStyle(followTeamButton, new Color(0x8CB2FF), 20);
        followTeamButton.setBounds(150, 220, 200, 50);
        Style.setButtonStyle(logOutButton, new Color(0x8CB2FF), 20);
        logOutButton.setBounds(150, 450, 200, 50);


        frame.add(followGameButton);
        frame.add(logOutButton);
        frame.add(followTeamButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();

    }
}