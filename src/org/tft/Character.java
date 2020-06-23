package org.tft;

import javax.print.attribute.standard.SheetCollate;
import java.awt.*;
import java.util.Random;

public class Character {
    String name = "";
    int strength = 0;
    int dexterity = 0;
    int tohit_dmg_bonus = 0;
    int toavoid_dx_bonus = 0;
    public enum Type { CHARACTER , MONSTER, NONE};
    Type type = Type.NONE;
    Shield shield = null;
    Armor armor = null;
    Weapon weapon_basic = null;
    Weapon weapon_primary = null;
    Weapon weapon_secondary = null;
    int tohitdxmods = 0;
    boolean missaturn = false;

    int hits = 0;

    static Random random = new Random();

    public Character(Type t, String n, int s, int d) {
        type = t;
        name = n;
        strength = s;
        dexterity = d;
    }
    public Type getType() {
        return type;
    }
    public void resetHits() {
        hits = 0;
    }
    public void applyHits(int h) {
        hits += Math.max(h - getHitsAvoided() , 0);
    }

    public boolean isDead() {
        return hits > strength;
    }

    public int getDexterityModified() {
        int dxm = dexterity;
        if(armor!=null) {
            dxm += armor.getDexterityModifier();
        }
        if(shield != null ) {
            dxm += shield.getDexterityModifier();
        }

        return dxm;
    }

    public void setWeapon_basic(Weapon w) {
        weapon_basic = w;
    }

    public void setWeapon_primary(Weapon w) {
        weapon_primary = w;
    }

    public void setWeapon_secondary(Weapon w) {
        weapon_secondary = w;
    }

    public void setArmor(Armor a) {
        armor = a;
    }

    public void setShield(Shield s) {
        shield = s;
    }

    public void setTohitDmgBonus(int db) {
        tohit_dmg_bonus = db;
    }
    public int getTohitDmgBonus() {
        return tohit_dmg_bonus;
    }
    public void setToavoidDxBonus(int dab) {
        toavoid_dx_bonus = dab;
    }
    public int getToavoidDxBonus() {
        return toavoid_dx_bonus;
    }
    public int getHitsAvoided() {
        int ha = 0;
        if(armor != null) {
            ha += armor.getHitsstopped();
        }
        if(shield != null) {
            ha += shield.getHitsstopped();
        }
        return ha;
    }

    public void attack(Character enemy) {

        if(weapon_basic != null) {
            attackWithWeapon(enemy,weapon_basic,0);
            missaturn = false;
        } else {
            if(missaturn) {
                missaturn = false;
                return;
            }           if(weapon_primary != null) {
                attackWithWeapon(enemy,weapon_primary,0);
            }
            if(weapon_secondary != null) {
                attackWithWeapon(enemy,weapon_secondary, -4);
            }
        }

    }

    private void attackWithWeapon(Character enemy, Weapon weapon, int dxmod ) {

        int roll = 0;
        roll += random.nextInt(6) + 1;
        roll += random.nextInt(6) + 1;
        roll += random.nextInt(6) + 1;
        switch (roll) {
            case 3:
                enemy.applyHits((weapon.generateHits() + getTohitDmgBonus()) * 3);
                break;
            case 4:
                enemy.applyHits((weapon.generateHits() + getTohitDmgBonus()) * 2);
                break;
            case 5:
                enemy.applyHits(weapon.generateHits() + getTohitDmgBonus());
                break;
            case 16:
                break;
            case 17:
                missaturn = true;
                break;
            case 18:
                missaturn = true;
                break;
            default:
                if(roll + dxmod <= getDexterityModified() + enemy.getToavoidDxBonus()) {
                    enemy.applyHits(weapon.generateHits() + getTohitDmgBonus());
                }
        }

    }

    public void displayCharacter() {
        System.out.println("'" + name + "' - ST(" +
                Integer.toString(strength) + "), DX(" +
                Integer.toString((dexterity)) + "|" + Integer.toString(getDexterityModified()) +") :");
        System.out.print("   ATTACK: ");
        if(weapon_basic != null) {

            weapon_basic.displayWeapon();
        }
        if(weapon_primary != null) {

            weapon_primary.displayWeapon();
        }
        if(weapon_secondary != null) {

            weapon_secondary.displayWeapon();
        }
        if(getTohitDmgBonus() > 0) {
            System.out.print(", To Hit Damage Bonus = " + Integer.toString(getTohitDmgBonus()));
        }
        System.out.println();
        System.out.print("   DEFENSE: ");
        if(armor != null) {

            armor.displayArmor();
        }
        if(shield != null) {
            System.out.print(", ");
            shield.displayShield();
        }
        if(getToavoidDxBonus() < 0) {
            System.out.print(", To Avoid Dexterity Bonus = " + Integer.toString(getToavoidDxBonus()));
        }
        System.out.println();
    }
}
