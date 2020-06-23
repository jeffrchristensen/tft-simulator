package org.tft;
import org.tft.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Character c = null;
        Character m = null;

        c = new Character(Character.Type.CHARACTER, "Fighter",11,14);
        c.setWeapon_primary(new Weapon("Short Sword",2,-1));
        c.setArmor(new Armor("Leather Armor",2));
        c.setShield(new Shield("Small Shield",1));
        c.setToavoidDxBonus(-1);
        c.setTohitDmgBonus(1);


        m = new Character(Character.Type.MONSTER,"Common Black Bear",20,11);
        m.setWeapon_basic(new Weapon("Basic",2,0));
        m.setArmor(new Armor("Fur", 2,0));

        Run r = new Run(c,m,10000);
        r.doRun();
        r.displayResults();
    }
}
