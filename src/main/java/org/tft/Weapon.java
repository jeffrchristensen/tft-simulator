package org.tft;

import java.util.Random;

public class Weapon {
    private String name = "";
    private int dice = 0;
    private int dicemod = 0;
    private static Random random = new Random();

    public Weapon(String l, int ad, int adm) {
        name = l;
        dice = ad;
        dicemod = adm;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getDicemod() {
        return dicemod;
    }

    public void setDicemod(int dicemod) {
        this.dicemod = dicemod;
    }

    public void displayWeapon() {
        if(dicemod < 0) {
            System.out.print(name + " (" +
                    Integer.toString(dice) + "d" + Integer.toString(dicemod) + ")");
        } else if(dicemod > 0) {
            System.out.print(name + " (" +
                    Integer.toString(dice) + "d+" + Integer.toString(dicemod) + ")");
        } else {
            System.out.print(name + " (" +
                    Integer.toString(dice) + "d6)");
        }
    }

    public int generateHits() {
        int hits = 0;
        for(int i = 0; i < dice; i++) {
            hits += Math.max(random.nextInt(6) + 1 + dicemod,1);
        }
        return hits;
    }
}
