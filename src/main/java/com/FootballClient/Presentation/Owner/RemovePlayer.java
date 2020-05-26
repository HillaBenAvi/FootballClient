package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemovePlayer implements com.FootballClient.Presentation.Menu {
    @Autowired
    Client client = new Client();
    JFrame frame = new JFrame("Remove Player");
    private JPanel menuPanel;
    private JComboBox playersComboBox;
    private JLabel choosePlayerLable;
    private JComboBox teamsComboBox;
    private JLabel chooseTeamLable;
    private JButton OKButton;
    private JButton backButton;
    private String team;

    public RemovePlayer(String team){
        this.team = team;
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    client.removeTeamPlayer(playersComboBox.getActionCommand(), teamsComboBox.getActionCommand());
                    exitMenu();
                } catch (Exception e1) {
                    //errorLabel.setText("You don't fill everything correctly");
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
        //errorLabel.setText("");

        java.util.List<String> allManagers = client.getTeamManagers(team);
        for (int i = 0; i < allManagers.size(); i++) {
            playersComboBox.addItem(allManagers.get(i));
        }

        choosePlayerLable.setForeground(new Color(0x3A89CE));
        choosePlayerLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = choosePlayerLable.getPreferredSize();
        choosePlayerLable.setBounds(230, 200,size.width, size.height);

        playersComboBox.setBounds(300, 240,300, 30 );


        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 450, 100, 50);
        Style.setButtonStyle(OKButton);
        OKButton.setBounds(330, 450, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(OKButton);
        menuPanel.add(choosePlayerLable);
        menuPanel.add(chooseTeamLable);
        menuPanel.add(playersComboBox);
        menuPanel.add(teamsComboBox);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }
}
