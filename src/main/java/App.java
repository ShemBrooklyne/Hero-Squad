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


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {


        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        staticFileLocation("/public");
        Hero.buildNewHero();
        Hero.buildNewHero1();
        Squad.buildNewSquad();
        Squad.buildNewSquad1();

//        main page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(new HashMap(), "main.hbs");
        }, new HandlebarsTemplateEngine()
        );

//        Hero form for filling
        get("/Hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//The Heroes page, where all are displayed
        get("/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("Hero", hero);
            return new ModelAndView(model, "Hero.hbs");
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



//Form for registering a squad
        get("/Squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//The Squads page, where all squads are displayed
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

        post("/new/squad",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadTag = request.queryParams("squadTag");
            Integer squadTotal = Integer.parseInt(request.queryParams("squadTotal"));
            String motive = request.queryParams("motive");
            Squad buildSquad = new Squad(squadTag, squadTotal, motive);
            request.session().attribute("item", squadTag);
            model.put("item", request.session().attribute("item"));
            model.put("newSquad", buildSquad);
            return new ModelAndView(model, "submit.hbs");
        }, new HandlebarsTemplateEngine());

//
    }
}
