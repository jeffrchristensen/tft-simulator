package org.tft;

import java.util.Random;

public class Character {
    private static Random random = new Random();

    private String name = "";
    private int strength = 0;
    private int dexterity = 0;

    //int tohit_dmg_bonus = 0;
    //int toavoid_dx_bonus = 0;
    public enum Type { CHARACTER , MONSTER, NONE};
    private Type type = Type.NONE;
    private Shield shield = null;
    private Armor armor = null;
    private Skill skill = new Skill();
    private Weapon weapon_basic = null;
    private Weapon weapon_primary = null;
    private Weapon weapon_secondary = null;
    // int tohitdxmods = 0;
    // boolean missaturn = false;

    // int hits = 0;
    public class BattleCharacter {
        private int hits = 0;
        private boolean missaturn = false;
        private int lastdmg = 0;
        public BattleCharacter engaged = null;
        public BattleCharacter() {
        }
        public void setEngaged(BattleCharacter e) {
            engaged = e;
        }
        public boolean isDead() {
            return hits > Character.this.getStrength();
        }
        public void missaturn() {
            missaturn = true;
        }
        public void applyHits(int h) {
            hits += h;
            lastdmg = h;
        }
        public Character getCharacter() {
            return Character.this;
        }
        public int getDexterity() {
            if (lastdmg > 2) {
                return Character.this.getDexterity() - 2;
            }
            return Character.this.getDexterity();
        }
        public void attack() {
            lastdmg = 0;
            if(weapon_basic != null) {
                attackWithWeapon(weapon_basic,0);
                missaturn = false;
            } else {
                if(missaturn) {
                    missaturn = false;
                    return;
                }           if(weapon_primary != null) {
                    attackWithWeapon(weapon_primary,0);
                }
                if(weapon_secondary != null) {
                    attackWithWeapon(weapon_secondary, -4);
                }
            }

        }
        private void attackWithWeapon(Weapon weapon, int dxmod ) {

            int roll = 0;
            roll += random.nextInt(6) + 1;
            roll += random.nextInt(6) + 1;
            roll += random.nextInt(6) + 1;
            switch (roll) {
                case 3:
                    engaged.applyHits((weapon.generateHits() + getCharacter().getSkill().getAttdammod()) * 3);
                    break;
                case 4:
                    engaged.applyHits((weapon.generateHits() + getCharacter().getSkill().getAttdammod()) * 2);
                    break;
                case 5:
                    engaged.applyHits(weapon.generateHits() + getCharacter().getSkill().getAttdammod());
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
                    if(roll + dxmod <= getDexterityModified() + getCharacter().getSkill().getAttdexmod()) {
                        engaged.applyHits(weapon.generateHits() + getCharacter().getSkill().getAttdammod());
                    }
            }

        }
    }


    public Character(Type t, String n, int s, int d) {
        type = t;
        name = n;
        strength = s;
        dexterity = d;
    }
    public Type getType() {
        return type;
    }
    /*
    public void resetHits() {
        hits = 0;
    }
    public void applyHits(int h) {
        hits += Math.max(h - getHitsAvoided() , 0);
    }
*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterityModified() {
        int dxm = dexterity;
        if(armor!=null) {
            dxm += armor.getDexmod();
        }
        if(shield != null ) {
            dxm += shield.getDexmod();
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
    public void setSkill(Skill s) {
        skill = s;
    }
    public Skill getSkill() {
        return skill;
    }
/*
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

 */
    public int getHitsAvoided() {
        int ha = 0;
        if(armor != null) {
            ha += armor.getDmgmod();
        }
        if(shield != null) {
            ha += shield.getDmgmod();
        }
        return ha;
    }

    public int getHits() {
        return getStrength();
    }

    public BattleCharacter getBattlecharacter() {
        return new BattleCharacter();
    }

    public void displayCharacter() {
        System.out.println("'" + name + "' - ST(" +
                Integer.toString(strength) + "), DX(" +
                Integer.toString((dexterity)) + "|" + Integer.toString(getDexterityModified()) +") :");
        System.out.print("   SKILLS: ");
        if(skill != null ) {
            skill.displaySkill();
        }
        System.out.println();
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
        System.out.println();
        System.out.print("   DEFENSE: ");
        if(armor != null) {

            armor.displayArmor();
        }
        if(shield != null) {
            System.out.print(", ");
            shield.displayShield();
        }
        System.out.println();
    }
}
