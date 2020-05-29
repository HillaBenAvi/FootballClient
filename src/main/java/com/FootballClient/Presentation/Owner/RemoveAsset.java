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

public class RemoveAsset implements Menu {
    @Autowired
    Client client =Client.getInstance();

    private JLabel errorLabel;
    JFrame frame = new JFrame("Remove Asset");

    private JButton backButton;
    private JPanel menuPanel;
    private JRadioButton r1;
    private JRadioButton r2;
    private JRadioButton r3;
    private JRadioButton r4;

    private JLabel addLabel;
    private JLabel chooseTeamLabel;
    private JComboBox teamsComboBox;
    private JButton chooseButton;
    private JComboBox usersComboBox;

    private JLabel removeManagerLabel;
    private JLabel removeCoachLabel;
    private JLabel removePlayerLabel;
    private JLabel removeFieldLabel;

    private JButton removePlayerButton;
    private JButton removeFieldButton;
    private JButton removeManagerButton;
    private JButton removeCoachButton;

    private JLabel label;

    Message message = new Message();

    public RemoveAsset(){
        errorLabel.setText("");

        r1.setActionCommand("Team Manager");
        r2.setActionCommand("Coach");
        r3.setActionCommand("Player");
        r4.setActionCommand("Field");

        chooseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected()) {
                    removeTeamManager();
                }
                if (r2.isSelected()) {
                    removeCoach();
                }
                if (r3.isSelected()) {
                    removePlayer();
                }
                if (r4.isSelected()) {
                    removeField();
                } else {
                    errorLabel.setText("You need to choose asset!");
                }
            }
        });

        removePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.removeTeamPlayer((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
                message.showMessage(ans);
                exitMenu();
            }
        });

        removeCoachButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.removeTeamCoach((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
                message.showMessage(ans);
                exitMenu();
            }
        });

        removeFieldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.removeTeamField((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
                message.showMessage(ans);
                exitMenu();
            }
        });

        removeManagerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String ans = client.removeTeamManager((String)teamsComboBox.getSelectedItem(),(String)usersComboBox.getSelectedItem());
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


        chooseTeamLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = chooseTeamLabel.getPreferredSize();
        chooseTeamLabel.setBounds(390, 80, size.width, size.height );

        teamsComboBox.setBounds(340, 130, 200, 30);

        List<String> teams = client.getTeamsByOwner();
        for (int i = 0; i < teams.size(); i++) {
            teamsComboBox.addItem(teams.get(i));
        }

        Style.setButtonStyle(chooseButton);
        chooseButton.setBounds(390, 320, 100, 50);

        Style.setButtonStyle(backButton);
        backButton.setBounds(750, 530, 100, 50);
        Style.setButtonStyle(removePlayerButton);
        removePlayerButton.setBounds(390, 550, 100, 50);

        Style.setButtonStyle(removeCoachButton);
        removeCoachButton.setBounds(750, 530, 100, 50);

        Style.setButtonStyle(removeManagerButton);
        removeManagerButton.setBounds(390, 550, 100, 50);

        Style.setButtonStyle(removeFieldButton);
        removeFieldButton.setBounds(390, 320, 100, 50);

        addLabel.setForeground(new Color(0x3A89CE));
        addLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = addLabel.getPreferredSize();
        addLabel.setBounds(280, 210,size.width, size.height );

        removePlayerLabel.setForeground(new Color(0x3A89CE));
        removePlayerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removePlayerLabel.getPreferredSize();
        removePlayerLabel.setBounds(280, 430, size.width, size.height);

        removeManagerLabel.setForeground(new Color(0x3A89CE));
        removeManagerLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeManagerLabel.getPreferredSize();
        removeManagerLabel.setBounds(280, 430, size.width, size.height);

        removeCoachLabel.setForeground(new Color(0x3A89CE));
        removeCoachLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeCoachLabel.getPreferredSize();
        removeCoachLabel.setBounds(280, 430, size.width, size.height);

        removeFieldLabel.setForeground(new Color(0x3A89CE));
        removeFieldLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = removeFieldLabel.getPreferredSize();
        removeFieldLabel.setBounds(320, 430, size.width, size.height);


        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(r4);
        frame.add(backButton);
        frame.add(addLabel);
        frame.add(teamsComboBox);
        frame.add(chooseTeamLabel);
        frame.add(chooseButton);

        frame.add(removePlayerButton);
        frame.add(removeManagerButton);
        frame.add(removeCoachButton);
        frame.add(removeFieldButton);

        frame.add(removePlayerLabel);
        frame.add(removeManagerLabel);
        frame.add(removeCoachLabel);
        frame.add(removeFieldLabel);

        removePlayerLabel.setVisible(false);
        removeManagerLabel.setVisible(false);
        removeCoachLabel.setVisible(false);
        removeFieldLabel.setVisible(false);
        removePlayerButton.setVisible(false);
        removeManagerButton.setVisible(false);
        removeCoachButton.setVisible(false);
        removeFieldButton.setVisible(false);

        frame.setVisible(true);
    }

    public void exitMenu() {
        OwnerMenu ownerMenu = new OwnerMenu();
        ownerMenu.showMenu();
        this.frame.dispose();
    }


    private void removeTeamManager() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        removeManagerButton.setVisible(true);
        removeManagerLabel.setVisible(true);
        List<String> users = client.getTeamManagers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }
    }

    private void removeCoach() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        List<String> users = client.getTeamCoaches((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }

        removeCoachLabel.setVisible(true);
        removeCoachButton.setVisible(true);
        frame.setVisible(true);

    }


    private void removePlayer() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);
        List<String> users = client.getTeamPlayers((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < users.size(); i++) {
            usersComboBox.addItem(users.get(i));
        }
        removePlayerLabel.setVisible(true);
        removePlayerButton.setVisible(true);
        frame.setVisible(true);
    }

    private void removeField() {
        usersComboBox.setBounds(340, 490, 200, 30);
        frame.add(usersComboBox);

        List<String> fields = client.getTeamFields((String)teamsComboBox.getSelectedItem());
        for (int i = 0; i < fields.size(); i++) {
            usersComboBox.addItem(fields.get(i));
        }

        usersComboBox.setVisible(true);
        removeFieldLabel.setVisible(true);
        frame.setVisible(true);
        removePlayerButton.setVisible(true);

    }


}
