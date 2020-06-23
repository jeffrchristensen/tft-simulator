package org.tft;

import java.util.Random;

public class Weapon {
    String label = null;
    int attackdice = 0;
    int attackdicemodifier = 0;
    static Random random = new Random();

    public Weapon(String l, int ad, int adm) {
        label = l;
        attackdice = ad;
        attackdicemodifier = adm;
    }

    public void displayWeapon() {
        if(attackdicemodifier < 0) {
            System.out.print(label + " (" +
                    Integer.toString(attackdice) + "d" + Integer.toString(attackdicemodifier) + ")");
        } else if(attackdicemodifier > 0) {
            System.out.print(label + " (" +
                    Integer.toString(attackdice) + "d+" + Integer.toString(attackdicemodifier) + ")");

        } else {
            System.out.print(label + " (" +
                    Integer.toString(attackdice) + "d6)");
        }
    }

    public int generateHits() {
        int hits = 0;
        for(int i = 0; i < attackdice; i++) {
            hits += Math.max(random.nextInt(6) + 1 + attackdicemodifier,1);
        }
       //System.out.println("hit: " + label + " : " + Integer.toString(hits));
        return hits;
    }
}
