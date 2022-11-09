package sistem;

import java.util.Collection;

public interface SistemPeopleInterface {
    public boolean registerPeople(String name, String email, String password);
    public Collection<People> viewAllPeople();
    public boolean removePeople(String email);
}
