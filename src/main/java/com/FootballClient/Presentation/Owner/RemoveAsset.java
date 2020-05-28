package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveAsset implements Menu {
    @Autowired
    Client client =Client.getInstance();

    private JLabel errorLabel;
    JFrame frame = new JFrame("Add Asset");

    private JButton backButton;
    private JPanel menuPanel;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;
    private JButton addButton;
    private JLabel addlable;
    private JLabel chooseTeamLable;
    private JComboBox teamsComboBox;
    private JLabel removeManagerLabel;
    private JLabel removeCoachLabel;
    private JLabel removePlayerLabel;
    private JLabel removeFieldLabel;
    private JButton chooseButton;
    private JComboBox usersComboBox;
    private JTextField fieldTextField;


    public RemoveAsset(){
        errorLabel.setText("");

        r1.setActionCommand("Team Manager");
        r2.setActionCommand("Coach");
        r3.setActionCommand("Player");
        r4.setActionCommand("Field");

        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected()) {
                    removeTeamManager();
                }
                if (r2.isSelected()) {
                    removeCoach();
                }
                if (r3.isSelected()) {
                    removePlayer();
                }
                if (r4.isSelected()) {
                    removeField();
                } else {
                    errorLabel.setText("You need to choose asset!");
                }
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

        r1.setFont(new Font("Calibri", Font.PLAIN, 20));
        r2.setFont(new Font("Calibri", Font.PLAIN, 20));
        r3.setFont(new Font("Calibri", Font.PLAIN, 20));
        r4.setFont(new Font("Calibri", Font.PLAIN, 20));

        Dimension size = r1.getPreferredSize();
        r1.setBounds(240, 260,size.width, size.height );
        size = r2.getPreferredSize();
        r2.setBounds(410, 260,size.width, size.height );
        size = r3.getPreferredSize();
        r3.setBounds(510, 260,size.width, size.height );
        size = r4.getPreferredSize();
        r4.setBounds(610, 260,size.width, size.height );


        chooseTeamLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTeamLable.getPreferredSize();
        chooseTeamLable.setBounds(390, 80, size.width, size.height );

        teamsComboBox.setBounds(340, 130, 200, 30);

        List<String> teams = client.getTeamsByOwner();
        for (int i = 0; i < teams.size(); i++) {
            teamsComboBox.addItem(teams.get(i));
        }

        Style.setButtonStyle(backButton);
        backButton.setBounds(750, 530, 100, 50);
        Style.setButtonStyle(addButton);
        addButton.setBounds(390, 550, 100, 50);

        Style.setButtonStyle(chooseButton);
        chooseButton.setBounds(390, 320, 100, 50);

        addlable.setForeground(new Color(0x3A89CE));
        addlable.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addlable.getPreferredSize();
        addlable.setBounds(280, 210,size.width, size.height );

        removePlayerLabel.setForeground(new Color(0x3A89CE));
        removePlayerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removePlayerLabel.getPreferredSize();
        removePlayerLabel.setBounds(280, 430, size.width, size.height);

        removeManagerLabel.setForeground(new Color(0x3A89CE));
        removeManagerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeManagerLabel.getPreferredSize();
        removeManagerLabel.setBounds(280, 430, size.width, size.height);

        removeCoachLabel.setForeground(new Color(0x3A89CE));
        removeCoachLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeCoachLabel.getPreferredSize();
        removeCoachLabel.setBounds(280, 430, size.width, size.height);

        removeFieldLabel.setForeground(new Color(0x3A89CE));
        removeFieldLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeFieldLabel.getPreferredSize();
        removeFieldLabel.setBounds(320, 430, size.width, size.height);


        menuPanel.setLayout(null);
        menuPanel.add(r1);
        menuPanel.add(r2);
        menuPanel.add(r3);
        menuPanel.add(r4);
        menuPanel.add(backButton);
        menuPanel.add(addButton);
        menuPanel.add(addlable);
        menuPanel.add(teamsComboBox);
        menuPanel.add(chooseTeamLable);

        menuPanel.add(chooseButton);

        menuPanel.add(removePlayerLabel);
        menuPanel.add(removeManagerLabel);
        menuPanel.add(removeCoachLabel);
        menuPanel.add(removeFieldLabel);

        removePlayerLabel.setVisible(false);
        removeManagerLabel.setVisible(false);
        removeCoachLabel.setVisible(false);
        removeFieldLabel.setVisible(false);
        addButton.setVisible(false);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }


    private void removeTeamManager() {
//        RemoveManager removeManager = new RemoveManager((String)teamsComboBox.getSelectedItem());
//        removeManager.showMenu();
//        this.frame.dispose();

        menuPanel.add(usersComboBox);
        addButton.setVisible(true);
        removeManagerLabel.setVisible(true);
        List<String> users = client.getTeamManagers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }
    }

    private void removeCoach() {
//        RemoveCoach removeCoach = new RemoveCoach((String)teamsComboBox.getSelectedItem());
//        removeCoach.showMenu();
//        this.frame.dispose();

        usersComboBox.setBounds(340, 490, 200, 30);
        menuPanel.add(usersComboBox);
        List<String> users = client.getPotentialCoaches((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }

        removeCoachLabel.setVisible(true);
        addButton.setVisible(true);
        frame.setVisible(true);

    }


    private void removePlayer() {
//        RemovePlayer removePlayer = new RemovePlayer((String)teamsComboBox.getSelectedItem());
//        removePlayer.showMenu();
//        frame.dispose();

        usersComboBox.setBounds(340, 490, 200, 30);
        menuPanel.add(usersComboBox);
        List<String> users = client.getPotentialPlayers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }
        removePlayerLabel.setVisible(true);
        addButton.setVisible(true);
        frame.setVisible(true);
    }

    private void removeField() {
//        RemoveField removeField = new RemoveField((String)teamsComboBox.getSelectedItem());
//        removeField.showMenu();
//        frame.dispose();
        fieldTextField.setBounds(340, 490, 200, 30);
        menuPanel.add(fieldTextField);
        fieldTextField.setVisible(true);
        removeFieldLabel.setVisible(true);
        frame.setVisible(true);
        addButton.setVisible(true);

    }


}
