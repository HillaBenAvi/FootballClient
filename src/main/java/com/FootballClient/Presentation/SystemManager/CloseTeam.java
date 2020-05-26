package com.FootballClient.Presentation.SystemManager;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Owner.AddAsset;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CloseTeam implements com.FootballClient.Presentation.Menu {
    @Autowired
    Client client = new Client();


    private JPanel menuPanel;
    private JComboBox teamsComboBox;
    private JButton closeTeamButton;
    private JLabel closeLabel;
    private JButton backButton;
    JFrame frame = new JFrame("Close Team");

    public CloseTeam(){
        closeTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeLabel.setText("aaaaaaa");
                //client.closeTeam((String)teamsComboBox.getSelectedItem());
                //exitMenu();
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


        List<String> allTeams = client.getAllTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            teamsComboBox.addItem(allTeams.get(i));
        }

        Style.setButtonStyle(backButton);
        backButton.setBounds(740, 540, 100, 50);
        Style.setButtonStyle(closeTeamButton);
        closeTeamButton.setBounds(370, 320, 150, 50);


        closeLabel.setForeground(new Color(0x3A89CE));
        closeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = closeLabel.getPreferredSize();
        closeLabel.setBounds(250, 200,size.width, size.height);

        teamsComboBox.setBounds(300, 240,300, 30 );

        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(closeTeamButton);
        menuPanel.add(closeLabel);
        menuPanel.add(teamsComboBox);


        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
