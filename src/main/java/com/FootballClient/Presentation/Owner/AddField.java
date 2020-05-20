package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class AddField extends JFrame implements Menu {
    private JPanel panelAddField;
    private JLabel label;
    private JComboBox comboBoxTeam;
    private JTextField textFieldField;
    private JButton okButton;
    private JButton backButton;
    private JLabel errorLabel;
    JFrame frame = new JFrame("Add Field");

    @Autowired
    Client client;

    public AddField(){

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client.addField(comboBoxTeam.getActionCommand(), textFieldField.getText());
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
        frame.setContentPane(panelAddField);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setTitle("Add Manager");
        errorLabel.setText("");


        List<String> allteams = client.getTeams();
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
