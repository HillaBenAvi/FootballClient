package com.FootballClient.Presentation.Owner;
import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;
import com.FootballClient.Presentation.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RemoveField implements Menu {
    @Autowired
    Client client = new Client();
    JFrame frame = new JFrame("Add Asset");
    private JPanel menuPanel;
    private JLabel chooseFieldLable;
    private JComboBox fieldsComboBox;
    private JComboBox teamsComboBox;
    private JButton backButton;
    private JButton OKButton;
    private JLabel chooseTeamLable;
    private String team;

    public RemoveField(String team){
        this.team = team;
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    client.removeTeamField(fieldsComboBox.getActionCommand(), teamsComboBox.getActionCommand());
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
            fieldsComboBox.addItem(allManagers.get(i));
        }

        chooseFieldLable.setForeground(new Color(0x3A89CE));
        chooseFieldLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseFieldLable.getPreferredSize();
        chooseFieldLable.setBounds(230, 200,size.width, size.height);

        fieldsComboBox.setBounds(300, 240,300, 30 );

        chooseTeamLable.setForeground(new Color(0x3A89CE));
        chooseTeamLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTeamLable.getPreferredSize();
        chooseTeamLable.setBounds(390, 300,size.width, size.height );

        teamsComboBox.setBounds(300, 340,300, 30 );

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 450, 100, 50);
        Style.setButtonStyle(OKButton);
        OKButton.setBounds(330, 450, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(backButton);
        menuPanel.add(OKButton);
        menuPanel.add(chooseFieldLable);
        menuPanel.add(chooseTeamLable);
        menuPanel.add(fieldsComboBox);
        menuPanel.add(teamsComboBox);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }
}
