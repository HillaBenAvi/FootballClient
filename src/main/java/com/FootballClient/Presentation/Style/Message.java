package com.FootballClient.Presentation.Style;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Message {
    private JLabel messageLabel;
    private JButton closeButton;
    private JPanel panel;
    JFrame frame = new JFrame("message");



    public void showMessage(String message){

        frame.setSize(450,350);
        frame.setLocation(750,400);
        frame.setContentPane(this.panel);

        Style.setButtonStyle(closeButton, new Color(0x71D0E4), 22);
        closeButton.setBounds(160, 210, 100, 50);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                closeMessage();
            }});


        messageLabel.setText(message);
        messageLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
        Dimension size = messageLabel.getPreferredSize();
        messageLabel.setBounds(50, 70, size.width, size.height );


        panel.setLayout(null);
        panel.add(messageLabel);
        panel.add(closeButton);

        frame.setVisible(true);

    }

    public void closeMessage(){
        frame.dispose();
    }
}
