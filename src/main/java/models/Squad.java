package models;

 import java.util.ArrayList;

public class Squad {

    private int squadId;
    private String squadTag;
    private int squadTotal;
    private String Motive;

    private ArrayList<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(String tag, int total, String motive ) {
        squadTag = tag;
        squadTotal = total;
        this.Motive = motive;
        this.squadMembers = new ArrayList<>();
        instances.add(this);
        this.squadId = instances.size();
    }

    public int getSquadId() {
        return squadId;
    }
    public static Squad findBySquadId(int id) {
        return instances.get(id-1);
    }

    public String getSquadTag() {
        return squadTag;
    }

    public int getSquadTotal() {
        return squadTotal;
    }

    public String getMotive() {
        return this.Motive;
    }

    public  static ArrayList<Squad>getInstances() {
        return instances;
    }

    public ArrayList<Hero> getSquadMembers() {
        return squadMembers;
    }

    public void setSquadMembers(Hero newHero) {
        squadMembers.add(newHero);
    }

    public static void clearAllSquads() {
        instances.clear();
    }

    public void clearAllSquadsMembers() {
        getSquadMembers().clear();
    }

    public static Squad buildNewSquad() {
        return new Squad("Infinite", 5, "Feminism");
    }

    public static Squad buildNewSquad1() {
        return new Squad("Karel", 5, "Protect Humans");
    }

    public static Squad buildNewSquad2() {
        return new Squad("Guardians of the Galaxy", 5, "Galaxy Warriors");
    }

}
