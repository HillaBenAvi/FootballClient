package com.FootballClient.Presentation.Owner;

import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Style.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerMenu extends JFrame implements com.FootballClient.Presentation.Menu {
    JFrame frame = new JFrame("OwnerMenu");
    private JPanel panelOwner;
    private JButton removeAssetButton;
    private JButton addAssetButton;
    private JButton updateAssetButton;
    private JButton backButton;
    private JButton removeManagerButton;
    private JButton temporaryCloseTeamButton;

    private JButton reopenClosedTeamButton;
    private JPanel menuPanel;

    public OwnerMenu (){
        addAssetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    addAsset();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        removeAssetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    removeAsset();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        updateAssetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    //updateAsset();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        removeManagerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    //removeTeamManager();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        temporaryCloseTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    //temporaryCloseTeam();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        reopenClosedTeamButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    //reopenClosedTeam();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    remove(panelOwner);
                    exitMenu();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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

        Style.setButtonStyle(addAssetButton);
        addAssetButton.setBounds(350, 200, 200, 50);
        Style.setButtonStyle(removeAssetButton);
        removeAssetButton.setBounds(350, 270, 200, 50);
        Style.setButtonStyle(backButton);
        backButton.setBounds(350, 340, 200, 50);

        menuPanel.setLayout(null);
        menuPanel.add(addAssetButton);
        menuPanel.add(removeAssetButton);
        menuPanel.add(backButton);

        frame.setVisible(true);
    }


    private void addAsset(){
        AddAsset addAsset = new AddAsset();
        addAsset.showMenu();
        this.frame.dispose();
    }

    private void removeAsset(){
        RemoveAsset removeAsset = new RemoveAsset();
        removeAsset.showMenu();
        this.frame.dispose();
    }


    public void exitMenu() {
        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();
        this.frame.dispose();
    }
}
