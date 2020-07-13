package org.tft;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObjectMapper objmapper = new ObjectMapper();
        String json = "[\n" +
                "  {\n" +
                "    \"name\" : \"cloth\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\" : \"leather\"\n" +
                "  }\n" +
                "]";
      //  List<Armor> alist = objmapper.readValue(json, TypeReference<List<Armor>>(){});


        Skill weaponexpertise = new Skill("Weapon Expertise",0,1,-1,0);
        Weapon shortsword = new Weapon("Short Sword", 2, -1);
        Weapon bastardsword1h = new Weapon("Bastard Sword 1H", 2, 1);
        Weapon bastardsword2h = new Weapon("Bastard Sword 2H", 2, 2);
        Armor leatherarmor = new Armor("Leather",2);
        Armor clotharmor = new Armor("Cloth", 1);
        Armor chainmail = new Armor("Chainmail",3);
        Armor halfplatearmor = new Armor("Half-plate Armor",4);

        Shield smallshield = new Shield("Small Shield",1);
        Shield largeshield = new Shield("Large Shield", 2);

        int statlow = 10;
        int stathigh = 13;

        Character c1 = new Character(Character.Type.CHARACTER, "Fighter - Nimble",statlow,stathigh);
        c1.setWeapon_primary(shortsword);
        c1.setArmor(leatherarmor);
        c1.setShield(smallshield);
        c1.setSkill(weaponexpertise);

        Character c2 = new Character(Character.Type.CHARACTER, "Fighter - Heavy Tank",stathigh,statlow);
        c2.setWeapon_primary(bastardsword1h);
        c2.setArmor(chainmail);
        c2.setShield(largeshield);
        c2.setSkill(weaponexpertise);

        Character c3 = new Character(Character.Type.CHARACTER, "Fighter - Medium Tank",stathigh,statlow);
        c3.setWeapon_primary(bastardsword1h);
        c3.setArmor(leatherarmor);
        c3.setShield(smallshield);
        c3.setSkill(weaponexpertise);

        Character c4 = new Character(Character.Type.CHARACTER, "Fighter - Super Heavy Tank",stathigh,statlow);
        c4.setWeapon_primary(bastardsword2h);
        c4.setArmor(halfplatearmor);
        c4.setSkill(weaponexpertise);


        Character m = new Character(Character.Type.MONSTER,"Common Black Bear",20,11);
        m.setWeapon_basic(new Weapon("Basic",2,0));
        m.setArmor(new Armor("Fur", 2,0));

        BattleRunner r = new BattleRunner(c1,m,10000);
        r.doRun();
        r.displayResults();

        r = new BattleRunner(c2,m,10000);
        r.doRun();
        r.displayResults();

        r = new BattleRunner(c3,m,10000);
        r.doRun();
        r.displayResults();

        r = new BattleRunner(c4,m, 10000);
        r.doRun();
        r.displayResults();
    }
}
