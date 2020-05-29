package com.FootballClient.Presentation.AssociationDelegate;

import javax.swing.*;

import com.FootballClient.Client.Client;
import com.FootballClient.Presentation.Menu;
import com.FootballClient.Presentation.Style.Style;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SetLeagueByYear implements Menu{
    @Autowired
    Client client = Client.getInstance();

    private JComboBox leagusComboBox;
    private JTextField yearsTextField;
    private JLabel yearLabel;
    private JLabel policyLabel;
    private JTextField winnerScoreTextField;
    private JLabel winnerScoreLabel;
    private JLabel drawScoreLabel;
    private JTextField drawScoreTextField;
    private JTextField loserScoreTextField;
    private JLabel leaguesLabel;
    private JPanel menuPanel;
    private JLabel loserScoreLabel;
    private JLabel schedulingPolicyLabel;
    private JComboBox schedulingPolicyComboBox;
    private JButton OKButton;
    private JButton backButton;
    JFrame frame = new JFrame("Set league by year");

    private JLabel label;

    public SetLeagueByYear(){
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.setLeagueByYear(yearsTextField.getText(),(String) leagusComboBox.getSelectedItem(),
                        winnerScoreTextField.getText(), drawScoreTextField.getText(),
                        loserScoreTextField.getText(), (String)schedulingPolicyComboBox.getSelectedItem() );
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
        ImageIcon icon = new ImageIcon("resources\\SetLeagueByYear.png");
        label = new JLabel();
        label.setVisible(true);
        label.setSize(400,500);
        label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT)));
        Dimension size = label.getPreferredSize();
        label.setBounds(0, 0, size.width, size.height);

        frame.setContentPane(this.label);

        leaguesLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = leaguesLabel.getPreferredSize();
        leaguesLabel.setBounds(350, 70, size.width, size.height );

        leagusComboBox.setBounds(290, 110, 300, 30 );

        ArrayList<String> leagues = client.getAllLeagues();
        for(int i=0;i<leagues.size(); i++){
            leagusComboBox.addItem(leagues.get(i));
        }

        yearLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = yearLabel.getPreferredSize();
        yearLabel.setBounds(395, 150, size.width, size.height );

        yearsTextField.setBounds(405, 190, 70, 30);

        policyLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = policyLabel.getPreferredSize();
        policyLabel.setBounds(385, 250, size.width, size.height);

        winnerScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = winnerScoreLabel.getPreferredSize();
        winnerScoreLabel.setBounds(280, 290, size.width, size.height);

        winnerScoreTextField.setBounds(280, 330, 70, 30);

        drawScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = drawScoreLabel.getPreferredSize();
        drawScoreLabel.setBounds(420, 290, size.width, size.height);

        drawScoreTextField.setBounds(410, 330, 70, 30);

        loserScoreLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = loserScoreLabel.getPreferredSize();
        loserScoreLabel.setBounds(540, 290, size.width, size.height);

        loserScoreTextField.setBounds(530, 330, 70, 30);

        schedulingPolicyLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        size = schedulingPolicyLabel.getPreferredSize();
        schedulingPolicyLabel.setBounds(295, 390, size.width, size.height);

        schedulingPolicyComboBox.setBounds(290, 430, 300, 30);

        ArrayList<String> policies = client.getAllSchedulingPolicies();
        for(int i=0;i<policies.size(); i++){
            schedulingPolicyComboBox.addItem(policies.get(i));
        }

        Style.setButtonStyle(OKButton);
        OKButton.setBounds(370, 490, 140, 50);

        Style.setButtonStyle(backButton);
        backButton.setBounds(750, 560, 100, 50);

        frame.setLayout(null);
        frame.add(leaguesLabel);
        frame.add(leagusComboBox);
        frame.add(yearLabel);
        frame.add(yearsTextField);
        frame.add(policyLabel);
        frame.add(winnerScoreLabel);
        frame.add(drawScoreLabel);
        frame.add(loserScoreLabel);
        frame.add(winnerScoreTextField);
        frame.add(drawScoreTextField);
        frame.add(loserScoreTextField);
        frame.add(schedulingPolicyLabel);
        frame.add(schedulingPolicyComboBox);
        frame.add(backButton);
        frame.add(OKButton);

        this.frame.setVisible(true);
    }

    public void exitMenu() {
        AssociationDelegateMenu adm = new AssociationDelegateMenu();
        adm.showMenu();
        this.frame.dispose();
    }
}
