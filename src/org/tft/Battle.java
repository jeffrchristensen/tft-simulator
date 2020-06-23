package org.tft;

import java.awt.image.AffineTransformOp;
import java.util.Random;

public class Battle {
    private Character character = null;
    private Character monster = null;

    private Character.Type winner = Character.Type.NONE;
    private int duration = 0;

    public Battle(Character c, Character m) {
        character = c;
        monster = m;
        character.resetHits();
        monster.resetHits();
    }

    public void doBattle() {
        winner = Character.Type.NONE;
        Random rd = new Random();
        while (!(character.isDead() || monster.isDead())) {
            duration++;
            boolean charinitiative = rd.nextBoolean();
            Character first = null;
            Character second = null;
            if(character.getDexterityModified() > monster.getDexterityModified() ) {
                first = character;
                second = monster;
            } else if (monster.getDexterityModified() > character.getDexterityModified()) {
                first = monster;
                second = character;
            } else if (charinitiative) {
                first = character;
                second = monster;
            } else {
                first = monster;
                second = character;
            }
            first.attack(second);
            if(!second.isDead()) {
                second.attack(first);
                if(first.isDead()) {
                    // second is winner
                    winner = second.getType();
                    return;
                }
            } else {
                // first is winner
                winner = first.getType();
                return;
            }
            if(duration > 50) {
                return;
            }
        }
    }

    public Character.Type getWinner() {
        return winner;
    }

    public int getDuration() {
        return duration;
    }

}
