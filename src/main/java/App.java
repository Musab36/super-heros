import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("heros", request.session().attribute("heros")); //We are retrieving the squad from the session
    	model.put("template", "templates/index.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("categories/:id/heros/new", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
       Category category = Category.find(Integer.parseInt(request.params(":id")));
       model.put("category", category);
       model.put("template", "templates/category-heros-form.vtl");
       return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();
    	model.put("heros", Squad.all()); // We are placing the ArrayList of all heros into the model making it available to the template
    	model.put("template", "templates/heros.vtl");
    	return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/heros/:id", (request, response) -> { //This route will be executed when someone clicks a link to see a hero's detail page
        Map<String, Object> model = new HashMap<String, Object>();
        Squad hero = Squad.find(Integer.parseInt(request.params(":id"))); // Retrieves the value currently represented by :id, since the value is a string, we converted it into an int
        model.put("hero", hero);
        model.put("template", "templates/hero.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/heros", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        ArrayList<Squad> heros = request.session().attribute("heros");
        if (heros == null) { // We are retrieving an ArrayList from the session saved under the key "heros"
            heros = new ArrayList<Squad>(); // If that ArrayList does not exist yet, we create a new one 
            request.session().attribute("heros", heros); // And add it to the session
        }

        String name = request.queryParams("name"); // Saving user inputted hero name into a String
        int age = Integer.parseInt(request.queryParams("age"));
        int power = Integer.parseInt(request.queryParams("power"));
        String course = request.queryParams("course");
        String weakness = request.queryParams("weakness");
        Squad newSquad = new Squad(name, age, power, course, weakness); // Squad constructorcreating new squad with the user's provided name
        request.session().attribute("hero", "newSquad"); // We then save the squad object into the user's session
        heros.add(newSquad); // we create our Squad object and add it into the heros ArrayList


        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Category creation

    get("/categories/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/category-form.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    // Posting categories into the app

    post("/categories", (request, response) -> {
         Map<String, Object> model = new HashMap<String, Object>();
         String name = request.queryParams("name");
         Category newCategory = new Category(name);
         model.put("template", "templates/category-success.vtl");
         return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    
    // Listing all categories

    get("/categories", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("categories", Category.all());
        model.put("template", "templates/categories.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // Category details page

    get("/categories/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Category category = Category.find(Integer.parseInt(request.params(":id")));
        model.put("category", category);
        model.put("template", "templates/category.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/tasks", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();

       Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));

       String name = request.queryParams("name"); // Saving user inputted hero name into a String
        int age = Integer.parseInt(request.queryParams("age"));
        int power = Integer.parseInt(request.queryParams("power"));
        String course = request.queryParams("course");
        String weakness = request.queryParams("weakness");
        Squad newSquad = new Squad(name, age, power, course, weakness); // Squad constructorcreating new squad with the user's provided name
        request.session().attribute("hero", "newSquad"); // We then save the squad object into the user's session

       category.addHero(newSquad);

       model.put("category", category);
       model.put("template", "templates/category-heros-success.vtl");
       return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());
    
  }
}