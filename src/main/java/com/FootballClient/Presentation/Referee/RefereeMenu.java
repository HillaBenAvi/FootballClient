package com.FootballClient.Presentation.Referee;

import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Style.Style;
import com.FootballClient.Presentation.Menu;
//import com.FootballClient.Service.ServiceControllerDummy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefereeMenu implements Menu {

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
    private JLabel label;

    public RefereeMenu(){

        addGameEventButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddGameEvent addEvent = new AddGameEvent();
                addEvent.showMenu();
                frame.dispose();
            }
        });

        createGameReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameReport gameReport = new GameReport();
                gameReport.showMenu();
                frame.dispose();
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
        ImageIcon icon = new ImageIcon("resources\\RefereeMenu.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        Style.setButtonStyle(createGameReportButton, new Color(0x6FBEE4), 22);
        createGameReportButton.setBounds(200, 150, 250, 50);
        Style.setButtonStyle(addGameEventButton, new Color(0x6FBEE4), 22);
        addGameEventButton.setBounds(200, 220, 250, 50);
        Style.setButtonStyle(logOutButton, new Color(0x6FBEE4), 22);
        logOutButton.setBounds(200, 470, 250, 50);

        frame.setLayout(null);
        frame.add(createGameReportButton);
        frame.add(addGameEventButton);
        frame.add(logOutButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }


}