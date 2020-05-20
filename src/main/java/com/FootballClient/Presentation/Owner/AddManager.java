package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class AddManager extends JFrame implements com.FootballClient.Presentation.Menu {
    private JPanel panelAddManager;
    private JLabel label;
    private JComboBox comboBox;
    private JLabel labelTeam;
    private JComboBox comboBoxTeams;
    private JButton okButton;
    private JButton backButton;
    private JLabel errorLabel;
    JFrame frame = new JFrame("Add Manager");

    @Autowired
    Client client;

    @Override
    public void showMenu() {
        frame.setContentPane(panelAddManager);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setTitle("Add Manager");
        errorLabel.setText("");
        try {
            List <String> allManagers = client.getManagers();
            for (int i = 0; i < allManagers.size(); i++) {
                comboBox.addItem(allManagers.get(i));
            }
        } catch (NullPointerException e) {
            errorLabel.setText("You doon't have permission to do this");
        }

        List<String> allteams = client.getTeams();
        for (int i = 0; i < allteams.size(); i++) {
            comboBoxTeams.addItem(allteams.get(i));
        }


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.addTeamManager(labelTeam.getText(), comboBoxTeams.getActionCommand());
                    exitMenu();
                } catch (Exception e1) {
                    errorLabel.setText("You don't fill everything correctly");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMenu();
            }
        });
    }

    @Override
    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }


}
