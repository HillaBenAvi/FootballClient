package com.FootballClient.Presentation.Owner;



import com.FootballClient.Client.Client;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class AddCoach extends JFrame implements com.FootballClient.Presentation.Menu {
    private JPanel panelAddCoach;
    private JLabel label;
    private JComboBox comboBox;
    private JLabel labelTeam;
    private JComboBox comboBoxTeam;
    private JButton okButton;
    private JButton backButton;
    private JLabel errorLabel;
    JFrame frame = new JFrame("Add Coach");

    @Autowired
    Client client;

    public AddCoach (){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Client.addCoach(labelTeam.getText(), comboBoxTeam.getActionCommand());
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
    public void showMenu() {
        frame.setContentPane(panelAddCoach);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setTitle("Add Coach");
        errorLabel.setText("");
            List<String> allCoaches = client.getAllCoches();
            for (int i = 0; i < allCoaches.size(); i++) {
                comboBox.addItem(allCoaches.get(i));
            }

            List<String> allteams = client.getAllTeams();
            for (int i = 0; i < allteams.size(); i++) {
                comboBoxTeam.addItem(allteams.get(i));
            }

    }

    @Override
    public void exitMenu() {
        AddAsset addAsset = new AddAsset();
        addAsset.showMenu();
        this.frame.dispose();
    }
}
