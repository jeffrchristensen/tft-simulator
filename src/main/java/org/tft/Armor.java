package org.tft;

public class Armor {
    private String name = "";
    private int dmgmod = 0;
    private int dexmod = 0;

    public String getName() {
        return name;
    }

    public int getDmgmod() {
        return dmgmod;
    }

    public int getDexmod() {
        return dexmod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDmgmod(int dmgmod) {
        this.dmgmod = dmgmod;
    }

    public void setDexmod(int dexmod) {
        this.dexmod = dexmod;
    }

    public Armor(String l, int a) {
        name = l;
        dmgmod = a;
        dexmod = -a;
    }
    public Armor(String l, int a, int dm) {
        name = l;
        dmgmod = a;
        dexmod = dm;
    }

    public void displayArmor() {
        System.out.print(name + " (" + dmgmod + ")");
        System.out.print(" {" + Integer.toString(dexmod) + " DX}");
    }
}
