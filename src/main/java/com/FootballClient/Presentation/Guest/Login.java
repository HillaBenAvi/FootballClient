package com.FootballClient.Presentation.Guest;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.AssociationDelegate.AssociationDelegateMenu;
import com.FootballClient.Presentation.Fan.FanMenu;
import com.FootballClient.Presentation.Referee.RefereeMenu;
import com.FootballClient.Presentation.Style.Style;
import com.FootballClient.Presentation.Owner.OwnerMenu;
import com.FootballClient.Presentation.SystemManager.SystemManagerMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//
@Service
public class Login implements com.FootballClient.Presentation.Menu {
    @Autowired
    Client client = Client.getInstance();

    JFrame frame = new JFrame("Login");
//    private ServiceControllerDummy serviceControllerDummy = ServiceControllerDummy.getInstance();
    /*********** LOGIN ************/
    private JPanel loginPanel;
    private JLabel loginMenu;
    private JTextField userMailTextField;
    private JButton loginButton;
    private JLabel errorLabel;
    private JButton backButton;
    private JTextField passwordField;
    private JLabel passwordLabel;
    private JLabel mailLabel;


    private JLabel label;


    public Login() {

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = client.login(userMailTextField.getText(), passwordField.getText());
                showMenu(type);
                frame.setVisible(false);
            }
        });
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
    }

    public void showMenu() {
        this.loginPanel = new JPanel();
        frame.setSize(900,700);
        loginPanel.setSize(500,600);
        loginPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);

        //background image
        ImageIcon icon = new ImageIcon("resources\\LogIn.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        //all the components

        userMailTextField.setBounds(350, 80, 300, 50);

        size = mailLabel.getPreferredSize();
        mailLabel.setBounds(240, 90,size.width, size.height);

        passwordField.setBounds(350, 150, 300, 50);

        size = passwordLabel.getPreferredSize();
        passwordLabel.setBounds(240, 160,size.width, size.height);

        Style.setButtonStyle(backButton, new Color(0xFF898E), 22);
        Style.setButtonStyle(loginButton, new Color(0xFF898E), 22);

        backButton.setBounds(480, 230, 100, 50);
        loginButton.setBounds(340, 230, 100, 50);

        size = errorLabel.getPreferredSize();

        errorLabel.setBounds(380, 280, size.width, size.height);
        errorLabel.setForeground(new Color(0xCE0A06));
        errorLabel.setFont(new Font("Calibri", Font.PLAIN, 20));



        frame.add(backButton);
        frame.add(loginButton);
        frame.add(userMailTextField);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(mailLabel);
        frame.add(errorLabel);


        frame.setVisible(true);

    }

    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }

    public void showMenu(String memberType){
        if(memberType.equals("0SystemManager")){
            SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
            systemManagerMenu.showMenu();
        }
        else if(memberType.equals("0Owner")){
            OwnerMenu ownerMenu = new OwnerMenu();
            this.frame.dispose();
            ownerMenu.showMenu();
        }
        else if(memberType.equals("0AssociationDelegate")){
            AssociationDelegateMenu associationDelegateMenu = new AssociationDelegateMenu();
            this.frame.dispose();
            associationDelegateMenu.showMenu();
        }
        else if(memberType.equals("0Fan")){
            FanMenu fanMenu = new FanMenu();
            this.frame.dispose();
            fanMenu.showMenu();
        }
        else if(memberType.equals("0MainReferee")){
            RefereeMenu refereeMenu = new RefereeMenu();
            this.frame.dispose();
            refereeMenu.showMenu();
        }
        else {
            errorLabel.setText(memberType);
            Dimension size = errorLabel.getPreferredSize();
            errorLabel.setBounds(360, 440, size.width, size.height);
            errorLabel.setVisible(true);
        }
    }
}
