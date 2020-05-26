package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddField extends JFrame implements Menu {
    private JPanel menuPanel;
    private JLabel chooseTeamLable;
    private JComboBox teamsComboBox;
    private JTextField fieldNameTextField;
    private JButton addButton;
    private JButton backButton;
    private JLabel errorLabel;
    private JLabel fieldNameLable;
    private String team;
    JFrame frame = new JFrame("Add Field");

    @Autowired
    Client client = new Client();

    public AddField(String t){

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    client.addTeamField(teamsComboBox.getActionCommand(), fieldNameTextField.getText());
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

        frame.setTitle("Add Manager");
        errorLabel.setText("");

        fieldNameLable.setForeground(new Color(0x3A89CE));
        fieldNameLable.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = fieldNameLable.getPreferredSize();
        fieldNameLable.setBounds(390, 300,size.width, size.height );

        fieldNameTextField.setBounds(300, 340,300, 30 );

        Style.setButtonStyle(backButton);
        backButton.setBounds(470, 450, 100, 50);
        Style.setButtonStyle(addButton);
        addButton.setBounds(330, 450, 100, 50);

        menuPanel.setLayout(null);
        menuPanel.add(chooseTeamLable);
        menuPanel.add(teamsComboBox);
        menuPanel.add(fieldNameLable);
        menuPanel.add(fieldNameTextField);
        menuPanel.add(addButton);
        menuPanel.add(backButton);



        frame.setVisible(true);
    }


    public void exitMenu() {
        AddAsset addAsset = new AddAsset();
        addAsset.showMenu();
        this.frame.dispose();
    }
}
