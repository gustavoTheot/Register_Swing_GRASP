package swing;

import controller.PeopleRemoveController;
import controller.PeopleSaveController;
import controller.PeopleViewController;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import saveData.WriteData;
import sistem.People;
import sistem.SistemPeople;

public class SistemPeopleGUI extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JFrame window = new JFrame();
    JMenu tipeRegister, view, remove, toSave;
    JMenuItem menuItemStudent, menuItemteacher, menuItemAllPeople, menuItemselectEmailRemove, menuItemToSaved;
    JLabel labelName, labelEmail, labelPassword, labelAge;
    JFormattedTextField textFieldName, textFieldEmail, textFieldPassword, textFieldAge;
    JButton buttonConfirm;
    WriteData save = new WriteData();

    public SistemPeopleGUI(){
        SistemPeople s = new SistemPeople();
        Container container = getContentPane();
        container.setLayout(null);

        setTitle("User Register");
        setSize(600, 600);
        setResizable(false);

        /*========= Load Peoples =========*/

        Collection<People> peoples = null;
        try{
            peoples = save.loadPerson();
            for(People p : peoples){
                s.registerPeople(p.getName(), p.getEmail(), p.getPassword());
            }
            JOptionPane.showMessageDialog(null, "Contatc recoverd");
        }catch (IOException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Contact not recoverd" + e.getMessage());
        }

        /*========= Menu Bar =========*/
        setJMenuBar(menuBar);

        tipeRegister = new JMenu("Register");
        menuBar.add(tipeRegister);
        menuItemStudent = new JMenuItem("Student");
        menuItemteacher = new JMenuItem("Teacher");
        tipeRegister.add(menuItemStudent);
        tipeRegister.add(menuItemteacher);

        view = new JMenu("View");
        menuBar.add(view);
        menuItemAllPeople = new JMenuItem("View all people");
        menuItemAllPeople.addActionListener(new PeopleViewController(s,this));
        view.add(menuItemAllPeople);

        remove = new JMenu("Remove");
        menuBar.add(remove);
        menuItemselectEmailRemove = new JMenuItem("Remove one people");
        menuItemselectEmailRemove.addActionListener(new PeopleRemoveController(s, this));
        remove.add(menuItemselectEmailRemove);

        toSave = new JMenu("To save");
        menuBar.add(toSave);
        menuItemToSaved = new JMenuItem("To saved person");
        menuItemToSaved.addActionListener(new PeopleSaveController(s, this, save));
        toSave.add(menuItemToSaved);

        File file = new File(".");
        System.out.println("===>"+file.getAbsolutePath());

        /*========= Forms =========*/
        labelName = new JLabel("Name: ");
        labelName.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelName.setSize(150,30);
        labelName.setLocation(100, 100);
        container.add(labelName);

        textFieldName = new JFormattedTextField();
        textFieldName.setMargin(new Insets(0,5,0,0));
        textFieldName.setSize(200,30);
        textFieldName.setLocation(200, 100);
        container.add(textFieldName);

        labelEmail = new JLabel("Email: ");
        labelEmail.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelEmail.setSize(150,30);
        labelEmail.setLocation(100, 150);
        container.add(labelEmail);

        textFieldEmail = new JFormattedTextField();
        textFieldEmail.setMargin(new Insets(0,5,0,0));
        textFieldEmail.setSize(200,30);
        textFieldEmail.setLocation(200, 150);
        container.add(textFieldEmail);

        labelPassword = new JLabel("Password: ");
        labelPassword.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelPassword.setSize(150,30);
        labelPassword.setLocation(100, 200);
        container.add(labelPassword);

        textFieldPassword = new JFormattedTextField();
        textFieldPassword.setMargin(new Insets(0,5,0,0));
        textFieldPassword.setSize(200,30);
        textFieldPassword.setLocation(200, 200);
        container.add(textFieldPassword);

        labelAge = new JLabel("Password: ");
        labelAge.setFont(new Font("Roboto", Font.PLAIN, 16));
        labelAge.setSize(150,30);
        labelAge.setLocation(100, 200);
        container.add(labelAge);

        textFieldAge = new JFormattedTextField();
        textFieldAge.setMargin(new Insets(0,5,0,0));
        textFieldAge.setSize(200,30);
        textFieldAge.setLocation(200, 200);
        container.add(textFieldAge);

        buttonConfirm = new JButton("Confirm");
        buttonConfirm.setFont(new Font("Roboto", Font.PLAIN, 14));
        buttonConfirm.setSize(100, 40);
        buttonConfirm.setLocation(220, 400);
        buttonConfirm.addActionListener((ae) -> {
            boolean register = s.registerPeople(textFieldName.getText(), textFieldEmail.getText(), textFieldPassword.getText());
            if(register){
                JOptionPane.showMessageDialog(window, "Register person");
            }else{
                JOptionPane.showMessageDialog(window, "Person already register, verify your exists");
            }
        });
        container.add(buttonConfirm);

        setVisible(true);
    }

}
