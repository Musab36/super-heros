import org.junit.*;
import static org.junit.Assert.*;

public class CategoryTest {

  @Test
  public void category_instantiatesCorrectly_true() {
    Category testCategory = new Category("monsters");
    assertEquals(true, testCategory instanceof Category);
  }

  @Test
  public void getName_categoryInstantiatesWithName_Monsters() {
    Category testCategory = new Category("Monsters");
    assertEquals("Monsters", testCategory.getName());
  }

  @Test
  public void all_returnsAllInstancesOfCategory_true() {
    Category firstCategory = new Category("Monsters");
    Category secondCategory = new Category("Underground");
    assertEquals(true, Category.all().contains(firstCategory));
    assertEquals(true, Category.all().contains(secondCategory));
  }

  @Test
  public void clear_emptiesAllCategoriesFromList_0() {
    Category testCategory = new Category("Monsters");
    Category.clear();
    assertEquals(Category.all().size(), 0);
  }

  @Test
  public void getId_categoriesInstantiateWithAnId_1() {
    Category testCategory = new Category("Monsters");
    assertEquals(1, testCategory.getId());
  }

  @Test
  public void find_returnsCategoryWithSameId_secondCategory() {
    Category.clear();
    Category firstCategory = new Category("Monsters");
    Category secondCategory = new Category("Underground");
    assertEquals(Category.find(secondCategory.getId()), secondCategory);
  }

  @Test
public void getTasks_initiallyReturnsEmptyList_ArrayList() {
  Category.clear();
  Category testCategory = new Category("Monsters");
  assertEquals(0, testCategory.getHeros().size());
}

@Test
public void addTask_addsHeroToList_true() {
  Category testCategory = new Category("Monsters");
  Squad testHero = new Squad("Heros", 100, 100, "course", "weakness");
  testCategory.addHero(testHero);
  assertTrue(testCategory.getHeros().contains(testHero));
}
}