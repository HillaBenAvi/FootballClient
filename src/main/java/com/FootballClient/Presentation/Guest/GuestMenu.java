package com.FootballClient.Presentation.Guest;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;
import com.FootballClient.Presentation.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestMenu implements Menu {
    JFrame frame = new JFrame("GuestMenu");
    /********** GUEST MENU **********/
    Client client =Client.getInstance();
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
        menuPanel.setSize(900,700);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setLocation(500,200);
        Style.setButtonStyle(loginButton, new Color(0x71D0E4), 22);
        Style.setButtonStyle(signinButton, new Color(0x71D0E4), 22);

        signinButton.setBounds(160, 180, 120, 60);
        loginButton.setBounds(160, 260, 120, 60);

        ImageIcon icon = new ImageIcon("resources\\welcome.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        welcomeLabel.setFont(new Font("Calibri", Font.PLAIN, 70));
        welcomeLabel.setForeground(new Color(0x71D0E4));
        welcomeLabel.setText("Welcome!");
        size = welcomeLabel.getPreferredSize();
        welcomeLabel.setBounds(100, 80, size.width, size.height);

        frame.add(welcomeLabel);
        frame.add(signinButton);
        frame.add(loginButton);

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
