package com.FootballClient.Presentation.Fan;


import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Style.Style;
//import com.FootballClient.Service.ServiceControllerDummy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FanMenu implements Menu {
    JFrame frame = new JFrame("Fan");
    //private ServiceControllerDummy serviceControllerDummy =  ServiceControllerDummy.getInstance();

    private JPanel menuPanel;
    private JPanel notification;
    private JButton editDetailsButton;
    private JButton followTeamButton;
    private JButton followGameButton;
    private JButton logOutButton;
    private JLabel name;


    public FanMenu() {
        logOutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });

    }

    public void showMenu() {
        this.menuPanel = new JPanel();
        //name.setText(serviceControllerDummy.getUserName());
        frame.setSize(900,700);
        frame.setContentPane(this.menuPanel);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);

        Style.setButtonStyle(editDetailsButton);
        editDetailsButton.setBounds(350, 200, 200, 50);
        Style.setButtonStyle(followGameButton);
        followGameButton.setBounds(350, 270, 200, 50);
        Style.setButtonStyle(followTeamButton);
        followTeamButton.setBounds(350, 340, 200, 50);
        Style.setButtonStyle(logOutButton);
        logOutButton.setBounds(350, 410, 200, 50);

        menuPanel.setLayout(null);
        menuPanel.add(followGameButton);
        menuPanel.add(logOutButton);
        menuPanel.add(followTeamButton);
        menuPanel.add(editDetailsButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        //serviceControllerDummy.logOut();
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();

    }
}