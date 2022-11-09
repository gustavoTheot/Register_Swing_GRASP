package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


import sistem.People;
import sistem.SistemPeople;

import swing.PeopleTable;


public class PeopleViewController implements ActionListener {
    private SistemPeople sistemPeople;
    private JFrame window;


    public PeopleViewController(SistemPeople sistemPeople, JFrame window) {
        this.sistemPeople = sistemPeople;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<People> allPeople = sistemPeople.viewAllPeople();

        System.out.println(allPeople);

        if(allPeople.size() > 0){
            PeopleTable table = new PeopleTable(allPeople);
            table.setLocationRelativeTo(null);
            table.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(window, "No person was found");
        }
    }

}
