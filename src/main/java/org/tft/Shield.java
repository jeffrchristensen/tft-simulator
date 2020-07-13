package org.tft;

public class Shield {
    private String name = "";
    private int dmgmod = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDmgmod(int dmgmod) {
        this.dmgmod = dmgmod;
    }

    public Shield(String l, int hs) {
        name = l;
        dmgmod = hs;
    }
    public int getDmgmod() {
        return dmgmod;
    }
    public int getDexmod() {
        return -(dmgmod - 1);
    }
    public void displayShield() {
        System.out.print(name + "(" + dmgmod + ")");
        System.out.print(" {" + Integer.toString(getDexmod()) + " DX}");
    }
}
