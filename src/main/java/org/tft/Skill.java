package org.tft;

public class Skill {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttdexmod() {
        return attdexmod;
    }

    public void setAttdexmod(int attdexmod) {
        this.attdexmod = attdexmod;
    }

    public int getAttdammod() {
        return attdammod;
    }

    public void setAttdammod(int attdammod) {
        this.attdammod = attdammod;
    }

    public int getDefdexmod() {
        return defdexmod;
    }

    public void setDefdexmod(int defdexmod) {
        this.defdexmod = defdexmod;
    }

    public int getDefdammod() {
        return defdammod;
    }

    public void setDefdammod(int defdammod) {
        this.defdammod = defdammod;
    }

    private String name = "none";
    private int attdexmod = 0;
    private int attdammod = 0;
    private int defdexmod = 0;
    private int defdammod = 0;
    public Skill() {
    }
    public Skill(String n, int adex, int adam, int ddex, int ddam) {
        name = n;
        attdexmod = adex;
        attdammod = adam;
        defdexmod = ddex;
        defdammod = ddam;
    }

    public void displaySkill() {
        System.out.print(name);
        if(attdexmod != 0) {
            System.out.print(" {Attack Dex Modifier:" + attdexmod + "}");
        };
        if(attdammod != 0) {
            System.out.print(" {Attack Dam Modifier:" + attdammod + "}");
        };
        if(defdexmod != 0) {
            System.out.print(" {Defense Dex Modifier:" + defdexmod + "}");
        };
        if(defdammod != 0) {
            System.out.print(" {Defense Dam Modifier:" + defdammod + "}");
        };

    }
}
