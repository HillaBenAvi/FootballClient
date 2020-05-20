package com.FootballClient.Presentation;

//import com.FootballClient.Exception.*;
import com.FootballClient.Presentation.Guest.GuestMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainPresentation {
    public static void main(String[] args){

        GuestMenu guestMenu = new GuestMenu();
        guestMenu.showMenu();

    }
}
