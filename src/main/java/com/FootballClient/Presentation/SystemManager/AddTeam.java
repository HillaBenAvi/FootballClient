package com.FootballClient.Presentation.SystemManager;
import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddTeam implements Menu {
    @Autowired
    Client client =Client.getInstance();

    private JTextField teamNameTextField;
    private JComboBox ownersComboBox;
    private JButton createTeamButton;
    private JButton backButton;
    private JLabel teamNameLabel;
    private JLabel ownerLabel;
    private JPanel menuPanel;
    JFrame frame = new JFrame("Create Team");
    private JLabel label;

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

        //background
        ImageIcon icon = new ImageIcon("resources\\AddTeam.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);


        teamNameLabel.setForeground(new Color(0x3A89CE));
        teamNameLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = teamNameLabel.getPreferredSize();
        teamNameLabel.setBounds(500, 100,size.width, size.height);

        teamNameTextField.setBounds(480, 130,300, 30 );

        ownerLabel.setForeground(new Color(0x3A89CE));
        ownerLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        size = ownerLabel.getPreferredSize();
        ownerLabel.setBounds(530, 180,size.width, size.height);

        ownersComboBox.setBounds(530, 220,size.width, size.height);

        ArrayList<String> owners = client.getPotentialOwners();
        for(String owner : owners){
            ownersComboBox.addItem(owner);
        }



        Style.setButtonStyle(backButton);
        backButton.setBounds(740, 540, 100, 50);
        Style.setButtonStyle(createTeamButton);
        createTeamButton.setBounds(560, 310, 150, 50);

        frame.setLayout(null);
        frame.add(backButton);
        frame.add(teamNameTextField);
        frame.add(teamNameLabel);
        frame.add(ownerLabel);
        frame.add(ownersComboBox);
        frame.add(createTeamButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
