package com.FootballClient.Presentation.SystemManager;

import javax.swing.*;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;
import com.FootballClient.Presentation.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScheduelingGames implements Menu{
    @Autowired
    Client client =Client.getInstance();

    private JPanel menuPanel;
    private JLabel chooseLabel;
    private JComboBox leaguesComboBox;
    private JButton okButton;
    private JButton backButton;
    JFrame frame = new JFrame("Scheduling Games");
    private JLabel label;

    public ScheduelingGames(){
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ans = client.schedulingGames((String)leaguesComboBox.getSelectedItem());
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
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);

        //background
        ImageIcon icon = new ImageIcon("resources\\SchedulingGames.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);


        chooseLabel.setForeground(new Color(0x3A89CE));
        chooseLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseLabel.getPreferredSize();
        chooseLabel.setBounds(120, 200,size.width, size.height);

        leaguesComboBox.setBounds(80, 240,300, 30 );

        ArrayList<String> leaguesInSeasons = client.getLeaguesInSeasons();
        for(String league : leaguesInSeasons){
            leaguesComboBox.addItem(league);
        }


        Style.setButtonStyle(backButton);
        backButton.setBounds(40, 540, 100, 50);
        Style.setButtonStyle(okButton);
        okButton.setBounds(150, 320, 150, 50);

        frame.add(chooseLabel);
        frame.add(leaguesComboBox);
        frame.add(backButton);
        frame.add(okButton);

        frame.setVisible(true);
    }

    public void exitMenu() {
        SystemManagerMenu systemManagerMenu = new SystemManagerMenu();
        systemManagerMenu.showMenu();
        this.frame.dispose();
    }
}
