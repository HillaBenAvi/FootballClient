package com.FootballClient.Presentation.Guest;
import org.springframework.stereotype.Service;


//import Exception.*;
import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;
//import Service.ServiceControllerDummy;

import javax.swing.*;
import javax.xml.ws.ServiceMode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;

@Service
public class SignIn implements com.FootballClient.Presentation.Menu {
    JFrame frame = new JFrame("SignIn");
    //private ServiceControllerDummy serviceControllerDummy = ServiceControllerDummy.getInstance();

    /*********** SIGNIN ************/
    private JPanel signPanel;
    private JButton signButton;
    private JButton backButton;
    private JTextField mailField;
    private JTextField nameField;
    private JTextField passwordField1;
    private JPasswordField passwordField2;
    private JPanel down;
    private JPanel up;
    private JPanel signForm;
    private JLabel errorMail;
    private JLabel errorPass;
    private JLabel errorMatch;
    private JLabel title;
    private JLabel mailLabel;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JLabel confirmLabel;

    @Autowired
    Client client = new Client();

    public SignIn(){

        signButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorMatch.setText("");
                errorMail.setText("");
                errorPass.setText("");
                client.register(nameField.getText(), mailField.getText(), passwordField1.getText());
                System.out.println("pressSign");
                exitMenu();
                System.out.println("afterSign");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
    }


    public void showMenu() {
        signPanel = new JPanel();
        frame.setContentPane(this.signPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.setLocation(500,200);
        signPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setContentPane(this.signPanel);

        Dimension size = title.getPreferredSize();
        title.setBounds(320, 150, size.width, size.height);

        size = mailLabel.getPreferredSize();
        mailLabel.setBounds(200, 200, size.width, size.height);
        mailField.setBounds(400, 200, 300, 30);

        size = nameLabel.getPreferredSize();
        nameLabel.setBounds(200, 250, size.width, size.height);
        nameField.setBounds(400, 250, 300, 30);

        size = passwordLabel.getPreferredSize();
        passwordLabel.setBounds(200, 300, size.width, size.height);
        passwordField1.setBounds(400, 300, 300, 30);


        size = confirmLabel.getPreferredSize();
        confirmLabel.setBounds(200, 350, size.width, size.height);
        passwordField2.setBounds(400, 350, 300, 30);

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 420, 100, 50);

        Style.setButtonStyle(signButton);
        signButton.setBounds(330, 420, 100, 50);


        signPanel.setLayout(null);
        signPanel.add(title);
        signPanel.add(mailLabel);
        signPanel.add(mailField);
        signPanel.add(nameLabel);
        signPanel.add(nameField);
        signPanel.add(passwordLabel);
        signPanel.add(passwordField1);
        signPanel.add(confirmLabel);
        signPanel.add(passwordField2);
        signPanel.add(backButton);
        signPanel.add(signButton);

        frame.setVisible(true);
    }

    @Override
    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }
}
