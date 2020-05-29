package com.FootballClient.Presentation.Owner;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Message;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddAsset extends JFrame implements Menu {

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

    private JLabel addlable;
    private JLabel chooseTeamLable;
    private JComboBox teamsComboBox;
    private JButton chooseButton;
    private JComboBox usersComboBox;
    private JTextField fieldTextField;
    private JLabel addManagerLabel;
    private JLabel addPlayerLabel;
    private JLabel addCoachLabel;
    private JLabel addFieldLabel;

    private JButton addPlayerButton;
    private JButton addFieldButton;
    private JButton addCoachButton;
    private JButton addManagerButton;

    private JLabel label;

    Message message = new Message();


    public AddAsset(){
        errorLabel.setText("");

        r1.setActionCommand("Team Manager");
        r2.setActionCommand("Coach");
        r3.setActionCommand("Player");
        r4.setActionCommand("Field");

        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(menuPanel);
                if (r1.isSelected()) {
                    addTeamManager();
                }
                if (r2.isSelected()) {
                    addCoach();
                }
                if (r3.isSelected()) {
                    addPlayer();
                }
                if (r4.isSelected()) {
                    addField();
                } else {
                    errorLabel.setText("You need to choose asset!");
                }
            }
        });

        addPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ans = client.addTeamPlayer((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
                message.showMessage(ans);
                exitMenu();
            }
        });
        addCoachButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.addTeamCoach((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
                message.showMessage(ans);
                exitMenu();
            }
        });
        addFieldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.addTeamField((String)teamsComboBox.getSelectedItem(),fieldTextField.getText());
                message.showMessage(ans);
                exitMenu();
            }
        });
        addManagerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.addTeamManager((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
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
//        frame.setContentPane(this.menuPanel);
        menuPanel.setBorder(BorderFactory.createLineBorder(new Color(0xAEB8C6),5));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);

        //background
        ImageIcon icon = new ImageIcon("resources\\AddAsset.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        r1.setFont(new Font("Calibri", Font.PLAIN, 20));
        r2.setFont(new Font("Calibri", Font.PLAIN, 20));
        r3.setFont(new Font("Calibri", Font.PLAIN, 20));
        r4.setFont(new Font("Calibri", Font.PLAIN, 20));

        size = r1.getPreferredSize();
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
        Style.setButtonStyle(addPlayerButton);
        addPlayerButton.setBounds(390, 550, 100, 50);

        Style.setButtonStyle(addManagerButton);
        addManagerButton.setBounds(390, 550, 100, 50);
        Style.setButtonStyle(addCoachButton);
        addCoachButton.setBounds(390, 550, 100, 50);
        Style.setButtonStyle(addFieldButton);
        addFieldButton.setBounds(390, 550, 100, 50);

        Style.setButtonStyle(chooseButton);
        chooseButton.setBounds(390, 320, 100, 50);

        addlable.setForeground(new Color(0x3A89CE));
        addlable.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addlable.getPreferredSize();
        addlable.setBounds(280, 210,size.width, size.height );

        addPlayerLabel.setForeground(new Color(0x3A89CE));
        addPlayerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addPlayerLabel.getPreferredSize();
        addPlayerLabel.setBounds(280, 430, size.width, size.height);

        addManagerLabel.setForeground(new Color(0x3A89CE));
        addManagerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addManagerLabel.getPreferredSize();
        addManagerLabel.setBounds(280, 430, size.width, size.height);

        addCoachLabel.setForeground(new Color(0x3A89CE));
        addCoachLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addCoachLabel.getPreferredSize();
        addCoachLabel.setBounds(280, 430, size.width, size.height);

        addFieldLabel.setForeground(new Color(0x3A89CE));
        addFieldLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addFieldLabel.getPreferredSize();
        addFieldLabel.setBounds(320, 430, size.width, size.height);


        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(r4);
        frame.add(backButton);
        frame.add(addPlayerButton);
        frame.add(addFieldButton);
        frame.add(addCoachButton);
        frame.add(addManagerButton);
        frame.add(addlable);
        frame.add(chooseTeamLable);
        frame.add(teamsComboBox);
        frame.add(chooseButton);

        frame.add(addPlayerLabel);
        frame.add(addManagerLabel);
        frame.add(addCoachLabel);
        frame.add(addFieldLabel);

        addPlayerLabel.setVisible(false);
        addManagerLabel.setVisible(false);
        addCoachLabel.setVisible(false);
        addFieldLabel.setVisible(false);
        addPlayerButton.setVisible(false);
        addCoachButton.setVisible(false);
        addFieldButton.setVisible(false);
        addManagerButton.setVisible(false);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }


    private void addTeamManager() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        addManagerButton.setVisible(true);
        addManagerLabel.setVisible(true);
        List<String> users = client.getPotentialManagers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }

    }

    private void addCoach() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        List<String> users = client.getPotentialCoaches((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }

        addCoachLabel.setVisible(true);
        addCoachButton.setVisible(true);
        frame.setVisible(true);

    }

    private void addPlayer() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        List<String> users = client.getPotentialPlayers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }
        addPlayerLabel.setVisible(true);
        addPlayerButton.setVisible(true);
        frame.setVisible(true);
    }

    private void addField() {
        fieldTextField.setBounds(340, 490, 200, 30);
        frame.add(fieldTextField);
        fieldTextField.setVisible(true);
        addFieldLabel.setVisible(true);
        frame.setVisible(true);
        addFieldButton.setVisible(true);
    }

}
