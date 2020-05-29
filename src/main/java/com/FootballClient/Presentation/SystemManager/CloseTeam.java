package com.FootballClient.Presentation.SystemManager;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CloseTeam implements com.FootballClient.Presentation.Menu {
    @Autowired
    Client client=Client.getInstance();


    private JPanel menuPanel;
    private JComboBox teamsComboBox;
    private JButton closeTeamButton;
    private JLabel closeLabel;
    private JButton backButton;

    JFrame frame = new JFrame("Close Team");

    private JLabel label;

    public CloseTeam(){
        closeTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ans = client.closeTeam((String)teamsComboBox.getSelectedItem());
                Message message = new Message();
                message.showMessage(ans);
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


        List<String> allTeams = client.getAllTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            teamsComboBox.addItem(allTeams.get(i));
        }

        Style.setButtonStyle(backButton);
        backButton.setBounds(740, 540, 100, 50);
        Style.setButtonStyle(closeTeamButton);
        closeTeamButton.setBounds(550, 250, 150, 50);


        closeLabel.setForeground(new Color(0x3A89CE));
        closeLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = closeLabel.getPreferredSize();
        closeLabel.setBounds(420, 150,size.width, size.height);

        teamsComboBox.setBounds(470, 190,300, 30 );

        frame.setLayout(null);
        frame.add(backButton);
        frame.add(closeTeamButton);
        frame.add(closeLabel);
        frame.add(teamsComboBox);


        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
