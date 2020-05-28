package com.FootballClient.Presentation.SystemManager;
import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddTeam implements Menu {
    @Autowired
    Client client = new Client();

    private JTextField teamNameTextField;
    private JComboBox ownersComboBox;
    private JButton createTeamButton;
    private JButton backButton;
    private JLabel teamNameLabel;
    private JLabel ownerLabel;
    private JPanel menuPanel;
    JFrame frame = new JFrame("Create Team");


    public AddTeam(){

        createTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.createTeam(teamNameTextField.getText() , (String)ownersComboBox.getSelectedItem());
                exitMenu();
            }
        });

        backButton.addActionListener(new ActionListener() {
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

        Style.setButtonStyle(backButton);
        backButton.setBounds(740, 540, 100, 50);
        Style.setButtonStyle(createTeamButton);
        createTeamButton.setBounds(370, 360, 150, 50);


        teamNameLabel.setForeground(new Color(0x3A89CE));
        teamNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = teamNameLabel.getPreferredSize();
        teamNameLabel.setBounds(300, 220,size.width, size.height);

        ownerLabel.setForeground(new Color(0x3A89CE));
        ownerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = ownerLabel.getPreferredSize();
        ownerLabel.setBounds(300, 290,size.width, size.height);

        ownersComboBox.setBounds(300, 320,size.width, size.height);

        teamNameTextField.setBounds(300, 240,300, 30 );


        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(teamNameTextField);
        menuPanel.add(teamNameLabel);
        menuPanel.add(ownerLabel);
        menuPanel.add(ownersComboBox);
        menuPanel.add(createTeamButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
