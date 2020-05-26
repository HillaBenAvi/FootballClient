package com.FootballClient.Presentation.Style;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Style {

    public static void setButtonStyle (JButton btn){
        btn.setFont(new Font("Calibri", Font.PLAIN, 20));
        btn.setBackground(new Color(0x91C9FF));
        btn.setForeground(Color.white);
        btn.setBorder(new EmptyBorder(5, 15, 5, 15));
        btn.setUI(new StyledButtonUI());
    }

    public static void setButtonStyle (JButton btn, Color color, int fontSize){
        btn.setFont(new Font("Calibri", Font.PLAIN, fontSize));
        btn.setBackground(color);
        btn.setForeground(Color.white);
        btn.setBorder(new EmptyBorder(5, 15, 5, 15));
        btn.setUI(new StyledButtonUI());
    }



}
