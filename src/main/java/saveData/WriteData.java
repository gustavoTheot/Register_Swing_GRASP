package saveData;

import sistem.People;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class WriteData {

    private String file = "peoples.txt";

    public void savePerson(Collection<People> peoples) throws IOException {
        ObjectOutputStream save = null;
        try{
            save = new ObjectOutputStream(new FileOutputStream(file));
            ArrayList<People> personSave = new ArrayList<>(peoples);
            save.writeObject(personSave);
        }finally {
            if(save != null){
                save.close();
            }
        }
    }

    public Collection<People> loadPerson() throws IOException, ClassNotFoundException {
        ObjectInputStream load = null;

        try{
            load = new ObjectInputStream(new FileInputStream(file));
            Collection<People> personLoad = (Collection<People>) load.readObject();
            return personLoad;
        }finally {
            if(load != null){
                load.close();
            }
        }
    }
}

