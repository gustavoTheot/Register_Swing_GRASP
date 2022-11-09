package swing;

import sistem.People;

import javax.swing.*;
import java.util.List;

public class PeopleTable extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    public PeopleTable(List<People> p){
        render(p);
    }

    private void render(List<People> p){
        PeopleTableModel model = new PeopleTableModel(p);

        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane);
        this.pack();
    }
}
