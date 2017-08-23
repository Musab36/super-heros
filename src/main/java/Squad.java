import java.util.ArrayList;
public class Squad {
private String mName;
private int mAge;
private int mPower;
private String mCourse;
private String mWeakness;
private static ArrayList<Squad> instances = new ArrayList<Squad>();
private int mId;

  public Squad(String name, int age, int power, String course, String weakness) {
  	mName = name;
    mAge = age;
    mPower = power;
    mCourse = course;
    mWeakness = weakness;
  	instances.add(this);
  	mId = instances.size();
  }

  public String getName() {
  	return mName;
  }

  public int getPower() {
    return mPower;
  }

  public int getAge() {
  	return mAge;
  }

  public String getCourse() {
    return mCourse;
  }

  public String getWeakness() {
    return mWeakness;
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