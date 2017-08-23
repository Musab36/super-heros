import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

  @Test
  public void Task_instantiatesCorrectly_true() {
    Squad mySquad = new Squad("Heros squad", 100, 100, "course", "weakness");
    assertEquals(true, mySquad instanceof Squad);
  }
      

  @Test
  public void all_returnsAllInstancesOfHeros_true() {
      Squad firstHero = new Squad("Heros", 100, 100, "course", "weakness");
      Squad secondHero = new Squad("second heros", 100, 100, "course", "weakness");
      assertEquals(true, Squad.all().contains(firstHero));
      assertEquals(true, Squad.all().contains(secondHero));
    }
 
  @Test
  public void getId_herosInstantiateWithId_1() {
  	Squad.clear();
  	Squad mySquad = new Squad("Heros squad", 100, 100, "course", "weakness");
  	assertEquals(1, mySquad.getId());
  }

 @Test
  public void find_returnHeroWithSameId_secondHero() {
      Squad firstHero = new Squad("Heros", 100, 100, "course", "weakness");
      Squad secondHero = new Squad("Second heros", 100, 100, "course", "weakness");
      assertEquals(Squad.find(secondHero.getId()),secondHero);
      }

}	