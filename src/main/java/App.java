import static spark.Spark.get;
import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "main.hbs");
        }, new HandlebarsTemplateEngine()
        );

        get("/Hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/Hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Hero> Hero = Hero.getAllInstances();
//            model.put("Hero",Hero);
//            return new ModelAndView(model, "Hero.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Hero.hbs");
        }, new HandlebarsTemplateEngine());



        get("/Squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/Squad",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Squad> squad = Squad.getInstances();
//            model.put("squad",Squad);
//            ArrayList<Hero> members = Hero.getAllInstances();
//            model.put("hero",members);
//            model.put("allSquadMembers", newSquad.getSquadMembers());
//            return new ModelAndView(model, "Squad.hbs");
//        }, new HandlebarsTemplateEngine());

//        post("/new/hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            String name = req.queryParams("name");
//            Integer age = Integer.parseInt(req.queryParams("age"));
//            String power = req.queryParams("power");
//            String weakness = req.queryParams("weakness");
//            Hero newHero = new Hero(name,age,power,weakness);
//            req.session().attribute("item",name);
//            model.put("item",req.session().attribute("item"));
//            model.put("newHero",newHero);
//            return new ModelAndView(model, "submit.hbs");
//        }, new HandlebarsTemplateEngine());






    }
}
