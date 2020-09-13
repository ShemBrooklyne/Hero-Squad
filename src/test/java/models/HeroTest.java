package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    @Test
    public void newHero_instantiatesCorrectly_true() {
        Hero newHero = Hero.buildNewHero();
        assertTrue(true);
    }

    private void assertTrue(boolean b) {
    }

    @Test
    public void newHero_getName_String() {
        Hero newHero = Hero.buildNewHero();
        assertEquals("Darnell", newHero.getName());
    }

    @Test
    public void newHero_getAge_Integer() {
        Hero newHero = Hero.buildNewHero();
        assertEquals(22, newHero.getAge());
    }

    @Test
    public void newHero_getPower_String() {
        Hero newHero = Hero.buildNewHero();
        assertEquals("Super Speed", newHero.getPower());
    }

    @Test
    public void newHero_getWeakness_String() {
        Hero newHero = Hero.buildNewHero();
        assertEquals("Ice", newHero.getWeakness());
    }

    @Test
    public void newHero_getInstances_true() {
        Hero newHero = Hero.buildNewHero();
        Hero newChar = Hero.buildNewHero();
        Hero newChar1 = Hero.buildNewHero();
        Hero newChar2 = Hero.buildNewHero();
        Hero newChar3 = Hero.buildNewHero();
//        assertEquals(5, newChar.newChar());
    }
}

