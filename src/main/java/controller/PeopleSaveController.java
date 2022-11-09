package controller;

import saveData.WriteData;
import sistem.SistemPeople;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PeopleSaveController implements ActionListener {
    private SistemPeople sistemPeople;
    private WriteData writeData;
    private JFrame firstWindow;

    public PeopleSaveController(SistemPeople sistemPeople,JFrame firstWindow, WriteData writeData) {
        this.sistemPeople = sistemPeople;
        this.firstWindow = firstWindow;
        this.writeData = writeData;
    }

    public void actionPerformed(ActionEvent e){
        try{
            writeData.savePerson(sistemPeople.getPeoples());
            JOptionPane.showMessageDialog(firstWindow, "Contacts saved successfully");
        }catch (IOException ioException){
            JOptionPane.showMessageDialog(firstWindow, "Contacts not found" + ioException.getMessage());

        }
    }
}
