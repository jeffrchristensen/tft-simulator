package org.tft;

public class Armor {
    String label = "";
    int armorvalue = 0;
    int dexmodifier = 0;
    public Armor(String l, int a) {
        label = l;
        armorvalue = a;
        dexmodifier = -a;
    }
    public Armor(String l, int a, int dm) {
        label = l;
        armorvalue = a;
        dexmodifier = dm;
    }
    public int getHitsstopped() {
        return armorvalue;
    }
    public int getDexterityModifier() {
        return dexmodifier;
    }
    public void displayArmor() {
        System.out.print(label + " (" + armorvalue + ")");
        System.out.print(" {" + Integer.toString(dexmodifier) + " DX}");
    }
}
