package com.FootballClient.Presentation.Guest;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import com.FootballClient.Presentation.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestMenu implements Menu {
    JFrame frame = new JFrame("GuestMenu");
    /********** GUEST MENU **********/
    Client client = new Client();
    private JButton signinButton;
    private JPanel menuPanel;
    private JButton loginButton;
    private JLabel welcomeLabel;

    private JLabel label;


    public GuestMenu() {

        signinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSignInMenu();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoginMenu();
            }
        });


    }


    public void showMenu() {
        this.menuPanel = new JPanel();
        menuPanel.setSize(500,600);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setContentPane(this.menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setLocation(500,200);
        Style.setButtonStyle(loginButton, new Color(0x69D17E), 20);
        Style.setButtonStyle(signinButton, new Color(0x69D17E), 20);

        signinButton.setBounds(630, 180, 100, 50);
        loginButton.setBounds(630, 250, 100, 50);


        ImageIcon icon = new ImageIcon("resources\\welcome.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(350,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(550, 620, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(30, 30, size.width, size.height);


        welcomeLabel.setFont(new Font("Calibri", Font.PLAIN, 60));
        welcomeLabel.setForeground(new Color(0x58AF69));
        welcomeLabel.setText("Welcome!");
        size = welcomeLabel.getPreferredSize();
        welcomeLabel.setBounds(560, 80, size.width, size.height);

        ImageIcon background = new ImageIcon("resources\\welcome.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(350,500);
        label.setIcon(new ImageIcon(background.getImage().getScaledInstance(550, 620, Image.SCALE_DEFAULT)));
        size = label.getPreferredSize();
        label.setBounds(30, 30, size.width, size.height);

        menuPanel.setLayout(null);
        menuPanel.add(label);
        menuPanel.add(welcomeLabel);
        menuPanel.add(signinButton);
        menuPanel.add(loginButton);


        menuPanel.setVisible(true);
        frame.setVisible(true);
    }

    public void showLoginMenu() {
        Login login = new Login();
        login.showMenu();
        this.frame.dispose();
    }
    public void showSignInMenu() {
        SignIn signIn = new SignIn();
        signIn.showMenu();
        this.frame.dispose();
    }

    public void exitMenu() {

    }

}
