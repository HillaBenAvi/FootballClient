package com.FootballClient.Presentation;

//import com.FootballClient.Exception.*;
import com.FootballClient.Presentation.AssociationDelegate.AssociationDelegateMenu;
import com.FootballClient.Presentation.Guest.GuestMenu;
import com.FootballClient.Presentation.Owner.OwnerMenu;
import com.FootballClient.Presentation.Referee.RefereeMenu;
import com.FootballClient.Presentation.SystemManager.SystemManagerMenu;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainPresentation {
    public static void main(String[] args){

//        GuestMenu guestMenu = new GuestMenu();
//        guestMenu.showMenu();


//        OwnerMenu menu = new OwnerMenu();
//        menu.showMenu();
//
//        RefereeMenu refereeMenu = new RefereeMenu();
//        refereeMenu.showMenu();

//        SystemManagerMenu smm = new SystemManagerMenu();
//        smm.showMenu();

        AssociationDelegateMenu adm = new AssociationDelegateMenu();
        adm.showMenu();
    }
}
