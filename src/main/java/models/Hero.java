package models;

import java.util.ArrayList;

public class Hero {

    private String name;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero (String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
    }



    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPower() {
        return this.power;
    }

    public String getWeakness() {
        return this.weakness;
    }

    public static ArrayList<Hero> getInstances() {
        return instances;
    }

    public static void clearHeroes() {
        instances.clear();
    }

    public static Hero buildNewHero() {
        return new Hero("Darnell", 22, "Super Speed", "Ice");
    }

    public static Hero buildNewHero1() {
        return new Hero("Cindy", 16, "Invincibility", "Light");
    }

    public static Hero buildNewHero2() {
        return new Hero("Shaw", 27, "Super Strength", "Kryptonite");
    }

    public static Hero buildNewHero3() {
        return new Hero("Janelle", 19, "Flying", "Bad Weather");
    }

    public static Hero buildNewHero4() {
        return new Hero("Wallace", 32, "X-Ray Vision", "Lead materials");
    }

}
