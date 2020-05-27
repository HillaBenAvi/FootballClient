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
    Client client = new Client();

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

    public Login() {

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = client.login(userMailTextField.getText(), passwordField.getText());
                showMenu(type);
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
        frame.setContentPane(this.loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 370, 100, 50);
        Style.setButtonStyle(loginButton);
        loginButton.setBounds(330, 370, 100, 50);

        Dimension size = errorLabel.getPreferredSize();

        errorLabel.setBounds(380, 420, size.width, size.height);
        errorLabel.setForeground(new Color(0xCE0A06));
        errorLabel.setFont(new Font("Calibri", Font.PLAIN, 20));

        ImageIcon icon = new ImageIcon("resources\\ball.png");
        JLabel label = new JLabel();
        label.setVisible(true);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(450, 600, Image.SCALE_DEFAULT)));
        label.setBounds(20, 20, 500, 300);

        userMailTextField.setBounds(400, 200, 300, 50);
        passwordField.setBounds(400, 270, 300, 50);
        size = passwordLabel.getPreferredSize();
        passwordLabel.setBounds(290, 280,size.width, size.height);
        size = mailLabel.getPreferredSize();
        mailLabel.setBounds(290, 210,size.width, size.height);

        loginPanel.setLayout(null);
        loginPanel.add(backButton);
        loginPanel.add(loginButton);
        loginPanel.add(userMailTextField);
        loginPanel.add(passwordField);
        loginPanel.add(passwordLabel);
        loginPanel.add(mailLabel);
        loginPanel.add(errorLabel);
        errorLabel.setVisible(false);

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
