package com.FootballClient.Presentation.Owner;



import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddCoach extends JFrame implements com.FootballClient.Presentation.Menu {
    @Autowired
    Client client = new Client();

    private JPanel menuPanel;
    private JLabel chooseUserLable;
    private JComboBox usersComboBox;
    private JLabel chooseTeamLable;
    private JComboBox teamsComboBox;
    private JButton addButton;
    private JButton backButton;
    private JLabel errorLabel;
    private String team;
    JFrame frame = new JFrame("Add Coach");


    public AddCoach (String team){

        this.team = team;

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                   // Client.addTeamCoach(chooseTeamLable.getText(), teamsComboBox.getActionCommand());
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


        List<String> allCoaches = client.getPotentialCoaches(team);
        for (int i = 0; i < allCoaches.size(); i++) {
            usersComboBox.addItem(allCoaches.get(i));
        }


        chooseUserLable.setForeground(new Color(0x3A89CE));
        chooseUserLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = chooseUserLable.getPreferredSize();
        chooseUserLable.setBounds(230, 200,size.width, size.height);

        usersComboBox.setBounds(300, 240,300, 30 );

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
        AddAsset addAsset = new AddAsset();
        addAsset.showMenu();
        this.frame.dispose();
    }
}
