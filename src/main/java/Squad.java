import java.util.ArrayList;
public class Squad {
private String mName;
private int mAge;
private static ArrayList<Squad> instances = new ArrayList<Squad>();
private int mId;

  public Squad(String name, int age) {
  	mName = name;
    mAge = age;
  	instances.add(this);
  	mId = instances.size();
  }

  public String getName() {
  	return mName;
  }

  public int getAge() {
  	return mAge;
  }

  public static ArrayList<Squad> all() {
  	return instances;
  }

  public static void clear() {
  	instances.clear();
  }

  public int getId() {
  	return mId;
  }

  public static Squad find(int id) {
  	return instances.get(id - 1);
  }

}