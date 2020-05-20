package com.FootballClient;

import jdk.nashorn.internal.objects.annotations.Function;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class FootballClientApplication {
//
//    public static void main(String[] args) {
//
//        SpringApplication.run(FootballClientApplication.class, args);
//    }
//
//}



@SpringBootApplication
public class FootballClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FootballClientApplication.class).headless(false).run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        //8081
        JFrame frame = new JFrame("Football");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JPanel panel = new JPanel(new BorderLayout());
        JTextField text = new JTextField("Hilla the queen");
        panel.add(text, BorderLayout.CENTER);
        frame.setContentPane(panel);
        Button button=new Button("login");
        button.setSize(100,100);
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.setVisible(true);
    }


}
