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
    private JButton backButton;
    private JPanel menuPanel;
    private JLabel label;

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

        //background
        ImageIcon icon = new ImageIcon("resources\\SystemManagerMenu.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);


        Style.setButtonStyle(addAssetButton);
        addAssetButton.setBounds(300, 150, 200, 50);
        Style.setButtonStyle(removeAssetButton);
        removeAssetButton.setBounds(300, 220, 200, 50);
        Style.setButtonStyle(backButton);
        backButton.setBounds(300, 340, 200, 50);


        frame.add(addAssetButton);
        frame.add(removeAssetButton);
        frame.add(backButton);

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
