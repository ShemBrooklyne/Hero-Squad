import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
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
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/Hero",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Hero> Hero = Hero.getAllInstances();
//            model.put("Hero",Hero);
//            return new ModelAndView(model, "hero.hbs");
//        }, new HandlebarsTemplateEngine());



        get("/Squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "Squad-form.hbs");
        }, new HandlebarsTemplateEngine());

//        get("/Squad",(req, res) ->{
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Squad> squads = Squad.getInstances();
//            model.put("squad",Squad);
//            ArrayList<Hero> members = Hero.getAllInstances();
//            model.put("hero",members);
//            model.put("allSquadMembers", newSquad.getSquadMembers());
//            return new ModelAndView(model, "Squad.hbs");
//        }, new HandlebarsTemplateEngine());





    }
}
