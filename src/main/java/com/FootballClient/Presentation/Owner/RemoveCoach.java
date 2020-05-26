package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveCoach implements Menu {
    @Autowired
    Client client = new Client();
    JFrame frame = new JFrame("Remove Coach");

    private JPanel menuPanel;
    private JLabel chooseCoachLable;
    private JComboBox coachesComboBox;
    private JComboBox teamsComboBox;
    private JButton OKButton;
    private JButton backButton;
    private JLabel chooseTeamLable;
    private String team;

    public RemoveCoach(String team){
        this.team = team;
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    client.removeTeamPlayer(coachesComboBox.getActionCommand(), teamsComboBox.getActionCommand());
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
        //errorLabel.setText("");

        java.util.List<String> allManagers = client.getTeamCoaches(team);
        for (int i = 0; i < allManagers.size(); i++) {
            coachesComboBox.addItem(allManagers.get(i));
        }

        chooseCoachLable.setForeground(new Color(0x3A89CE));
        chooseCoachLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseCoachLable.getPreferredSize();
        chooseCoachLable.setBounds(230, 200,size.width, size.height);

        coachesComboBox.setBounds(300, 240,300, 30 );

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 450, 100, 50);
        Style.setButtonStyle(OKButton);
        OKButton.setBounds(330, 450, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(OKButton);
        menuPanel.add(chooseCoachLable);
        menuPanel.add(chooseTeamLable);
        menuPanel.add(coachesComboBox);
        menuPanel.add(teamsComboBox);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }

}
