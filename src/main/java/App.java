import static spark.Spark.*;
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
        Hero.buildNewHero();
        Hero.buildNewHero1();
        Squad.buildNewSquad();
        Squad.buildNewSquad1();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "main.hbs");
        }, new HandlebarsTemplateEngine()
        );

        get("/Hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Hero-form.hbs");
        }, new HandlebarsTemplateEngine());



//        get("/Hero", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "Hero.hbs");
//        }, new HandlebarsTemplateEngine());

        get("/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("Hero", hero);
            return new ModelAndView(model, "Hero.hbs");
        }, new HandlebarsTemplateEngine());



        get("/Squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//
        get("/Squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            ArrayList<Hero> members = Hero.getInstances();
            Squad newSquad = squads.get(1);
            model.put("Hero", members);
            model.put("squadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "Squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadTag = request.queryParams("tag");
            Integer Total = Integer.parseInt(request.queryParams("total"));
            String Motive = request.queryParams("motive");
            Squad newSquad = new Squad(squadTag, Total, Motive);
            request.session().attribute("item", squadTag);
            model.put("item", request.session().attribute("item"));
            return new ModelAndView(model, "submit.hbs");
        }, new HandlebarsTemplateEngine());

        post("/new/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero buildHero = new Hero(name, age, power, weakness);
            request.session().attribute("item", name);
            model.put("item", request.session().attribute("item"));
            model.put("newHero", buildHero);
            return new ModelAndView(model, "submit.hbs");
        }, new HandlebarsTemplateEngine());








    }
}
