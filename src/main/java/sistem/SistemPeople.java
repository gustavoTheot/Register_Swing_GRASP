package sistem;

import java.util.*;

public class SistemPeople implements SistemPeopleInterface{
    private Map<String, People> peoples;

    public SistemPeople(){
        this.peoples = new HashMap<>();
    }

    public Collection<People> getPeoples() {
        return this.peoples.values();
    }

    @Override
    public boolean registerPeople(String name, String email, String password) {
        if(!peoples.containsKey(email)){
            this.peoples.put(email, new People(name, email, password));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<People> viewAllPeople() {
        List<People> allPeoples = new ArrayList<>();
        for(People p : this.peoples.values()){
            allPeoples.add(p);
        }

        return allPeoples;
    }

    @Override
    public boolean removePeople(String email) {
        if(this.peoples.containsKey(email)){
            this.peoples.remove(email);
            return true;
        }else{
            return false;
        }

    }
}
