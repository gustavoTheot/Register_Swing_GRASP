package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sistem.SistemPeople;

public class PeopleRemoveController implements ActionListener {

    private SistemPeople sistemPeople;
    private JFrame firstWindow;

    public PeopleRemoveController(SistemPeople sistemPeople, JFrame firstWindow){
        this.sistemPeople = sistemPeople;
        this.firstWindow = firstWindow;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String email = JOptionPane.showInputDialog(firstWindow, "What's email is for remove?");

        boolean remove = sistemPeople.removePeople(email);
        if(remove){
            JOptionPane.showMessageDialog(firstWindow, "Email succesfully removed");
        }else{
            JOptionPane.showMessageDialog(firstWindow, "Email not found");
        }
    }
}
