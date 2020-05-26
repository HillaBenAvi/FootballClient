package com.FootballClient.Presentation.Referee;

import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Style.Style;
//import com.FootballClient.Service.ServiceControllerDummy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefereeMenu implements com.FootballClient.Presentation.Menu {

    JFrame frame = new JFrame("Referee");
//    private ServiceControllerDummy serviceControllerDummy =  ServiceControllerDummy.getInstance();

    private JPanel menuPanel;
    private JPanel notification;
    private JButton viewScheduleButton;
    private JButton editDetailsButton;
    private JButton addGameEventButton;
    private JButton logOutButton;
    private JLabel name;
    private JButton createGameReportButton;
    private JButton getAddGameEventButton;


    public RefereeMenu(){
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

        Style.setButtonStyle(createGameReportButton);
        createGameReportButton.setBounds(350, 270, 200, 50);
        Style.setButtonStyle(addGameEventButton);
        addGameEventButton.setBounds(350, 340, 200, 50);
        Style.setButtonStyle(logOutButton);
        logOutButton.setBounds(350, 410, 200, 50);

        menuPanel.setLayout(null);
        menuPanel.add(createGameReportButton);
        menuPanel.add(addGameEventButton);
        menuPanel.add(logOutButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
//        serviceControllerDummy.logOut();
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }


}