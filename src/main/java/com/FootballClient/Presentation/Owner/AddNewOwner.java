package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddNewOwner extends JFrame implements com.FootballClient.Presentation.Menu {
    JFrame frame = new JFrame("Add New Owner");
    private JPanel menuPanel;
    private JComboBox usersComboBox;
    private JLabel chooseTeamLable;
    private JComboBox teamsComboBox;
    private JButton addButton;
    private JButton backButton;
    private JLabel errorLabel;
    private JLabel chooseUserLable;
    private String team;

    @Autowired
    Client client = new Client();

    public AddNewOwner(String team){
        this.team = team;
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   // client.addTeamOwner(chooseTeamLable.getText(), teamsComboBox.getActionCommand());
                    exitMenu();
                } catch (Exception e1) {
                    errorLabel.setText("You don't fill everything correctly");
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
        errorLabel.setText("");

        List<String> allManagers = client.getTeamOwners(team);
        for (int i = 0; i < allManagers.size(); i++) {
            usersComboBox.addItem(allManagers.get(i));
        }


        chooseUserLable.setForeground(new Color(0x3A89CE));
        chooseUserLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseUserLable.getPreferredSize();
        chooseUserLable.setBounds(230, 200,size.width, size.height);

        usersComboBox.setBounds(300, 240,300, 30 );

        chooseTeamLable.setForeground(new Color(0x3A89CE));
        chooseTeamLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTeamLable.getPreferredSize();
        chooseTeamLable.setBounds(390, 300,size.width, size.height );

        teamsComboBox.setBounds(300, 340,300, 30 );

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 450, 100, 50);
        Style.setButtonStyle(addButton);
        addButton.setBounds(330, 450, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(addButton);
        menuPanel.add(chooseUserLable);
        menuPanel.add(chooseTeamLable);
        menuPanel.add(usersComboBox);
        menuPanel.add(teamsComboBox);

        frame.setVisible(true);

    }


    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }
}
