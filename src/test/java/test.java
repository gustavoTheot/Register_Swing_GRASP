import org.junit.jupiter.api.Test;
import sistem.SistemPeople;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    public void testRegister() {
        SistemPeople sistem = new SistemPeople();
        assertEquals(true, sistem.registerPeople("Maria", "maria@gmail.com", "11010"));
        assertEquals(true, sistem.registerPeople("Maria", "mariaEduarda@gmail.com", "11010"));
    }

    @Test
    public void testRemove(){
        SistemPeople sistem = new SistemPeople();
        sistem.registerPeople("Gustavo", "gustavo@gmail.com", "11010");
        assertEquals(true, sistem.removePeople("gustavo@gmail.com"));
    }

    @Test
    public void testView(){
        SistemPeople sistem = new SistemPeople();
        sistem.registerPeople("pedro", "pdero@gmail.com", "11010");
        sistem.registerPeople("pablo", "pablo@gmail.com", "11010");
        assertEquals(true, sistem.viewAllPeople().size() >= 1);
        assertTrue(sistem.getPeoples().size() > 0);
    }
}
