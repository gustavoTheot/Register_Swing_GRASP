import swing.SistemPeopleGUI;

import javax.swing.*;

public class MainInterface {
    public static void main(String[] args) {
        JFrame window = new SistemPeopleGUI();
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
