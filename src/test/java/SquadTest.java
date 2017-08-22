import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Squad mySquad = new Squad("Heros squad");
    assertEquals(true, mySquad instanceof Squad);
  }

  @Test
  public void Squad_instantiatesWithName_String() {
  	Squad mySquad = new Squad("Heros squad");
  	assertEquals("Heros squad", mySquad.getName());
  }

  @Test
  public void Squad_instantiatesWithAge_int() {
  	Squad mySquad = new Squad(100);
  	assertEquals(100, mySquad.getAge());
  }

  @Test
  public void getId_herosInstantiateWithId_1() {
  	Squad.clear();
  	Squad mySquad = new Squad("Heros squad");
  	assertEquals(1, mySquad.getId());
  }

  @Test
  public void find_returnsSquadWithSameId_secondSquad() {
  	Squad firstSquad = new Squad("Heros squad");
  	Squad secondSquad = new Squad("Another heros squad");
  	assertEquals(Squad.find(secondSquad.getId()), secondSquad);
  }

}	