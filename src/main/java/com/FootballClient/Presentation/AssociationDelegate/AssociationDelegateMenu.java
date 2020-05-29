package com.FootballClient.Presentation.AssociationDelegate;

import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Referee.AddGameEvent;
import com.FootballClient.Presentation.Style.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AssociationDelegateMenu implements Menu {
    private JPanel menuPanel;
    private JButton setLeagueByYearButton;
    private JButton logoutButton;
    private JLabel label;
    JFrame frame = new JFrame("Association Delegate");

    public AssociationDelegateMenu(){
        setLeagueByYearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               SetLeagueByYear sly = new SetLeagueByYear();
               sly.showMenu();
               frame.dispose();
            }
        });


        logoutButton.addActionListener(new ActionListener() {
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
        ImageIcon icon = new ImageIcon("resources\\SystemManagerMenu.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);


        Style.setButtonStyle(setLeagueByYearButton);
        setLeagueByYearButton.setBounds(300, 200, 200, 50);

        Style.setButtonStyle(logoutButton);
        logoutButton.setBounds(300, 410, 200, 50);

        frame.add(setLeagueByYearButton);
        frame.add(logoutButton);
        frame.setVisible(true);

        frame.setVisible(true);
    }

    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }
}